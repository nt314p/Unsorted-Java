package testing;

import java.util.Scanner;

public class VerifyMagicSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);

		boolean magic = true;
		
		// Add:
		// - check for duplicates
		// - diagonals
		
		// Asking the size of the array
		int size;
		System.out.println("Enter the side length of the square:");
		size = reader.nextInt();

		int[][] square = new int[size][size];
		
		// reading in input to the array
		System.out.println("Enter the square (numbers seperated by spaces):");
		for (int c = 0; c < size; c++) {
			for (int r = 0; r < size; r++) {
				square[r][c] = reader.nextInt();
			}
		}
		
		// checking for uniform sums
		int check = 0;

		for (int r = 0; r < size; r++) {
			check += square[r][0];
		}
		
		// down
		for (int c = 1; c < size; c++) {
			int test = 0;
			for (int r = 0; r < size; r++) {
				test += square[r][c];
			}
			if (!(test == check)) {
				magic = false;
			}
			System.out.println(test);
		}
		
		// right
		for (int r = 0; r < size; r++) {
			int test = 0;
			for (int c = 0; c < size; c++) {
				test += square[r][c];
			}
			if (!(test == check)) {
				magic = false;
			}
			System.out.println(test);
		}
		
		// diagonal down right
		int test = 0;

		for (int i = 0; i < size; i++) {
			test += square[i][i];
		}
		if (!(test == check)) {
			magic = false;
		}
		

		if (magic) {
			System.out.println("magic");
		} else {
			System.out.println("not magic");
		}

	}

}
