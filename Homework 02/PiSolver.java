/*
* This class will approximate pi by throwing a buch of darts against an imaginary dartboard.
  It sees how many of those darts landed within a circle of radius one in the middle, and approximates pi by
  comparing the ratio of the darts in the circle to the total and multiplying it by 4.
*/
public class PiSolver {
	public static void main(String[] args) {
		/*
		* The main method takes in a user input and assigns it to an integer value named "numberThrown".
		* It then throws that many darts at the target and assigns the number in the circle to "numberInCircle".
		* We then calculate an approximation of Pi by dividing the number in the circle by the number thrown and
		  then multiplyting the whole thing by 4.
		*Then we print the result.
		*/
		int numberThrown = 1000;
		if (args.length > 0) { 
			try {
				numberThrown = Integer.parseInt(args[0]);
			} catch (NumberFormatException ex) {
				System.out.print("Whoops! The value you have entered isn't an integer....");
			}

		}

		double numberInCircle = throwdarts(numberThrown);
		double pi =  4 * numberInCircle / numberThrown;
		System.out.print(pi);
	}

	public static int throwdarts(int input) {
		/*
		* This method takes an integer as its input, telling us how many darts we should throw.
		* For every dart thrown, we assign its final location to a point with coordinates x and y.
		* Using the Pythagorean theorem, we calculate the distance the dart is from the origin.
		  If the distance is inside a circle with radius 1, we call it a direct hit. If not, nothing happens.
		* Finally, we output the number of direct hits there were.
		*/
		int directHits = 0;
		for(int i = input; i > 0; i--) {
			double x = Math.random();
			double y = Math.random();
			double vectorDistance = Math.sqrt(x*x + y*y);
			directHits += (vectorDistance < 1)?1:0;
		}
		return directHits;
	}
}