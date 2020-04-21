/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
/**                                            <b>BirthdaySolver Class</b>
* <p>
* <b>DESCRIPTION</b>
* </p><p>
* This class is used to calculate the probability that, among N people, at least two of them share a birthday 
* (NOTE: this assumes that leap days do not exist).
* <br>
* We will display two values: the <i>actual</i> probability that two will share a birthday, and a <i>simulated</i> 
* probability by running a bunch of cases.
* </p><p>
* <b>METHODS</b>
* </p><p>
* public BirthdaySolver (int N, int experiments) ----------- Constructor for the class.<br>
* public double realProbability() -------------------------- Displays the real probability of shared birthdays.<br>
* public void GenerateBirthdays() -------------------------- Generates a random list of birthdays.<br>
* public double fakeProbability() -------------------------- Displays the simulated estimate of the probability.<br>
* public static void main (String[] args) ------------------ Main method of the BirthdaySolver class.<br>
* </p>
* @author  Aiden Meyer
* @version 1.0.0                                                                                                 **/
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class BirthdaySolver {
  
    // Instance fields
    int N;
    int experiments;
    int[] birthdayArray;

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /** Constructor that takes in a number that it uses as the sample population.
      * @param N int value describing population size.
      * @param experiments int value describing the number of simulations to run.**/
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public BirthdaySolver (int N, int experiments) {
        if (N > 365 || experiments > 10000000) {
            throw new IllegalArgumentException("Values too large");
        }
        this.N = N;
        this.experiments = experiments;
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /** Gives the actual probability of having non-unique birthdays in a group of
      * n people.
      * @return double value of the probability; between 0 and 1.                **/
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public double realProbability() {
        double twoTheSame;
        double noneTheSame = 1.0;
        double birthdaysLeft = 365.0;
        for (int i = 0; i < N; i++) {
            noneTheSame *= birthdaysLeft/365.0;
            birthdaysLeft -= 1.0;
        }
        twoTheSame = 1.0 - noneTheSame;
        return twoTheSame;
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /** Generates a list of integers. Each entry represents one of the N people's
      * birthdays. The possible values are between 1 and 365; 1 being January 1st,
      * 365 being December 31st.                                                 **/
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void generateBirthdays() {
        birthdayArray = new int[N];
        for (int i = 0; i < N; i++ ) {
            birthdayArray[i] = (int)Math.ceil(Math.random()*365);
        }
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /** Calculate an estimation of the probability by running a given number of
      * trials. Divides the number of times two shared a birthday by the number
      * of trials total.
      * @return double value describing the fake probability                     **/
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public double fakeProbability() {
        double sharedBirthday = 0.0;

        for (int i = 0; i < experiments; i++) {
            generateBirthdays();

            // Comparison loop
            boolean shouldBreak = false;
            for (int j = 0; j < birthdayArray.length; j++) {
                for (int k = 0; k < birthdayArray.length; k++) {
                    if ( (j != k) && (birthdayArray[j] == birthdayArray[k]) )  {
                        sharedBirthday += 1.0;
                    shouldBreak = true;
                    }
                    if (shouldBreak) {break;}
                }
                if (shouldBreak) {break;}
            }
        }
        double probability = sharedBirthday/experiments;
        return probability;
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    /** Main method of the class. Takes user inputs and generates a birthday class
      * to tell us the probability of at least two people sharing a birthday in a
      * group. But that's not all! We also calculate an estimate of the probability,
      * using a given number of simulations.
      * @param args String array of command line arguments.                      **/
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main (String[] args) {
        int N = 0;
        int experiments = 100000;
        BirthdaySolver birthday = null;

        try {
            N = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.out.println("Whoops! Looks like you didn't enter your arguments in correctly.");
            System.out.println("\nThe correct syntax is: Java BirthdaySolver <number of people> <number of trials (optional)>");
            return;
        }

        if (args.length > 1) {
            try {
                experiments = Integer.parseInt(args[1]);
            } catch (Exception e) {
                System.out.println("Whoops! Looks like the parameter for the number of experiments.");
                System.out.println("\nThe correct syntax is: Java BirthdaySolver <number of people> <number of trials (optional)>");
                return;
            }
        }
        try {
            birthday = new BirthdaySolver(N, experiments);
        } catch (Exception e) {
            System.out.println("Woah there, your inputs are way, way, way too big! Think a bit smaller.");
        }

        System.out.println("Calculating.... This may take some time.");
        Double realProb = 100*birthday.realProbability();
        Double fakeProb = 100*birthday.fakeProbability();

        String realProbF = String.format(("%2.2f"), realProb);
        String fakeProbF = String.format(("%2.2f"), fakeProb);

        System.out.println("In a group of " + Integer.toString(N) + " people, there is a " + realProbF + "% chance that at least two people will share a birthday.");
        System.out.println("Our simulation, however, tells us that there is a " + fakeProbF + "% chance.");
    }
}