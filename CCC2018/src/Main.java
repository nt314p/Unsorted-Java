import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);

		int n = reader.nextInt();

		int[][] grid = new int[n][n];
		int[][] tmp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = reader.nextInt();
			}
		}

		int[][] sides = new int[(n - (n % 2)) / 2][(n - (n % 2)) * 4 - 4];

		for(int i = 0; i<n; i++) {
			for (int j =0; j<n; j++) {
				System.out.print(grid[i][j]);
				if(!(j+1==n)){
				System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
		
////		System.out.println((n - (n % 2)) / 2);
////		System.out.println((n - (n % 2)) * 4 - 4);
//
//		for (int in = 0; in < n / 2; in++) {
//			int loc = -1;
//
//			for (int i = 0; i < n - (2 * in); i++) { // top
//				sides[in][i] = grid[in][in + i];
//				loc++;
//			}
//
//			for (int j = 0; j < n - 2 - 2 * in; j++) {
//				sides[in][n + j * 2 + in] = grid[j + in + 1][(n / 2) - (n / 2 - in)];
//				sides[in][n + 1 + j * 2 + in] = grid[j + in + 1][(n / 2) + (n / 2 - in) - 1];
//				loc += 2;
//			}
//
//			for (int i = 0; i < n - (2 * in); i++) { // bottom
//				sides[in][loc + i + 1] = grid[n - 1 - in][in + i];
//			}
//
//			for (int i = 0; i < 12; i++) {
//				//System.out.println(sides[in][i]);
//			}
//		}
//		// row check
//		for (int k = 0; k < n; k++) {
//			for (int i = 0; i < n; i++) {
//				for (int j = i; j < n; j++) {
//					if (grid[k][i] > grid[k][j]) {
//						//System.out.println("row!");
//					}
//				}
//			}
//		}
//
//		// column check
//		for (int k = 0; k < n; k++) {
//			for (int i = 0; i < n; i++) {
//				for (int j = i; j < n; j++) {
//					if (grid[i][k] > grid[j][k]) {
//						//System.out.println("column!");
//					}
//				}
//			}
//		}
//
//		if (n % 2 == 0) {
//
//			for (int depth = 0; depth < n / 2; depth++) { // from the middle
//				for (int z = 0; z < 4; z++) { // four sides
//					int sidelen = 2 * depth + 1;
//					int side[] = new int[sidelen];
//					for (int i = 0; i < sidelen; i++) {
//						if (z == 0) {
//							side[i] = grid[0][i]; // top
//						} else if (z == 1) {
//							side[i] = grid[n - 1][i]; // right
//						} else if (z == 2) {
//							side[i] = grid[i][n - 1]; // bottom
//						} else if (z == 3) {
//							side[i] = grid[i][0]; // left
//						}
//					}
//
//				}
//			}
//
//		}

		reader.close();

	}

}
