package testing;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// So I'm not writing the code yet, I'm going to comment what I want to do (this
		// is called pseudocode):

		// declare variables
		boolean won = false;
		int guesses = 0;
		int guess;
		int maxNum = 100;

		// setting up scanner
		Scanner reader = new Scanner(System.in);

		// generate random number
		Random rand = new Random();
		int r = rand.nextInt(maxNum) + 1;

		// ask for guess
		System.out.println("Guess:");

		while (!won) {
			guess = reader.nextInt();
			guesses++;

			// determine higher, lower, or win
			if (guess > r) {
				// if lower say lower and increase guesses, go back to guessing
				System.out.println("Guess Lower:");

			} else if (guess < r) {
				// if higher say higher and increase guesses, go back to guessing
				System.out.println("Guess Higher:");

			} else {
				// if win say win and number of guesses
				won = true;
				System.out.println("You win! It took you " + guesses + " guesses!");
			}
		}
		reader.close();
	}
}
