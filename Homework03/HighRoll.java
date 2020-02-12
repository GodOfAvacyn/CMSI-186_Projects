/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* @author Aiden Meyer
* @version 1.0.0
* 
* DESCRIPTION:
* This is the actual game of highroll. The user is prompted into creating a set of die, then
* they are given a series of options such as "roll al of the dice", "caluclate scores", etc.
* Whichever number they choose, the innards of the code uses methods from the DiceSet and Die
* classes to to the correct task. The class also keeps track of players' maximum combined die
* rolls.
* 
* METHODS:
* public Highroll (int count, int sides)        The constructor for our game of HighRoll.
* public static void main (String[] args)       The main method of the function. Plays the game.
* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
**/

//Importing libraries
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll {

    //Private instance fields
    private DiceSet myDice = null;
    private int score = 0;

    /**
    * constructor
    * @param count int value telling us how many die we want
    * @param sides int value telling us how many sides each die has
    **/
    public HighRoll (int count, int sides) {

        myDice = new DiceSet(count, sides);
        BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
        System.out.println("\nOkee dokee, your new set of dice is fresh off the chopping block! Have fun out there!\n");
        System.out.println("1. ROLL ALL THE DICE");
        System.out.println("2. ROLL A SINGLE DIE");
        System.out.println("3. VIEW MY SET");
        System.out.println("4. CALCULATE THE SCORES FOR THIS SET");
        System.out.println("5. SAVE THE SCORE AS A HIGH SCORE");
        System.out.println("6. DISPLAY THE HIGH SCORE");
        System.out.println("V. VIEW OPTIONS");
        System.out.println("Q. QUIT THE PROGRAM");

        while (true) {
            System.out.print(">>");
            String inputLine = null;
            try {
                inputLine = input.readLine();

                if (0 == inputLine.length() ) {
                    System.out.println("Looks like you didn't enter anything...");
                    System.out.print(">>");
                }

                if ('1' == inputLine.charAt(0)) {                                                     // When we press 1...
                    myDice.roll();
                    System.out.println("\nDone!");
                }

                if ('2' == inputLine.charAt(0)) {                                                      // When we press 2...
                    System.out.println("");
                    while (true) {
                        System.out.println("Which die would you like to roll?");
                        System.out.print(">>");
                        try {
                            inputLine = input.readLine();
                            int index = Integer.parseInt(inputLine) - 1;
                            myDice.rollIndividual(index);
                            break;
                        } catch (IllegalArgumentException iae) {
                            System.out.println("\nOops! That's not a valid index.");
                    }   }
                    System.out.println("\nDone!");
                    inputLine = "nothing";
                }

                if ('3' == inputLine.charAt(0)) {                                                      // When we press 3...
                    System.out.println('\n' + myDice.toString() );
                }

                if ('4' == inputLine.charAt(0)) {                                                      // When we press 4...
                    System.out.println("\nYour current score is " + Integer.toString(myDice.sum()) + ".");
                }

                if ('5' == inputLine.charAt(0)) {                                                      // When we press 5...
                    try {
                        score = myDice.sum();
                        System.out.println("\nDone!");
                    } catch (IllegalArgumentException iae){
                        System.out.print("\nOops! Looks like you haven't rolled your dice yet. Please give them a roll and try again.");
                }   }

                if ('6' == inputLine.charAt(0)) {                                                      // When we press 6...
                    System.out.println("\nYour current high score is " + Integer.toString(score) + ".");
                }

                if ('V' == inputLine.charAt(0) || 'v' == inputLine.charAt(0)) {                        // When we press V...
                    System.out.println("\n1. ROLL ALL THE DICE");
                    System.out.println("2. ROLL A SINGLE DIE");
                    System.out.println("3. VIEW MY SET");
                    System.out.println("4. CALCULATE THE SCORES FOR THIS SET");
                    System.out.println("5. SAVE THE SCORE AS A HIGH SCORE");
                    System.out.println("6. DISPLAY THE HIGH SCORE");
                    System.out.println("V. VIEW OPTIONS");
                    System.out.println("Q. QUIT THE PROGRAM");
                }

                if ('Q' == inputLine.charAt(0) || 'q' == inputLine.charAt(0)) {                        // When we press Q...
                    break;
                }
        
            } catch (IOException ioe) {
                System.out.print("Caught IOException.");
            }
        }
    }

    /**
    * Main method of not only our class but the whole HighRoll system.
    * @param args String value of what is in the terminal. NOT EVER USED.
    **/
    public static void main (String[] args) {

        int sides = 0;
        int count = 0;
        BufferedReader input = new BufferedReader( new InputStreamReader(System.in) );

        System.out.println("\nWelcome to HighRoll, the fantastic game of dice!");
        System.out.println("\nBefore we begin, we need to create you your own set of dice.");


        while (true) {
            String inputLine = null;

            try {                                                                                      // Setting the number of dice.
                System.out.println("\nHow many dice would you like to create?");
                System.out.print(">>");
                inputLine = input.readLine();
                count = Integer.parseInt(inputLine);
            } catch (IOException ioe){
                System.out.println("Caught IOException.");
            } catch (NumberFormatException nfe) {
                System.out.println("...um...");
            }

            try {                                                                                      // Setting the number of sides on each die.
                System.out.println("\nHow many sides would you like each die to have?");
                System.out.print(">>");
                inputLine = input.readLine();
                sides = Integer.parseInt(inputLine);
            } catch (IOException ioe) {
                System.out.println("Caught IOException.");
            } catch (NumberFormatException nfe) {
                System.out.println("...um...");
            }

            try {                                                                                      // Creating the actual game of Highroll.
                HighRoll game = new HighRoll(count, sides);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println("\nLooks like you didn't enter your parameters in correctly...why don't we try again?");
            }
        }
    }
}