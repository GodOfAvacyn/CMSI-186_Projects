/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* 
* @author Aiden Meyer
* @version 1.0.0
* 
* DESCRIPTION:
* This class defines several functions and, depending on a given parameter "offset", will
* return either a left, right, or midpoint Riemann sum. Each takes in an array of doubles
* that act in different ways. For example, the "poly" function takes the array and 
* transforms each of them into a coefficient for higher and higher order degree x's.
* 
* METHODS:
* public SkateRamp (double a, double b, double percent)     The constructor for the SkateRamp class.                    1
* public double poly (double[] coefs, int n)                Integral approximation of a polynomial function.            2
* public double sin (int n)                                 Integral approximation of a sine function.                  3
* public double cos (int n)                                 Integral approximation of a cosine function.                4
* public double tan (int n)                                 Integral approximation of a tangent function.               5
* public double exp (int n)                                 Integral approximation of a natural exponent.               6
* public double log (int n)                                 Integral approximation of a natural logarithm.              7
* public double sqrt (int n)                                Integral approximation of a square root function.           8
* public static Boolean containsPercent (String entry)      Tells us whether or not a string contains '%'.              9
* public static void help()                                 Gives user instructions on how to run the program          10
* public static void runTests()                             Runs a series of tests to check our code.                  11
* public static void main (String[] args)                   Main method of the SkateRamp class.                        12
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ **/
public class SkateRamp {

	// Fields
	private double a;
	private double b;
	private double tol;

	/**
	* Constructor
	* @param a double value describing start of integral
	* @param b double value describing end of integral
	* @param percent double value describing the tolerance of the integral
	**/
	public SkateRamp (double a, double b, double percent) {                                                          // 1
		if (percent >= 100.0 || percent <= 0.0) {
			throw new IllegalArgumentException("percent out of bounds");
		}
		this.a = a;
		this.b = b;
		tol = percent/100.0;
	}

	/**
	* Integral approximation of a polynomial function
	* @param coefs double array describing our coefficients
	* @param n int value telling us how many iterations we run
	* @return double value of our integral
	**/
	public double poly (double[] coefs, int n) {                                                                     // 2
		if (coefs.length == 0) {
			throw new IllegalArgumentException("Invalid # of coefficients");
		}
		// Local variables
		double i;
		int ii;
		double x;
		double dx = (b-a)/n;
		double integral = 0.0;
		
		// Integration
		for (i = 0.5; i < n; i += 1.0) {
			x = a + i*dx;
			// Main polynomial algorithm
			for (ii = 0; ii < coefs.length; ii++) {
				integral += coefs[ii]*Math.pow(x, ii);
			}
		}

		// Final result
		integral *= dx;
		return integral;
	}

	/**
	* Integral approximation of sine function
	* @param n int value telling us how many iterations we run
	* @return double value of our integral
	**/
	public double sin (int n) {                                                                                      // 3
		
		// Local variables
		double i;
		double x;
		double dx = (b-a)/n;
		double integral = 0;
		
		// Integration
		for (i = 0.5; i < n; i += 1.0) {
			x = a + i*dx;
			integral += Math.sin(x);
		}

		// Final result
		integral *= dx;
		return integral;
	}

	/**
	* Integral approximation of cosine function
	* @param n int value telling us how many iterations we run
	* @return double value of our integral
	**/
	public double cos (int n) {                                                                                      // 4
		
		// Local variables
		double i;
		double x;
		double dx = (b-a)/n;
		double integral = 0;
		
		// Integration
		for (i = 0.5; i < n; i += 1.0) {
			x = a + i*dx;
			integral += Math.cos(x);
		}

		// Final result
		integral *= dx;
		return integral;
	}

	/**
	* Integral approximation of tangent function
	* @param n int value telling us how many iterations we run
	* @return double value of our integral
	**/
	public double tan (int n) {                                                                                      // 5
		
		// Local variables
		double i;
		double x;
		double dx = (b-a)/n;
		double integral = 0;
		
		// Integration
		for (i = 0.5; i < n; i += 1.0) {
			x = a + i*dx;
			integral += Math.tan(x);
		}

		// Final result
		integral *= dx;
		return integral;
	}

	/**
	* Integral approximation of natural exponent function
	* @param n int value telling us how many iterations we run
	* @return double value of our integral
	**/
	public double exp (int n) {                                                                                      // 6
		
		// Local variables
		double i;
		double x;
		double dx = (b-a)/n;
		double integral = 0;
		
		// Integration
		for (i = 0.5; i < n; i += 1.0) {
			x = a + i*dx;
			integral += Math.exp(x);
		}

		// Final result
		integral *= dx;
		return integral;
	}

	/**
	* Integral approximation of natural logarithm function
	* @param n int value telling us how many iterations we run
	* @return double value of our integral
	**/
	public double log (int n) {                                                                                      // 7
		
		// Local variables
		double i;
		double x;
		double dx = (b-a)/n;
		double integral = 0;
		
		// Integration
		for (i = 0.5; i < n; i += 1.0) {
			x = a + i*dx;
			integral += Math.log(x);
		}

		// Final result
		integral *= dx;
		return integral;
	}

	/**
	* Integral approximation of square root function
	* @param n int value telling us how many iterations we run
	* @return double value of our integral
	**/
	public double sqrt (int n) {                                                                                      // 8
		
		// Local variables
		double i;
		double x;
		double dx = (b-a)/n;
		double integral = 0;
		
		// Integration
		for (i = 0.5; i < n; i += 1.0) {
			x = a + i*dx;
			integral += Math.sqrt(x);
		}

		// Final result
		integral *= dx;
		return integral;
	}

	/**
	* Checks if string has "%" icluded
	* @param entry string value to be checked
	* @return true or false; has % or not.
	**/
	public static boolean containsPercent (String entry) {                                                           // 9
		boolean result = false;
		for (int i = 0; i < entry.length(); i++) {
			if (entry.charAt(i) == '%') {
				result = true;
		}	}
		return result;
	}

	/**
	* Gives user instructions on how to use program
	**/
	public static void help() {                                                                                     // 10
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + " HELP " + 
		"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("In short, this program uses a specific curve, computes the area underneath, and " +
		"multiplies the result by 3.\nYour command line entry should read as such:\n");
		System.out.println("java SkateRamp <function name> <start point> <end point> <tolerance>%\n");
		System.out.println("The available functions are:\npoly (polynomial)\nsin (sine)\ncos (cosine)\ntan (tangent)"
		+ "\nexp (natural exponent)\nlog (natural logarithm)\nsqrt (square root)\n\nYour start point and end point"
		+ " may be any real number, but your tolerance must be a value between 0 and 100.\nAlso, the polynomial " + 
		"function takes in additional arguments describing its coefficients.\nFor example, \"poly 1 2 3\" is the " +
		"function 1 + 2x + 3x^2.\n");
		System.out.println("I know it sounds confusing at first, but you'll get the hang of it! I know you will.");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +
		"~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

	}
	
	/**
	* Tests our function
	**/
	public static void runTests() {                                                                                 // 11
		
		SkateRamp test = new SkateRamp(1.0, 3.0, 1.0);
		
		// Instance fields of Functions
		int n;
		double error;
		double[] coefs = new double[3];
		coefs[0] = 4.0;
		coefs[1] = 0.0;
		coefs[2] = -1.0;
		double poly1 = 0.0; double poly2 = 0.0;
		double sin1 = 0.0;  double sin2 = 0.0;
		double cos1 = 0.0;  double cos2 = 0.0;
		double tan1 = 0.0;  double tan2 = 0.0;
		double exp1 = 0.0;  double exp2 = 0.0;
		double log1 = 0.0;  double log2 = 0.0;
		double sqrt1 = 0.0; double sqrt2 = 0.0;

		System.out.println("Testing integral approximations from -2 to 2 with tolerance 1%\n");

		// Polynomial approximation
		n = 1;
		error = test.tol + 1.0;
		while (error > test.tol) {
			n++;
			poly1 = test.poly(coefs, n);
			poly2 = test.poly(coefs, n+1);
			error = Math.abs(poly2 - poly1);
		} System.out.println("Poly:     " + Double.toString(poly2));
		
		// Sine approximation
		n = 1;
		error = test.tol + 1.0;
		while (error > test.tol) {
			n++;
			sin1 = test.sin(n);
			sin2 = test.sin(n+1);
			error = Math.abs(sin2 - sin1);
		} System.out.println("Sin:      " + Double.toString(sin2));
		
		// Cosine approximation
		n = 1;
		error = test.tol + 1.0;
		while (error > test.tol) {
			n++;
			cos1 = test.cos(n);
			cos2 = test.cos(n+1);
			error = Math.abs(cos2 - cos1);
		} System.out.println("Cos:      " + Double.toString(cos2));
		
		// Tangent approximation
		n = 1;
		error = test.tol + 1.0;
		while (error > test.tol) {
			n++;
			tan1 = test.tan(n);
			tan2 = test.tan(n+1);
			error = Math.abs(tan2 - tan1);
		} System.out.println("Tan:      " + Double.toString(tan2));
		
		// Exponent approximation
		n = 1;
		error = test.tol + 1.0;
		while (error > test.tol) {
			n++;
			exp1 = test.exp(n);
			exp2 = test.exp(n+1);
			error = Math.abs(exp2 - exp1);
		} System.out.println("Exp:      " + Double.toString(exp2));
		
		// Natural logarithm approximation
		n = 1;
		error = test.tol + 1.0;
		while (error > test.tol) {
			n++;
			log1 = test.log(n);
			log2 = test.log(n+1);
			error = Math.abs(log2 - log1);
		} System.out.println("Log:      " + Double.toString(log2));

		// Square root approximation
		n = 1;
		error = test.tol + 1.0;
		while (error > test.tol) {
			n++;
			sqrt1 = test.sqrt(n);
			sqrt2 = test.sqrt(n+1);
			error = Math.abs(sqrt1 - sqrt2);
		} System.out.println("sqrt:     " + Double.toString(sqrt2));
	}

	/**
	* Main method of the class
	* @param args String array of command line arguments
	**/
	public static void main (String[] args) {                                                                       // 10
		
		// Local variables
		int len = args.length;
		double a; double b;
		double percent = 1.0;
		SkateRamp myRamp;
		double result1 = 0.0; double result2 = 0.0;
		double[] coefs;
		int n = 0;
		double error;
		
		// Weeding out preliminary errors...
		if (len == 0) {
			System.out.println("Looks like you're a newcomer to the Aiden SkateRamp calculator! " +
			"Let's get you started...");
			SkateRamp.help();
		} else if (len < 3) {
			System.out.println("Whoops! You didn't enter enough arguments.");
			SkateRamp.help();
		} else {

			// Checks to see if user entered a desired error
			if ( containsPercent(args[len-1]) ) {
				int stringLength = args[len-1].length();
				String percentString = args[len-1].substring(0, stringLength-1);
				percent = Double.parseDouble(percentString);
				len -= 1;
			} 

			// Main object creation!
			try {
			a = Double.parseDouble(args[len-2]);
			b = Double.parseDouble(args[len-1]);
			myRamp = new SkateRamp(a, b, percent);
			} catch (IllegalArgumentException iae) {
				System.out.println("Looks like you're having some problems entering your arguments.");
				SkateRamp.help();
				return;
			}

			// Integration
			if (args[0].equals("poly")) {
				n = 0;
				error = myRamp.tol + 1.0;
				coefs = new double[len-3];
				for (int i = 1; i < len-2; i++) {
					coefs[i-1] = Double.parseDouble(args[i]);
				}
				try {
					while (error> myRamp.tol) {
						n++;
						result1 = myRamp.poly(coefs, n);
						result2 = myRamp.poly(coefs, n+1);
						error = Math.abs(result2 - result1);
					}
				} catch (IllegalArgumentException iae) {
					System.out.println("Whoops! Remember, the polynomial function takes in more arguments,"
					 + "as it needs coefficients.");
					return;
				}
			} else if (args[0].equals("sin")) {
				n = 0;
				error = myRamp.tol + 1.0;
				while (error > myRamp.tol) {
					n++;
					result1 = myRamp.sin(n);
					result2 = myRamp.sin(n+1);
					error = Math.abs(result2 - result1);
				}
			} else if (args[0].equals("cos")) {
				n = 0;
				error = myRamp.tol + 1.0;
				while (error > myRamp.tol) {
					n++;
					result1 = myRamp.cos(n);
					result2 = myRamp.cos(n+1);
					error = Math.abs(result2 - result1);
				}
			} else if (args[0].equals("tan")) {
				n = 0;
				error = myRamp.tol + 1.0;
				while (error > myRamp.tol) {
					n++;
					result1 = myRamp.tan(n);
					result2 = myRamp.tan(n+1);
					error = Math.abs(result2 - result1);
				}
			} else if (args[0].equals("exp")) {
				n = 0;
				error = myRamp.tol + 1.0;
				while (error > myRamp.tol) {
					n++;
					result1 = myRamp.exp(n);
					result2 = myRamp.exp(n+1);
					error = Math.abs(result2 - result1);
				}
			} else if (args[0].equals("log")) {
				n = 0;
				error = myRamp.tol + 1.0;
				while (error > myRamp.tol) {
					n++;
					result1 = myRamp.log(n);
					result2 = myRamp.log(n+1);
					error = Math.abs(result2 - result1);
				}
			} else if (args[0].equals("sqrt")) {
				n = 0;
				error = myRamp.tol + 1.0;
				while (error > myRamp.tol) {
					n++;
					result1 = myRamp.sqrt(n);
					result2 = myRamp.sqrt(n+1);
					error = Math.abs(result2 - result1);
				}
			} else if (args[0].equals("runTests")) {
				SkateRamp.runTests();
			} else {
				System.out.println("Whoops! The function you entered was not valid.");
				SkateRamp.help();
				System.out.print(args[0]);
				return;
			}
			
			// Final Results
			if (Double.isNaN(result2)) {
				System.out.println("Looks like your solution is not a real number. " + 
				"Maybe if we were working in the imaginary plane....");
			} else {
				System.out.println("The total wood needed is " + Double.toString(3*result2) + " square feet.");
				System.out.println("The program took " + Integer.toString(n) + " Iterations to complete.");
			}
		}
	}
}
