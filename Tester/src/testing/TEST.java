package testing;

import java.util.Scanner;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mystery(5));
	}

	public static int mystery(int b) {
		if (b == 0)
			return 0;
		if (b % 2 == 0)
			return mystery(b - 1) + 3;
		else
			return mystery(b - 1) + 2;
	}

}
