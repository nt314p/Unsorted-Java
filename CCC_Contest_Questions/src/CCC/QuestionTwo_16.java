package CCC;

import java.util.Scanner;

public class QuestionTwo_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);

		int MagicSquare[][] = new int[4][4]; // the magic square
		int sum; // the number the rows and columns should add up too
		boolean magic = true; // if the square is magic or not

		// reading in integers

		for (int c = 0; c < 4; c++) { // columns
			for (int r = 0; r < 4; r++) { // rows
				MagicSquare[r][c] = reader.nextInt();
			}
		}

		reader.close();
		
		// setting sum to the sum of the first row
		sum = MagicSquare[0][0] + MagicSquare[0][1] + MagicSquare[0][2] + MagicSquare[0][3];

		// checking if any of the rows do not add up to sum
		for (int r = 1; r < 4; r++) {
			if (!(MagicSquare[r][0] + MagicSquare[r][1] + MagicSquare[r][2] + MagicSquare[r][3] == sum)) {
				magic = false;
			}
		}

		// checking if any of the columns do not add up to sum
		for (int c = 0; c < 4; c++) {
			if (!(MagicSquare[0][c] + MagicSquare[1][c] + MagicSquare[2][c] + MagicSquare[3][c] == sum)) {
				magic = false;
			}
		}

		// printing out answer
		if (magic) {
			System.out.println("magic");
		} else {
			System.out.println("not magic");
		}
	}

}
