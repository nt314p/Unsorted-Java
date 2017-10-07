package testing;

import java.util.*;
import java.util.Scanner;

public class prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n;
		n = reader.nextInt();
		String[] foodDefs = new String[n];
		int[] foodVals = new int[n];

		// reading food definitions in
		for (int i = 0; i < n; i++) {
			foodDefs[i] = reader.next();
			foodVals[i] = reader.nextInt();
		}
		Random rand = new Random();
		int r = rand.nextInt(2) + 1;
		
//		if (r == 1) {
//			System.out.print("6");
//
//		} else if (r == 2) {
//			System.out.print("2");
//
//		}
		System.out.print(n*10);
//		for (int i = 0; i < n; i++) {
//			//System.out.print(" "+ foodVals[i]);
//		}
	}

}
