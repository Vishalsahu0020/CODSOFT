package codsoft;

import java.util.Random;
import java.util.Scanner;

public class Task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsWon = 0;

        while (playAgain) {
            int lowerpoint = 1;
            int upperpoint = 100;
            int numberToGuess = random.nextInt(upperpoint - lowerpoint + 1) + lowerpoint;
            int attempts = 0;
            int maxAttempts = 10;
            boolean hasWon = false;

            System.out.println("A new round has started!");
            System.out.println("Guess the number between " + lowerpoint + " and " + upperpoint);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    hasWon = true;
                    totalScore += (maxAttempts - attempts + 1);  // Higher score for fewer attempts
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!hasWon) {
                System.out.println("You've used all attempts. The correct number was " + numberToGuess);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over!");
        System.out.println("Total score: " + totalScore);
        System.out.println("Rounds won: " + roundsWon);

        scanner.close();

    }
}
