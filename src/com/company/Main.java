package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private int guessedNumber;

    public static void main(String[] args) {
	// write your code here
        Main main = new Main();
        main.startGame();
    }

    private void startGame() {
        int guessesRemaining = 0;
        int randomNumber = (int) Math.ceil(Math.random() * 10);

        Scanner input = new Scanner(System.in);

        do {
            try {
                System.out.println("Try to guess a number between 1 and 10");
                System.out.println("Enter your guess: ");
                guessedNumber = input.nextInt();

                if (guessesRemaining == 4) {
                    System.out.println("You are out of guesses.");
                    restartGame();
                } else if (guessedNumber > randomNumber) {
                    System.out.println("Too high.");
                    guessesRemaining++;
                } else if (guessedNumber < randomNumber) {
                    System.out.println("Too low.");
                    guessesRemaining++;
                } else if (guessedNumber == randomNumber) {
                    System.out.println("Good job. You are wizard.");
                    restartGame();
                }
            } catch (InputMismatchException name) {
                System.out.println("Please enter a number between 1 and 10");
                input.next();
            }
        } while (guessesRemaining <= 4 && guessedNumber != randomNumber);

    }

    private void restartGame() {
        String userChoice = "";
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to play again? Y or N");
        userChoice = input.nextLine();

        if (userChoice.toUpperCase().equals("Y")) {
            startGame();
        } else {
            System.out.println("Thank you for playing!");
            System.exit(0);
        }
    }
}
