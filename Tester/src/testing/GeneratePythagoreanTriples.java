package testing;

public class GeneratePythagoreanTriples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a;
		long b;
		long c;
		long d;
		long m;
		long n;

		int f = 0;

		int iterations = 25;
		int size = ((iterations - 1) / 2);
		size *= (iterations - 1);

		long cSqu[] = new long[size];
		long bSqu[] = new long[size];
		long aSqu[] = new long[size];

		for (n = 1; n < iterations; n++) {
			for (m = n + 1; m < iterations; m++) {
				a = 2 * m * n;
				b = m * m - n * n;
				c = m * m + n * n;

				System.out.println("a: " + a + ", b: " + b + ", c: " + c);
				cSqu[f] = c;
				bSqu[f] = b;
				aSqu[f] = a;
				f++;
			}
		}

		for (int i = 0; i < cSqu.length; i++) {
			for (int j = 0; j < aSqu.length; j++) {
				if (cSqu[i] == aSqu[j]) {
					System.out.println(cSqu[i] + ", " + aSqu[j]);
					System.out.println("a: " + aSqu[j] + ", b: " + bSqu[j] + ", c: " + cSqu[j]);
					System.out.println("a: " + aSqu[i] + ", b: " + bSqu[i] + ", c: " + cSqu[i]);
				}
				if (cSqu[i] == bSqu[j]) {
					System.out.println(cSqu[i] + ", " + bSqu[j]);
					System.out.println("a: " + aSqu[j] + ", b: " + bSqu[j] + ", c: " + cSqu[j]);
					System.out.println("a: " + aSqu[i] + ", b: " + bSqu[i] + ", c: " + cSqu[i]);
				}
				if (cSqu[j] == 132 || cSqu[i] == 132) {
					System.out.println("potato");
				}
			}
		}
	}

}
