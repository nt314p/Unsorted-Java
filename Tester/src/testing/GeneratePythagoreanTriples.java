package testing;

public class GeneratePythagoreanTriples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a;
		long b;
		long c;
		long m;
		long n;

		int f = 0;

		int iterations = 45; // must be odd for some reason...
		float size = ((iterations - 1) / 2);
		size *= (iterations - 2);

		long cSqu[] = new long[(int) size];
		long bSqu[] = new long[(int) size];
		long aSqu[] = new long[(int) size];
//		long simLeg[] = new long[(int) size];
//		long simHyp[] = new long[(int) size];



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
					System.out.print(cSqu[i] + ", " + aSqu[j]);
					System.out.print("; a: " + aSqu[j] + ", b: " + bSqu[j] + ", c: " + cSqu[j]);
					System.out.println("; a: " + aSqu[i] + ", b: " + bSqu[i] + ", c: " + cSqu[i]);
				}
				if (cSqu[i] == bSqu[j]) {
					System.out.print(cSqu[i] + ", " + bSqu[j]);
					System.out.print("; a: " + aSqu[j] + ", b: " + bSqu[j] + ", c: " + cSqu[j]);
					System.out.println("; a: " + aSqu[i] + ", b: " + bSqu[i] + ", c: " + cSqu[i]);
				}
			}
		}
	}

}
