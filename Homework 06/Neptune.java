/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* =========================================  Neptune Class File  =========================================
* @author Aider Meyer
* @version 1.0.0
* 
* DESCRIPTION:
* We have a rocket ship with us that can travel at half the speed of light... what to do with it...
* I know! We should take a trip to Neptune! This class file will calculate the total time it takes
* to get to Neptune given one parameter: an initial velocity. We will gradually speed up to Earth's
* escape velocity, then we will speed up even more untill we are traveling at half the speed of
* light, and finally, decellerate to hit Neptune's escape velocity. Once we do that, we do all of it
* again backwards, safely getting back to earth....
* 
* METHODS:
* public Neptune (BrobInt acceleration)                    Constructor for our Neptune class.
* public void tic()                                        Moves the timer forward one second.
* public void speedUp()                                    Speeds our ship up until it reaches max speed.
* public void toThreshold (BrobInt threshold)              Speeds up until reaching a distance threshold.
* public void slowDown (BrobInt threshold)                 Slows down until reaching a certain speed.
* public static void main (String[] args)                  Main method of the class.
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ **/
public class Neptune {

	// Static fields that will be refferenced quite a bit.
	public static final BrobInt LIGHTSPEED     = new BrobInt("299792458");
	public static final BrobInt MAX_SPEED      = new BrobInt("149896528");
	public static final BrobInt EARTH_ESCAPE   = new BrobInt("11186");
	public static final BrobInt NEPTUNE_ESCAPE = new BrobInt("23500");
	public static final BrobInt DISTANCE       = new BrobInt("4400000000000");

	// Instance fields (starting from zero)
	public int     hours    = 0;
	public int     minutes  = 0;
	public int     seconds  = 0;
	public BrobInt distance = BrobInt.ZERO;
	public BrobInt speed    = EARTH_ESCAPE;

	// Instance fields (initialized)
	public BrobInt acceleration;
	public BrobInt decelTimeNeptune;
	public BrobInt decelDistNeptune;
	public BrobInt decelTimeEarth;
	public BrobInt decelDistEarth;

	/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	* Constructor takes in a a BrobInt and creates a new space ship, using the BrobInt as its acceleration
	* factor.
	* @param acceleration BrobInt describing accelleration factor.
	* @throws IllegalArgumentException if the acceleration is negative or exceeds the max speed.
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public Neptune (BrobInt acceleration) {
		// Errors
		if (!acceleration.positive) {
			throw new IllegalArgumentException("Value must be positive");
		}
		if (acceleration.compareTo(MAX_SPEED) == 1) {
			throw new IllegalAccessError("Acceleration cannot exceed max speed.");
		}
		// Instantiation
		this.acceleration   = acceleration;
		this.decelTimeEarth = (MAX_SPEED.subtract(EARTH_ESCAPE)).divide(acceleration);
		this.decelDistEarth = (
			MAX_SPEED.multiply(decelTimeEarth).subtract( 
				acceleration.multiply(
					decelTimeEarth.multiply(decelTimeEarth).divideByInt(2)
		)	)	);
		this.decelTimeNeptune = (MAX_SPEED.subtract(NEPTUNE_ESCAPE)).divide(acceleration);
		this.decelDistNeptune = (
			MAX_SPEED.multiply(decelTimeNeptune).subtract( 
				acceleration.multiply(
					decelTimeNeptune.multiply(decelTimeNeptune).divideByInt(2)
		)	)	);
	}

	/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	* Moves our clock forward one second.
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public void tic() {
		seconds++;
		if (seconds >= 60) {seconds -= 60; minutes++;}
		if (minutes >= 60) {minutes -= 60; hours++;}
	}

	public String tellTime() {
		String result = 
			Integer.toString(hours) + " hours, " + 
			Integer.toString(minutes) + " minutes, and " +
			Integer.toString(seconds) + " seconds";
		return result;
	}

	/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	* Accellerates our ship until we hit the speed of light.
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public void speedUp() {
		while (speed.compareTo(MAX_SPEED) == -1) {
			tic();
			speed = speed.add(acceleration);
			distance = distance.add(speed);
		} 
		speed = MAX_SPEED;
	}

	/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	* Cruises at 1/2 the speed of light until we reach a certain deceleration threshold.
	* @param threshold BrobInt value describing distance threshold for deceleration.
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public void toThreshold(BrobInt threshold) {

		BrobInt distanceLeft = DISTANCE.subtract(distance).subtract(threshold);
		if (!distanceLeft.positive) {
			throw new IllegalCallerException("Missed Neptune");
		}
		while (distanceLeft.positive && !distanceLeft.equals(BrobInt.ZERO)) {
			tic();
			distance = distance.add(speed);
			distanceLeft = distanceLeft.subtract(speed);
		}
	}

	/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	* Decelerates our ship until we hit a certain speed.
	* @param threshold BrobInt value describing speed threshold.
	* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public void slowDown (BrobInt threshold) {
		while (speed.compareTo(threshold) == 1) {
			tic();
			speed = speed.subtract(acceleration);
			distance = distance.add(speed);
		}
		speed = threshold;
	}

	public static void main (String[] args) {
		Neptune ship = null;
		try {
		ship = new Neptune( new BrobInt(args[0]));
		} catch (IllegalArgumentException iae) {
			System.out.println("Hello? Looks like you're having some trouble entering your arguments.\nThe accelleration of your ship must be a whole nonnegative number.");
			return;
		} catch (IllegalAccessError iae) {
			System.out.println("Jesus, you really like going fast, don't you?\nTry something slightly smaller that the ship's max speed.");
			return;
		}

			System.out.println("========================================================================================");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   LIFT OFF   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("========================================================================================");
			System.out.println("    Hooray! We are plotting a course to Neptune!\n    Fasten your seatbelts, ladies and gentlemen. This is sure to be a bumpy ride....");
		
		try {		
			ship.speedUp();
			System.out.println(" ========================================================================================");
			System.out.println("    Alright, we've really picked up speed.\n    We'll be cruising at the speed of light for a short while.");
			System.out.println("    -> So far, we've traveled " + ship.distance.toString() + " meters.");
			System.out.println("    -> We've been in the air for " + ship.tellTime() + ".");
			ship.toThreshold(ship.decelDistNeptune);
			System.out.println(" ========================================================================================");
			System.out.println("    We're close now. It's time to start slowing down. Pretty soon, we'll be on neptune.");
			System.out.println("    -> So far, we've traveled " + ship.distance.toString() + " meters.");
			System.out.println("    -> We've been in space for " + ship.tellTime() + ".");
			ship.slowDown(NEPTUNE_ESCAPE);

			System.out.println(" ========================================================================================");
			System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   NEPTUNE AHOY   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(" ========================================================================================");

			System.out.println("    Now, for the return trip!");
			System.out.println("    -> So far, we've traveled " + ship.distance.toString() + " meters.");
			System.out.println("    -> We've been in space for " + ship.tellTime() + ".");
			ship.distance = BrobInt.ZERO;
			ship.speedUp();
			System.out.println(" ========================================================================================");
			System.out.println("    Once again, we're cruising at the speed of light.");
			System.out.println("    -> So far, we've traveled " + ship.distance.add(DISTANCE).toString() + " meters.");
			System.out.println("    -> We've been in space for " + ship.tellTime() + ".");
			ship.toThreshold(ship.decelDistEarth);
			System.out.println(" ========================================================================================");
			System.out.println("    We're about to make our dissent back to Earth! What a ride it's been.");
			System.out.println("    -> So far, we've traveled " + ship.distance.add(DISTANCE).toString() + " meters.");
			System.out.println("    -> We've been in space for " + ship.tellTime() + ".");
			ship.slowDown(NEPTUNE_ESCAPE);
		} catch (IllegalCallerException ice) {
			System.out.println("\n    Woah, Jesus! Our ship just blew right past Neptune!\n    There's nothing we can do... I'm sorry, guests. We're as good as dead.");
			return;
		}

		System.out.println(" ========================================================================================");
		System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   TOUCHDOWN   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(" ========================================================================================");
		System.out.println("    We were in outer space for a grand total of " + ship.tellTime() + ".\n    Hope everyone had an excellent time up there.");
	}
}