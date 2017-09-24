package math;

public class A0PS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 0;
		for (a = 0; a < 12; a += 0.000001) {
			double b = 12 - a;
			double sqrA = Math.sqrt(a);
			double sqrB = Math.sqrt(b);
			if (sqrB > 3.41422 && sqrB < 3.4143) {
				System.out.println(sqrA + ", (" + a + ") " + sqrB + ", (" + b + ")");
			}
		}
	}

}
