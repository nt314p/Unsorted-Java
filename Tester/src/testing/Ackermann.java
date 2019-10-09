package testing;

public class Ackermann {
	
//	private static int[][] lookup = new int[100000][100000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int ackval = ack(i, j);
				//lookup[i][j] = ackval;
				System.out.println(i + ", " + j + ": " + ackval);
			}
		}
	}
	
	public static int ack(int m, int n) {
//		if (lookup[(int) m][(int) n] != 0) {
//			return lookup[(int) m][(int) n];
//		}
		if (m == 0) return n + 1;
		if (m > 0 && n == 0) return ack(m-1, 1);
		if (m > 0 && n > 0) return ack(m-1, ack(m, n-1));
		return 0/0;
	}

}
