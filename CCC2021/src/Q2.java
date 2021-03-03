import java.util.Scanner;

public class Main {

	static boolean[][] canvas;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);

		int m = reader.nextInt();
		int n = reader.nextInt();
		int k = reader.nextInt();

		canvas = new boolean[m][n];

		boolean[] rowCmds = new boolean[m];
		boolean[] colCmds = new boolean[n];

		for (int i = 0; i < rowCmds.length; i++) {
			rowCmds[i] = false;
		}
		
		for (int i = 0; i < colCmds.length; i++) {
			colCmds[i] = false;
		}
		
		// black = false
		// gold = true

		for (int i = 0; i < k; i++) {
			String input = reader.next();
			int val = reader.nextInt();

			if (input.equals("R")) {
				rowCmds[val - 1] = !rowCmds[val - 1];
			} else {
				colCmds[val - 1] = !colCmds[val - 1];
			}
		}

//		for (int i = 0; i < rowCmds.length; i++) {
//			if (rowCmds[i])
//				row(i);
//		}
//
//		for (int i = 0; i < colCmds.length; i++) {
//			if (colCmds[i])
//				col(i);
//		}
		int sum = 0;

		int sumR = 0;
		for (boolean b : rowCmds) {
			if (b)
				sumR++;
		}
		//System.out.println(sumR);

		int sumC = 0;
		for (boolean b : colCmds) {
			if (b)
				sumC++;
		}
		//System.out.println(sumC);


		sum = n * sumR + sumC * (m - 2 * sumR);
		System.out.println(sum);

//		for (int r = 0; r < m; r++) {
//			for (int c = 0; c < n; c++) {
//				if (canvas[r][c])
//					sum++;
//			}
//		}
		// System.out.println(sum);
	}

	static void row(int r) {
		for (int c = 0; c < canvas[r].length; c++) {
			canvas[r][c] = !canvas[r][c];
		}
	}

	static void col(int c) {
		for (int r = 0; r < canvas.length; r++) {
			canvas[r][c] = !canvas[r][c];
		}
	}

}
