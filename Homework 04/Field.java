/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* @author Aiden Meyer
* @version 1.0.0
* 
* DESCRIPTION:
* This class describes attributes of the play field we are playing on. It is 1000x1000 feet and
* always contains a fixed pole somewhere in the middle.
* 
* METHODS:
* public Field()                               The constructor for our Field.                    1
* public static void main (String args[])      The main method. Runs a test of its boundaries.   2
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ **/
public class Field {
	// Instance fields
	public int xBoundary;
	public int yBoundary;
	public Ball pole = null;
	
	/**
	* Constructor
	* @note Creates our static pole upon initialization
	**/
	public Field(int xBoundary, int yBoundary) {										  	  // 1
		this.xBoundary = xBoundary;
		this.yBoundary = yBoundary;
		float poleX = (float)Math.random()*1000;
		float poleY = (float)Math.random()*1000;
		pole = new Ball(0, poleX, poleY, 0, 0, xBoundary, yBoundary);
		pole.name = "Pole";
	}

	/**
	* Main method. Prints boundaries and stats.
	* @param args[] String array of command line arguments 
	**/
	public static void main (String args[]) {											      // 2
		Field myField = new Field(1000, 1000);
		System.out.println("Boundaries: " + Integer.toString(myField.xBoundary) + ", "
										  + Integer.toString(myField.yBoundary));
		System.out.println(Ball.toString(myField.pole));
	}
}