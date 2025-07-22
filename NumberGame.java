import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;           // Track rounds won
        boolean playAgain = true;

        System.out.println("===== Welcome to the Number Guessing Game! =====");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int maxAttempts = 7;   // Limit attempts per round
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            // Guess loop
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("🎉 Congratulations! You guessed it in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You couldn't guess the number. It was: " + numberToGuess);
            }

            System.out.println("Your current score (rounds won): " + score);

            // Ask if user wants to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String choice = sc.next().toLowerCase();
            if (!choice.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing! Your total score: " + score);
        sc.close();
    }
}
