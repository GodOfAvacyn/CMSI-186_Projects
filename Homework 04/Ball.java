/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* @author Aiden Meyer
* @version 1.0.0

* DESCRIPTION:
* This class describest the size, position, and velocity of a single ball. Note that all space is measuremed in
* FEET and time in SECONDS. A ball's speed decreases over time.
*
* METHODS:
* public Ball (int index, double xPos, double yPos, double xVel,    The constructor method for our ball.          1
			   double yVel, double xBound, double yBound)             	    
* public void move (double tic, double xBound, double yBound)	    Moves our ball and slows its speed.		      2
* public String toString()                                          Returns our ball's data in string form.       3
* public static String toString()                                   Classwide version of toString.                4
* public Boolean isMoving()                                         Checks to see if a ball is moving.            5
* public Boolean isOff()								            Checks to see if a ball is out of bounds.     6
* public static Boolean areTouching (Ball b1, Ball b2)              Checks to see if two balls are touching.      7
* public static void main (String args[])                           Tests the ball class.                         8
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ **/
public class Ball {

	// Classwide fields
	public static double inch = 1.0/12.0;
	public static double radius = inch*4.5;
	public static double friction = 0.99;
	
	// Object fields
	public String name;
	public double xPosition;
	public double yPosition;
	private double xVelocity;
	private double yVelocity;
	private double xBound;
	private double yBound;

	/**
	* Constructor
	* @param index integer value describing the number of the ball
	* @param xPos double value describing x position
	* @param yPos double value describing y position
	* @param xVel double value describing x velocity
	* @param yVel double value describing y velocity
	* @param xBound double describing the bounds of the playfield
	* @param yBound double describing the bounds of the playfield
	**/
	public Ball (int index, double xPos, double yPos,											               // 1
				 double xVel, double yVel, double xBound, double yBound) {
		
		// Errors
		if (xPos >= xBound || yPos >= yBound) {
			throw new IllegalArgumentException("Ball out of bounds");
		}

		// Instantiation
		this.name = "Ball " + Integer.toString(index);
		this.xPosition = xPos;
		this.yPosition = yPos;
		this.xVelocity = xVel;
		this.yVelocity = yVel;
		this.xBound = xBound;
		this.yBound = yBound;
	}

	/**
	* Moves our ball and slows its speed
	* @param tic double describing how much time passes
	* @param boundary 
	**/
	public void move (double tic) {                                                                            // 2
		
		// Local variables
		double ticRemainder = tic - (double)((int)tic);
		double frictionFrac = 1 - (0.01*ticRemainder);

		// For every second...
		for (int i = 0; i < (int)tic; i++) {
			xPosition += xVelocity;
			yPosition += yVelocity;
			xVelocity *= friction;
			yVelocity *= friction;
		}

		// For the remainder of the time...
		xPosition += xVelocity*ticRemainder;
		yPosition += yVelocity*ticRemainder;
		xVelocity *= frictionFrac;
		yVelocity *= frictionFrac;
		
		// Stops the ball when conditions are met
		if (Math.sqrt(xVelocity*xVelocity + yVelocity*yVelocity) <= inch) {
			xVelocity = 0.0;
			yVelocity = 0.0;
		}
	}

	/**
	* Returns a stringy version of the ball
	* @return String value of the ball's name, position, and velocity.
	**/
	public String toString() { 																	               // 3

		//Set the left side of position string value
		String xPosString = String.format("%5.3f", xPosition) + ",";
		if (xPosition >= 0.0) {xPosString = " " + xPosString;}

		// Set the right side of position string value
		String yPosString = String.format("%5.3f", yPosition);
		if (yPosition >= 0.0) {yPosString = " " + yPosString;}

		// The final position 
		String position;
		if (isOff()) {
			position = "<   OUT OF BOUNDS    >";
		} else {
			position = "< " + String.format("%-10s", xPosString) + String.format("%-8s", yPosString) + " >";
		}

		// Set the left side of velocity string value
		String xVelString = String.format("%5.3f", xVelocity) + ", ";
		if (xVelocity >= 0.0) {xVelString = " " + xVelString;}

		// Set the right side of velocitystring value
		String yVelString = String.format("%5.3f", yVelocity);
		if (yVelocity >= 0.0) {yVelString = " " + yVelString;}
		
		// The final velocity
		String velocity;
		if (isMoving()) {
			velocity = "< " + String.format("%-10s", xVelString) + String.format("%-8s", yVelString) + " >";
		} else {
			velocity = "<      AT REST       >";
		}

		// Finally...
		String result = String.format("%-23s", name) + String.format("%-35s", position) + velocity;
		return result;
	}

	/**
	* Classwide method of the method above
	* @param b ball value
	**/
	public static String toString(Ball b) { 													               // 4
		return b.toString();
	}

	/**
	* Tells us if ball is moving
	* @return true or false; ball is moving, ball is not
	**/
	public Boolean isMoving() {																                   // 5
		if (xVelocity == 0.0 && yVelocity == 0.0) {
			return false;
		} else {
			return true;
	}	}

	/**
	* Tells us if a ball is off the field
	* @return true or false; ball is off, ball is not.
	**/
	public Boolean isOff() {
		if (Math.abs(xPosition) >= xBound || Math.abs(yPosition) >= yBound) {
			return true;
		} else {
			return false;
	}	}

	/**
	* Checks to see if two balls touch
	* @param b1 Ball number 1
	* @param b2 Ball number 2
	* @return true or false; balls touch, balls do not
	**/
	public static boolean areTouching (Ball b1, Ball b2) {                                                     // 6
		
		// Difference between circle centers formula
		double xDiff = b1.xPosition - b2.xPosition;
		double yDiff = b1.yPosition - b2.yPosition;
		double distanceBetween = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
		
		if (distanceBetween <= 2*radius) {
			return true;
		} else {
			return false;
		}
	}

	/**
	* Main method for testing -- pretty simple
	* @param args[] String array of command line arguments
	**/
	public static void main( String args[] ) {                                                                 // 7
		System.out.println( "\nTesting the Ball class................" );

		Ball b1 = new Ball(1, 10.0, 50.0, 2.0, 6.0, 1000, 1000);
		Ball b2 = new Ball(2, 20.0, 60.0, 3.0, 7.0, 1000, 1000);
		Ball b3 = new Ball(3, 30.0, 70.0, 4.0, 8.0, 1000, 1000);
		Ball b4 = new Ball(4, 40.0, 80.0, 5.0, 9.0, 1000, 1000);

		for (int i = 0; i < 250; i++) {
			b1.move(2.0);
			b2.move(2.0);
			b3.move(2.0);
			b4.move(2.0);
			System.out.println(Ball.toString(b1));
			System.out.println(Ball.toString(b2));
			System.out.println(Ball.toString(b3));
			System.out.println(Ball.toString(b4));

			if ( b1.isMoving() || b2.isMoving() || b3.isMoving() || b4.isMoving() ) {
				System.out.println();
			} else {
				break;
			}
	    }
    }
}