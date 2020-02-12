/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* @author Aiden Meyer
* @version 1.0.0

* DESCRIPTION:
* This class describes a whole set of die. We use the class 
* 
* METHODS:
* public DiceSet (int count, int sides)         The constructor for our dice set.
* public int sum()                              Adds all of the current die values together.
* public void roll()                            Rolls all of the die.
* public void rollIndividual(int i)             Rolls a single die. 
* public getIndividual(int i)                   Returns the value of an individual die.
* public String toString()                      Returns a visual "stringy" version of the die.
* public static String toString(DiceSet ds)     The classwide version of the method above.
* public static void main(String[] args)        The (useless) main method.
* public boolean isIdentical (DiceSet compare)  Checks to see if two dice sets are identical
* public static void main (String[] args)       The main method (never used).
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
**/

public class DiceSet{

	// private instance fields
	private int count;
	private int sides;
	private Die[] ds = null;

	/**
	* constructor
	* @param count int value telling us how many dice we want
	* @param sides int value telling us how many sides each die has
	* @throws IllegalArgumentException if count is negative
	**/
	public DiceSet (int count, int sides) {
    	if (count <= 0) {
     		throw new IllegalArgumentException("invalid dice set");
    	}
		this.count = count; this.sides = sides;
		ds = new Die[count];
    	for (int i = 0; i < ds.length; i++) {
     		ds[i] = new Die(sides);}
	}

	/**
	* Adds up all of the dice
	* @return int value of the sum of the die
	**/
	public int sum() {
		int result = 0;
		for (int i = 0; i < ds.length; i++) {
			result = result + ds[i].getValue();
		}
    	return result;
	}

	/**
	* Rolls all of the die
	**/
	public void roll() {
		for(int i = 0; i < ds.length; i++) {
			ds[i].roll();
		}
	}

	/**
	* Rolls a single die
	* @param i the dice set index that we want to reach
	**/
	public void rollIndividual (int i) {
    	if (i > count || i < 0) {
    	throw new IllegalArgumentException("index is out of range");
    	}
		ds[i].roll();
	}

	/**
	* Gives the value of a certain die
	* @param i the dice set index that we want to reach
	* @return int value of the selected die
	**/
	public int getIndividual (int i) {
		return ds[i].getValue();
	}

	/**
	* Returns a string for better visualization
	* @return a string value of the dice set
	**/
	public String toString() {
		String result = "";
		for(int i = 0; i < ds.length; i++) {
			result += ds[i].toString();
		}
		return result;
	}

	/**
	* The classwide version of the method above
	* @param ds DiceSet that we want to make a string
	* @return a string value of the dice set
	**/
	public static String toString (DiceSet ds) {
		return ds.toString();
	}

	/**
	* Checks to see if two dice set are identical
	* @param compare DiceSet that we want to compare to our current set
	* @return boolean value telling us whether or not the sets are identical
	**/
	public boolean isIdentical (DiceSet compare) {
		if (this.toString() == compare.toString()) {return true;}
		else {return false;}
	}

	/**
	* Main method (never used)
	**/
	public static void main (String[] args) {
		System.out.print("Game on!");
	}
}