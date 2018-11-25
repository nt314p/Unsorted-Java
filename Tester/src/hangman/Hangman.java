package hangman;

import java.util.Scanner;

public class Hangman {

	static String phrase = "united states of america";
	static String guessedPhrase = "";
	int wrongGuesses = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);


		// System.out.println(replaceSequence("Hello Kids", "BOIS", 6));
		
		for (int i = 0; i < phrase.length(); i++) {
			guessedPhrase += (!(phrase.charAt(i)==' ')) ? "_" : " ";
		}
		System.out.println(guessedPhrase);
		
		// printing out spaces
		for (int i = 0; i < 20; i++) {
			char n = reader.next().charAt(0);
			System.out.println(guessLetter(n));
			System.out.println(guessedPhrase);
		}

	}

	public static boolean guessLetter(char letter) {

		for (int i = 0; i < phrase.length(); i++) {
			if (phrase.charAt(i) == letter) {
				guessedPhrase = replaceSequence(guessedPhrase, letter+"", i);
			} else if (phrase.charAt(i) == ' ') {
				guessedPhrase = replaceSequence(guessedPhrase, " ", i);
			}
		}
		return phrase.indexOf(letter) != -1;
	}
	
	public static String replaceSequence(String target, String replace, int index) {
		String a = target.substring(0, index);
		String b = target.substring(index + replace.length());
		return a + replace + b;
	}

}
