import java.util.Random;
import java.util.Scanner;

class CrapsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            System.out.println("\nWelcome to Craps! Press Enter to roll the dice...");
            scanner.nextLine();

            int firstRoll = rollDice(random);
            System.out.println("You rolled: " + firstRoll);

            if (firstRoll == 7 || firstRoll == 11) {
                System.out.println("Congratulations! You win!");
            } else if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
                System.out.println("Craps! You lose.");
            } else

            {
                int point = firstRoll;
                System.out.println("Your point is set to: " + point);
                System.out.println("Keep rolling! You must roll " + point + " before rolling a 7 to win.");

                int roll;
                do {
                    System.out.println("\nPress Enter to roll again...");
                    scanner.nextLine();
                    roll = rollDice(random);
                    System.out.println("You rolled: " + roll);
                } while (roll != 7 && roll != point);

                if (roll == point) {
                    System.out.println("You rolled your point! You win!");
                } else {
                    System.out.println("" +
                            "You rolled a 7. You lose.");
                }
            }

            playAgain = askToPlayAgain(scanner);

        } while (playAgain);

        System.out.println("Thanks for playing Craps!");
        scanner.close();
    }


    public static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        return die1 + die2;
    }


    public static boolean askToPlayAgain(Scanner scanner) {
        String response;
        while (true) {
            System.out.println("Would you like to play again? (Y/N)");
            response = scanner.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                return true;
            } else if (response.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }
}