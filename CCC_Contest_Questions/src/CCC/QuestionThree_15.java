package CCC;

import java.util.Scanner;

public class QuestionThree_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		String input = reader.next();

		char[] alpha = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };
		
		char[] vowels = {'a', 'e', 'i', 'o', 'u'};

		for (int i = 0; i < 26; i++) {
			System.out.println(alpha[i]);
		}
		
		for (int j = 0; j < input.length(); j++) {
			// checking if letter is a vowel
			char letter = input.charAt(j);
			for (int k = 0; k < 5; k++) {
				if (letter == vowels[k]) {
					System.out.println("vowel");
				}
			}
		}
	}

}
