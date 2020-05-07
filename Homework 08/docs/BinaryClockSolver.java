/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
/**                               BinaryClockSolver class file
  * <p>
  * <b>Description</b>
  * </p><p>
  * This class takes in a command line argument, formatted HH:MM:SS, and turns it into
  * a "stringy" representation in binary form, where an asterix represents a zero and an
  * 'o' represents a one.
  * </p><p>
  * <b>Methods</b>
  * <li>public BinaryClockSolver (int[] times) ------------ Constructor for the class.<br>
  * <li>public static void main (String[] args) ----------- Main method of the class.<br>
  * </p>
  * @author Aiden Meyer
  * @version 1.0.0                                                                        **/
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class BinaryClockSolver {

    // Public fields...
    public String hours;
    public String minutes;
    public String seconds;

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /** Constructor for the class. Takes in an array of integers and translates it into
      * binary strings. 
      * @param times integer array of hours, minutes, seconds.                            **/
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BinaryClockSolver(int[] times) {
        String[] stringTimes = new String[3];
        String tempString;
        int tempNum;
        for (int i = 0; i < 3; i++) {
            tempNum = times[i];
            tempString = "";
            while (tempNum > 0) {
                if (tempNum%2 == 1) {
                    tempString = "o" + tempString;
                } else {
                    tempString = "." + tempString;
                }
                tempNum = tempNum/2;
            }
            while (tempString.length() < 6) {
                tempString = "." + tempString;
            }
            stringTimes[i] = tempString;
        }
        hours = stringTimes[0]; minutes = stringTimes[1]; seconds = stringTimes[2];
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /** Main method of the class. Takes in a command line argument and turns it into a
      * binary clock using the BinaryClockSolver constructor. 
      * @param args String array of command line arguments.                               **/
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main (String[] args) {
        int[] times = new int[3];
        try {
            times[0] = Integer.parseInt( args[0].substring(0, 2) );
            times[1] = Integer.parseInt( args[0].substring(3, 5) );
            times[2] = Integer.parseInt( args[0].substring(6) );
        } catch (Exception e) {
            System.out.println("Whoops! Looks like you didn't format your numbers correctly.");
            System.out.println("The input must be formatted HH:MM:SS.");
            return;
        }
        if (
            times[0] >= 24 || times[0] < 0 ||
            times[1] >= 60 || times[1] < 0 ||
            times[2] >= 60 || times[2] < 0
        ) {
            System.out.println("Whoops! Looks like some of your numbers are above their threshold value.");
            System.out.println("Remember, hours are between 0 and 24, and minutes/seconds are between 0 and 60.");
            return;
        }

        BinaryClockSolver myClock = new BinaryClockSolver(times);
        System.out.println("----------");
        System.out.println("| " + myClock.hours + " |");
        System.out.println("| " + myClock.minutes + " |");
        System.out.println("| " + myClock.seconds + " |");
        System.out.println("----------");
    }
}