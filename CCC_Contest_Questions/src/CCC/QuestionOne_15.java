package CCC;

import java.util.Scanner;

public class QuestionOne_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int month = 2;
		int day = 14;
		
		if (month < 2) {
			System.out.println("Before");
		} else if (month > 2) {
			System.out.println("After");
		} else {
			if (day < 18) {
				System.out.println("Before");
			} else if (day > 18) {
				System.out.println("After");
			} else {
				System.out.println("Special");
			}
		}
	}

}
