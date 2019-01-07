import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int numLines = Integer.parseInt(in.nextLine());
		BigInteger totalMaxY = new BigInteger("0");

		int[][] data = new int[numLines][2];
		for (int i = 0; i < numLines; i++) {
			String line = in.nextLine();
			String[] arr = line.split(" ");
			data[i][0] = Integer.parseInt(arr[0]); // slope
			data[i][1] = Integer.parseInt(arr[1]); // y int
		}

		for (int i = 0; i < numLines; i++) {
			BigInteger maxY = new BigInteger("0");

			for (int j = 1; j <= 100000; j++) {
				int m = data[i][0];
				int b = data[i][1];

				//long maxY = Math.max(getY(j, m, b), getY(j, m, b));
				//BigInteger h = new BigInteger(getY(j, m, b));
				maxY = maxY.add(getY(j, m, b));
				if (j==1)
					System.out.println(getY(j, m, b));
			}
			if (maxY.compareTo(totalMaxY) > 0) {
				totalMaxY = maxY;
			}
			
		}
		System.out.println(totalMaxY);
		

	}

	public static BigInteger getY(int x, int m, int b) {
		return new BigInteger((m * x) + b + "");
	}

}
