package testing;

import java.util.Scanner;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		for (int i = 0; i < 100; i++) {
			int x = reader.nextInt();
			double ans = x * 10000 / 321369;
			System.out.print(ans/100);
		}
		reader.close();
	}

}
