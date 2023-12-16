import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberOfAttempts = 7;
        int score = 0;

        System.out.println("Welcome to the Guess the Number Game!");

        do {
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            System.out.println("\nI've selected a number between " + lowerBound + " and " + upperBound + ". Try to guess!");

            for (int attempt = 1; attempt <= numberOfAttempts; attempt++) {
                System.out.print("Attempt " + attempt + ": Enter your guess: ");

                // Input validation for integers
                int userGuess = getUserInput(scanner);

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempt + " attempts.");
                    score += numberOfAttempts - attempt + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempt == numberOfAttempts) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing! Your total score is: " + score);
        scanner.close();
    }

    private static int getUserInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the buffer
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
    }
}