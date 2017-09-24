package math;


import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class MathTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double ansC;
		double ansD;
		double ans;
		double x = 6.92819;
		ansC = sqrt(16 + pow(x, 2));
		ansD = sqrt(144 + pow(x, 2));
		System.out.println(ansC);
		System.out.println(ansD);
		ans = sqrt(pow(ansC, 2) + pow(ansD, 2));
		System.out.println(ans);
		
	}

}
