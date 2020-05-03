import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
/**                                      CircleSolver Class File
  * <p>
  * <b>DESCRIPTION</b>
  * </p><p>
  * This class is designed to check if two circles a) intersect, b) do not intersect, or c)
  * are identical to each other. It reads files that give circle parameters and then outputs
  * one of three answers.
  * </p><p>
  * <b>METHODS</b>
  * <li>public CircleSolver (String filename) ------------ Constructor for the class.<br>
  * <li>public String checkCircle() ---------------------- Checks relationship between two circles.<br>
  * <li>public static void main (String[] args) ---------- Main method of the class.<br>
  * </p>
  * @author Aiden Meyer
  * @version 1.0.0                                                                                  **/
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class CircleSolver {

    // Instance fields made by constructor
    public String[] circles;
    public int[]    circle1;
    public int[]    circle2;
    public int      biggerCircle = 0;

    // Instance fields created elsewhere...
    double centerDiff = 0.0;
    int    radiusDiff = 0;
    int    radiusSum = 0;
    
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /** Constructor for the class. Reads a given file and sets a bunch of variables.<br>NOTE:
      * This method does <i>not</i> actually do any calculation. That comes later.
      * @param fileName String value of the name of the read file.
      * @throws IOException
      * @throws exception when radius is negative.                                        **/
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public CircleSolver(String fileName) throws IOException{
        this.circles = new String[2];
        int index = 0;

        // Reading file...
        File file = new File(fileName);
        BufferedReader br = new BufferedReader( new FileReader(file) );

        String thisLine = br.readLine();
        while(index < 2) {
            circles[index] = thisLine;
            index++;
            thisLine = br.readLine();

        } br.close();

        // Dealing with circle 1:
        circle1 = new int[3];
        for (int i = 0; i < 3; i++) {
            circle1[i] = Integer.parseInt(  ( circles[0].split(" ") )[i]  );
        }

        // Dealing with circle 2:
        circle2 = new int[3];
        for (int j = 0; j < 3; j++) {
            circle2[j] = Integer.parseInt(  ( circles[1].split(" ") )[j]  );
        }

        // Determining which is bigger (default is zero)
        if (this.circle2[2] > this.circle1[2])      {this.biggerCircle = 2;}
        else if (this.circle1[2] > this.circle2[2]) {this.biggerCircle = 1;}

        // Exception
        if (this.circle1[2] < 0 || this.circle2[2] < 0) {throw new IllegalArgumentException("Negative radius");}

    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /** This method does all of the brute arithmetic needed on the circle, like calculating
      * the distance between each circle, checking intersection, etc....
      * @return String value of the <i>relationship</i> between the circles. The possible
      * relationships are:
      * <ul><li>"in" if a circle is completely inside another circle</li>
      * <li>"out" if the circles are completely separate.</li>
      * <li>"0" if the circles are identical.</li>
      * <li>"1-" if the cirlces are nested and tangent.</li>
      * <li>"1+" if the circles are not tangent but still touch once.</li>
      * <li>"2" if the circles touch twice.</li></ul>                                     **/
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public String checkCircle() {

        // Doing the basics...
        centerDiff = Math.sqrt( Math.pow(circle1[0]-circle2[0],2) + Math.pow(circle1[1]-circle2[1],2) );
        radiusDiff = Math.abs( circle1[2] - circle2[2]);
        radiusSum  = Math.abs( circle1[2] + circle2[2]);

        // Calculating relation...
        if (centerDiff == 0 && this.biggerCircle == 0) {
            return "0";
        } else if (centerDiff == radiusSum) {
            return "1+";
        } else if (centerDiff == radiusDiff) {
            return "1-";
        } else if (centerDiff < radiusSum) {
            if (centerDiff < radiusDiff) {
                return "in";
            } return "2";
        } return "out";

    }

    public static void main (String[] args) {
        CircleSolver myCircle = null;

        // Error handling
        try {
            myCircle = new CircleSolver(args[0]);
        } catch (IOException ioe) {
            System.out.println("Whoops! Looks like you didn't enter a correct file name. Try again.");
            return;
        } catch (NumberFormatException nfe) {
            System.out.println("whoops! Looks like your file doesn't contain correct numbers.");
            return;
        } catch (NullPointerException npe) {
            System.out.println("Whoops! The file you entered doesn't have enough circles! 2 are required.");
            return;
        } catch (IllegalArgumentException iae) {
            System.out.println("...Does your file have a negative integer? Last I checked, that was impossible.");
            return;
        }

        // Initial report
        System.out.println(
            "Circle 1 is located at (" + Integer.toString(myCircle.circle1[0]) + ", " + myCircle.circle1[1] + 
            ") and has a radius of " + Integer.toString(myCircle.circle1[2]) +"."
        ); System.out.println(
            "Circle 2 is located at (" + Integer.toString(myCircle.circle2[0]) + ", " + myCircle.circle2[1] + 
            ") and has a radius of " + Integer.toString(myCircle.circle2[2]) +"."
        );

        // Calculating the actual intersections
        String relation = myCircle.checkCircle();
        if (relation.equals("0")) {
            System.out.println("Therefore, the circles are identical.");
        } else if (relation.equals("2")) {
            System.out.println("The circles intersect each other in 2 places.");
        } else if (relation.equals("out")) {
            System.out.println("The circles are completely separate.");
        } else if (relation.equals("1+")) {
            System.out.println("The circles are separate, but their boundaries touch.");
        } else {
            if (myCircle.biggerCircle == 1) {
                if (relation.equals("in")) {
                    System.out.println("Circle 2 is inside of circle 1");
                } else if (relation.equals("1-")) {
                    System.out.println("Circle 2 is inside circle 1, but their boundaries touch.");
                }
            } else if (myCircle.biggerCircle == 2) {
                if (relation.equals("in")) {
                    System.out.println("Circle 1 is inside of circle 2.");
                } else if (relation.equals("1-")) {
                    System.out.println("Circle 1 is inside circle 2, but their boundaries touch.");
                }
            }
        }
    }
}