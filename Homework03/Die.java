/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* @author Aiden Meyer
* @version 1.0.0
*
* DESCRIPTION:
* This class describes a single die with n sides (with the restricttion that n cannot be less
* than 4). Our die has a pip value that can range from 1 to n. When we roll our die, our pip
* value changes.
*
* METHODS:
* public Die (int sides)                        The constructor method for our die.
* public void roll()                            Rolls our die and sets its pip value.
* public int getValue()                         Returns the current pip value.
* public String toString()                      Returns a visual "stringy" version of the die.
* public static String toString (Die d)         The classwide version of the method above.
* public static void main (String[] args)       The (useless) main method.
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
**/
public class Die {

    // private instance fields
    private int sides;
	private int pips = 1;

    /**
    * constructor
    * @param sides int value containing the number of sides.
    * @throws IllegalArgumentException if sides < 4
    **/
    public Die (int sides) {
        if(sides < 4) {
            throw new IllegalArgumentException("A die cannot have less than four sides!");
		}
		this.sides = sides;
	}

    /**
    * Sets the pip value to a random integer between 1 and the number of sides
    **/
/// THIS SHOULD HAVE BEEN LEFT AS AN "int" AS IT WAS GIVEN TO YOU
///	public void roll() {
    public int roll() {         // changed back to int return type
		double determiner = (this.sides-1) * Math.random() + 1;
		pips = (int)Math.rint(determiner);
        return pips;            // added returned value
	}

    /**
    * Gets the current value of the die
    * @return the current pip value of the die
    **/
	public int getValue() {
		return pips;
	}

    /**
    * Returns a string for better visualization
    * @return a string version of the die
    **/
	public String toString() {
		return "{" + Integer.toString(pips) + "}";
	}

    /**
    * The classwide method of the method above
    * @param d Die object we want to make a string
    * @return a "stringy" version of the die
    **/
	public static String toString(Die d) {
		return d.toString();
	}

    /**
    * Main method (never used)
    **/
	public static void main(String[] args) {
		System.out.print("Game on!");
	}
}
