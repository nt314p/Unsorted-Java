import java.util.Scanner;

public class Main {

	static int maxP = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);

		int n = reader.nextInt();

		int[] p = new int[n];
		int[] w = new int[n];
		int[] d = new int[n];

		for (int i = 0; i < n; i++) {
			p[i] = reader.nextInt();
			maxP = Math.max(maxP, p[i]);
			w[i] = reader.nextInt();
			d[i] = reader.nextInt();
		}

		long lowest = Long.MAX_VALUE;

		if (maxP <= 2000) {
			for (int c = 0; c <= maxP; c++) {
				long val = eval(n, c, p, w, d);
				if (val < lowest) {
					lowest = val;
				}
			}

			System.out.println(lowest);
		} else {
			float divisions = 6;

			for (float c = 0; c <= maxP; c += maxP / divisions) {

				long val = cast(n, (int) c, p, w, d);
				if (val < lowest) {
					lowest = val;
				}
			}
			System.out.println(lowest);
		}

		// System.out.println(goodC);
	}

	static long cast(int n, int c, int[] p, int[] w, int[] d) {
		long lowest = Long.MAX_VALUE;

		int range = 10000;

		float testC = c;

		long slope = 1000000000;

		float sign = Math.signum(slope(n, c, p, w, d));
		while (true) {
			slope = slope(n, (int) testC, p, w, d);
			testC -= (slope / (Math.random()*5+2)) + Math.signum(slope);
			if (sign * Math.signum(slope) < 0)
				break;
		}

		c = (int) testC;
		if (sign > 0) {
			for (int i = c; i < Math.min(maxP, c + range); i++) {
				long val = eval(n, i, p, w, d);
				if (val < lowest) {
					lowest = val;
				}
			}
		} else {
			for (int i = c; i >= Math.max(0, c - range); i--) {
				long val = eval(n, i, p, w, d);
				if (val < lowest) {
					lowest = val;
				}
			}
		}

		return lowest;
	}

	static long slope(int n, int c, int[] p, int[] w, int[] d) {
		long y2 = eval(n, c + 1, p, w, d);
		long y1 = eval(n, c, p, w, d);
		return y2 - y1;
	}

	static long eval(int n, int c, int[] p, int[] w, int[] d) {
		long sum = 0;
		for (int i = 0; i < n; i++) {

			int diff = Math.abs(c - p[i]);
			if (diff <= d[i])
				continue;

			int walkDist = diff - d[i];
			sum += walkDist * w[i];
		}
		return sum;
	}
}
