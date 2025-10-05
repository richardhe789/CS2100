
// Name: Richard He
// Computing ID: rtk8qj@virginia.edu
// Homework Name: Java Intro
// Resources used (if applicable): None

public class JavaIntro {

    public static int hilo(int max, int target) {
        int min = 1;
        int attempts = 0;
        int randomNum = 0;
        // System.out.println("!!!!!!!!THIS IS THE TARGET!!!!!!!: " + target);
        do {
            randomNum = (int) (Math.random() * (max - min + 1)) + min;
            if (randomNum < target) {
                min = randomNum + 1;
            } else if (randomNum > target) {
                max = randomNum - 1;
            }
            // System.out.println("THIS IS THE RANDOM NUMBER: " + randomNum);
            // System.out.println("THIS IS THE MINIMUM: " + min);
            // System.out.println("THIS IS THE MAXIMUM: " + max);
            // System.out.println("------------------");
            attempts++;
        } while (randomNum != target);
        return attempts;
    }

    public static int rpsls(String userChoice, String computerChoice) {
        userChoice = userChoice.toLowerCase();
        computerChoice = computerChoice.toLowerCase();

        if (!userChoice.equals(computerChoice)) {

            switch (userChoice) {
                case "scissors":
                    if (computerChoice.equals("rock") || computerChoice.equals("spock"))
                        return 0;
                    else
                        return 1;
                case "paper":
                    if (computerChoice.equals("scissors") || computerChoice.equals("lizard"))
                        return 0;
                    else
                        return 1;
                case "rock":
                    if (computerChoice.equals("paper") || computerChoice.equals("spock"))
                        return 0;
                    else
                        return 1;
                case "lizard":
                    if (computerChoice.equals("rock") || computerChoice.equals("scissors"))
                        return 0;
                    else
                        return 1;
                case "spock":
                    if (computerChoice.equals("lizard") || computerChoice.equals("paper"))
                        return 0;
                    else
                        return 1;

            }
        }

        return -1;
    }

    public static String fuzzbizz(int one, int two, int input) {
        if (input % one == 0) {
            if (input % two == 0) {
                return "fuzzbizz";
            }
            return "fuzz";
        } else if (input % two == 0) {
            return "bizz";
        } else
            return "none";
    }

    public static int countRuns(int[] numbers) {
        boolean inRun = false;
        int runNumber = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (inRun == false && numbers[i] == numbers[i - 1]) {
                inRun = true;
                runNumber++;
            } else if (inRun == true && numbers[i] != numbers[i - 1]) {
                inRun = false;
            }
        }
        return runNumber;
    }

    public static void main(String args[]) {

        // For hilo, run this part! -------

        int userMax = 50;

        int userTarget = 20;

        System.out.println("It took " + hilo(userMax, userTarget) + " random tries to get to your target.");
        // For rpssl, run this part! --------

        String userHuman = "SPOCK";

        String userComputer = "paper";

        System.out.println("The consequence of your battle is: " + rpsls(userHuman,
                userComputer));

        // For fuzzbizz, run this part! --------

        int userOne = 3;

        int userTwo = 5;

        int userMain = 12;

        System.out.println("Your output is: " + fuzzbizz(userOne, userTwo,
                userMain));

        // For countRuns, run this part! ------

        int[] test = { 1, 1, 2, 1, 1 };
        System.out.println("The number of runs is: " + countRuns(test));
    }
}