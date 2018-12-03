package testing;

import java.util.Scanner;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.print("Hand: ");
			System.out.println(isFlush(in.nextLine()));
		}
	}
	
	public static boolean isFlush(String hand) {
		char suit = '0';
		String[] cards = hand.split(" ");
		for (int i = 0; i < cards.length; i++) {
			char currSuit = cards[i].charAt(cards[i].length()-1);
			if (suit=='0') {
				suit = currSuit;
			} else if (!(currSuit == suit)) {
				return false;
			}
		}
		return true;
	}

}
