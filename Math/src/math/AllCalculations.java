package math;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.Math.PI;
import static java.lang.Math.cbrt;

public class AllCalculations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(6*6*1/3);
	}

	public static double opCyl(double x, String given) {
		double ans;
		if (given == "SA") {
			ans = x / (6 * PI);
			ans = sqrt(ans);
			return ans;
		} else if (given == "V") {
			ans = x / (2 * PI);
			ans = cbrt(ans);
			return ans;
		}
		return 0.0;
	}

	public static double vRectP(double l, double w, double h) { // *
		double ans;
		ans = l * w * h;
		return ans;
	}

	public static double vPrism(double aBase, double height) {
		double ans;
		ans = aBase * height;
		return ans;
	}

	public static double vPyr(double aBase, double height) {
		// Pyramid volume finder (works for cones too)
		double ans;
		ans = vPrism(aBase, height) / 3;
		return ans;
	}

	public static double vSphere(double r) {
		// System.out.println("V = 4/3\u03C0r\u00B3");
		double ans;
		ans = (4 * (PI * pow(r, 3))) / 3;
		return ans;
	}

	public static double vCyl(double r, double h) {
		double ans;
		ans = PI * pow(r, 2) * h;
		return ans;
	}

	public static double saPrism(double aBase, double bSum, double height) {
		// bSum is the perimeter of the base shape
		double ans;
		ans = 2 * (aBase) + bSum * height;
		return ans;
	}

	public static double saCone(double r, double height) {
		double ans;
		ans = PI * pow(r, 2) + PI * r * Pyt(height, r, "c");
		return ans;
	}

	public static double saRectP(double l, double w, double h) {
		double ans;
		ans = (l * w) + (l * h) + (w * h);
		return ans;
	}

	public static double saSquarePyr(double side, double height) { // *
		double ans;
		ans = pow(side, 2) + 2 * ((Pyt(side / 2, height, "c") * side)); // *2
																		// only
																		// because
																		// 4 and
																		// 2
																		// cancel
		return ans;
	}

	public static double saSphere(double r) {
		double ans;
		ans = 4 * (PI * pow(r, 2));
		return ans;
	}

	public static double saPyr(double aBase, int sides, double aTri) {
		double ans;
		ans = aBase + sides * (aTri);
		return ans;
	}

	public static double aTri(double base, double height) {
		double ans;
		ans = (base * height) / 2;
		return ans;
	}

	public static double aCirc(double r) {
		double ans;
		ans = PI * (pow(r, 2));
		return ans;
	}

	public static double aRect(double l, double w) {
		double ans;
		ans = l * w;
		return ans;
	}

	public static double pCirc(double r) {
		double ans;
		ans = PI * 2 * r;
		return ans;
	}

	public static double pRect(double l, double w) {
		double ans;
		ans = 2 * (l + w);
		return ans;
	}

	public static double Pyt(double x, double y, String z) {
		// z is the unknown value
		// x should always be bigger than y

		double ans;

		if (z.equals("c")) {

			ans = sqrt(pow(x, 2) + pow(y, 2));
			return (ans);

		} else if (z.equals("b")) {

			ans = sqrt(pow(x, 2) - pow(y, 2));
			return (ans);

		} else {

			ans = sqrt(pow(x, 2) - pow(y, 2));
			return (ans);

		}

	}

}
