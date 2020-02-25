/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* @author Aiden Meyer
* @version 1.0.0
* 
* DESCRIPTION:
* This class describes everything needed to accurately simulate time increments. All time is
* measured in SECONDS (except for when it is converted to a string, of course).
* 
* METHODS:
* public Clock (float tic)                     The constructor for a clock.                       1
* public void moveForward()                    Moves time forward one increment.                  2
* public double getTick()                      Returns the clock's tic value.                     3
* public String toString()                     Returns how much time has passed in string form.   4
* public static void main (String args[])      The main method. Runs tests on Clock objects.      5
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ **/
public class Clock {

	// Instance fields
	private int hours = 0;
	private int minutes = 0;
	private double seconds= 0.0;
	private double tic;

	/**
	* Sets the tic value
	* @param tic the desired tic value in seconds.
	* @note converts tic to float
	**/
	public Clock (double tic) {															       // 1
		if (tic <= 0.0 || tic > 1800.0) {
			throw new IllegalArgumentException("Invalid tic value");
		}
		this.tic = tic;
	}

	/**
	* Moves time forward a tic
	**/
	public void moveForward() {														     	   // 2
		seconds += tic;
		if (seconds >= 60.0) {
			seconds -= 60.0;
			minutes++;
			if (minutes == 60) {
				minutes = 0;
				hours++;
			}
		}
	}

	/**
	* Returns the tic value
	* @return tic value as float
	**/
	public double getTick() {                                                                  // 3
		return tic;
	}

	/**
	* Gets the elapsed time in a readable format: hours:minutes:seconds
	* @return the elapsed time in string form
	**/
	public String toString() {																   // 4
		String hours = String.format("%02d", this.hours);
		String minutes = String.format("%02d", this.minutes);
		String seconds = String.format("%05.2f", this.seconds);

		String time = hours + ":" + minutes + ":" + seconds;
		return time;
	}

	/**
	* Main method for testing
	* @param args[] String array of command line arguments
	**/
	public static void main (String args[]) {												   // 5
		System.out.println("Testing the Clock class...");

		Clock clock1 = new Clock(0.1);
		Clock clock2 = new Clock(0.5);
		Clock clock3 = new Clock(3.0);

		for (int i = 0; i < 10; i++) {

			clock1.moveForward();
			clock2.moveForward();
			clock3.moveForward();

			System.out.println( "Clock 1 time is " + clock1.toString() );
			System.out.println( "Clock 2 time is " + clock2.toString() );
			System.out.println( "Clock 3 time is " + clock3.toString() );
		}
	}
}