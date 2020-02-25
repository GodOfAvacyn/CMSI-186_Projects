/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* @author Aiden Meyer
* @version 1.0.0
* 
* DESCRIPTION:
* This class incorporates objects from the Ball, Field, and Clock classes to describe a single instance of a Soccer 
* Simulation. Some number of balls will be created on the field and then they will be all set in motion. The simulation
* ends when:
* 		1) All balls come to a rest.
* 		2) All balls leave the field.
*		3) One ball touches another ball OR the pole in the field.
* 
* METHODS:
* public SoccerSim (double[] data, int xBoundary, int yBoundary)   The constructor for the simulation.                   1
* public void tellTime()                                           Prints the time elapsed in a readable form.           2
* public static void main (String[] args)                          The main method of the class.                         3
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ **/
public class SoccerSim {
	
	// Fields
	public Ball[] balls = null;
	public Clock clock = null;
	public Field field = null;

	/**
	* Constructor
	* @param data double array holding all of the user inputs from args.
	**/
	public SoccerSim (double[] data, int xBoundary, int yBoundary) {                                                  // 1
		
		// Errors
		if (data.length < 4) {
			throw new IllegalArgumentException("No balls created");
		}
		if (data.length%4 == 2 || data.length%4 == 3) {
			throw new IllegalArgumentException("Illegal number of args");
		}
		if (data.length/4 >= 4013) {
			throw new IllegalArgumentException("Too many balls");
		}
		
		// Class field instanciation
		if (data.length%4 == 1) {
			double ticValue = data[data.length - 1];
			clock = new Clock(ticValue);
		} else {
			clock = new Clock(1.0);
		}
		field = new Field(xBoundary, yBoundary);
		balls = new Ball[data.length/4];

		// Creating data that we play with to make each ball.
		int index;
		double xPosition; double yPosition;
		double xVelocity; double yVelocity;
		
		// Every 4 characters in data describe a new ball, so...
		for (int i = 0; i < ( data.length/4 ); i++) {
			index = i + 1;
			xPosition = data[4*i + 0];
			yPosition = data[4*i + 1];
			xVelocity = data[4*i + 2];
			yVelocity = data[4*i + 3];
			balls[i] = new Ball(index, xPosition, yPosition, xVelocity, yVelocity, xBoundary, yBoundary);
		}
	}

	/**
	* Tells the time in a readable form
	**/
	public void tellTime() {                                                                                          // 2
		System.out.println("\nTime passed: " + clock.toString() + "\n");
	}

	/**
	* Main method; creates a Soccer Sim and runs everything
	* @param args input from the command line
	**/
	public static void main (String[] args) {                                                                         // 3

		// Setting up our inputs
		int xBoundary = 1000;
		int yBoundary = 1000;
		double[] argsToData = new double[args.length];
		for (int i = 0; i < args.length; i++) {
			argsToData[i] = Double.parseDouble(args[i]);
		}
		
		// Main object
		try {
			SoccerSim sim = new SoccerSim(argsToData, xBoundary, yBoundary);

			// Prints all our initial data
			System.out.printf("%47s%n", "INITIAL REPORT");
			System.out.println("--------------------------------------------------------------------------------");
			String sayName = String.format("%-23s", "BALL NAME");
			String sayPosition = String.format("%-35s", "POSITION (in feet)");
			String sayVelocity = "VELOCITY (in feet/sec)";
			System.out.println(sayName + sayPosition + sayVelocity + "\n");
			System.out.println( Ball.toString(sim.field.pole) );


			// MORE local variables
			Boolean shouldBreak = false;
			int stoppedBalls = 0;
			int offBalls = 0;
			int loops = 0;

			while (true) {
			
				// When all balls stop...
				for (Ball b : sim.balls) {
					if (b.isMoving() == false ) {
						stoppedBalls ++;
				}	}
				if (stoppedBalls == sim.balls.length) {
					System.out.println("END SIMULATION: all balls have stopped.\n");
					shouldBreak = true;
				} else {
					stoppedBalls = 0;
					}

				// When all balls leave the field...
				for (Ball b : sim.balls) {
					if (b.isOff()) {
						offBalls++;
				}	}
				if (offBalls == sim.balls.length) {
						System.out.println("END SIMULATION: all balls have left the field.\n");
						shouldBreak = true;
				} else {
					offBalls = 0;
					}

				// When balls (or poles) collide...
				for (Ball b : sim.balls) {

					// Compares all balls to ball i
					for (Ball bi : sim.balls) {
						if (b != bi) {
						if ( Ball.areTouching(b, bi) ) {
							System.out.println("END SIMULATION: " + b.name + " and " + bi.name + " have collided.\n");
							shouldBreak = true;
							break;
						}}
					} if (shouldBreak) {break;}
				
					// Checks the pole for collisions
					if ( Ball.areTouching(b, sim.field.pole) ) {
						System.out.println("END SIMULATION: " + b.name + " has hit the pole.\n");
						shouldBreak = true;
						break;
					}
				}

				if (shouldBreak) {
					System.out.printf("%47s%n", "FINAL REPORT");
					System.out.println("--------------------------------------------------------------------------------");
					System.out.println(sayName + sayPosition + sayVelocity + "\n");
					Ball.toString(sim.field.pole);

					for (Ball b : sim.balls) {
						System.out.println(Ball.toString(b));
					}
					sim.tellTime();	
					System.out.println("The simulation took " + Integer.toString(loops) + " iterations to complete.");
					break;
				}

				// Performs the main incrementation
				for (Ball b : sim.balls) {
					System.out.println(Ball.toString(b));
					b.move(sim.clock.getTick());
				}

				// End of the loop
				sim.tellTime();
				sim.clock.moveForward();
				loops++;

		}	} catch (IllegalArgumentException iae) {
			System.out.println("Sorry! Looks like you didn't enter your data in correctly. Try again another day!");
		}
	}
}