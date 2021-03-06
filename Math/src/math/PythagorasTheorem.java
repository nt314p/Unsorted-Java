package math;

import java.util.Scanner;


import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class PythagorasTheorem {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("a\u00B2 + b\u00B2 = c\u00B2");
		System.out.println("Enter the unknown variable (a, b, c):");
		String x = scan.nextLine();
		int a;
		int b;
		int c;
		double ans;

		if ((!(x.equals("a"))) && (!(x.equals("b"))) && (!(x.equals("c")))) {
			System.out.println("Input not valid!");
		}
		if (x.equals("c")) {
			System.out.println("Enter a:");
			a = scan.nextInt();

			System.out.println("Enter b:");
			b = scan.nextInt();

			ans = sqrt(pow(a, 2) + pow(b, 2));
			System.out.println("c = " + ans);

		} else if (x.equals("b")) {
			System.out.println("Enter a:");
			a = scan.nextInt();

			System.out.println("Enter c:");
			c = scan.nextInt();

			ans = sqrt(pow(c, 2) - pow(a, 2));
			System.out.println("b = " + ans);

		} else {
			System.out.println("Enter b:");
			b = scan.nextInt();

			System.out.println("Enter c:");
			c = scan.nextInt();

			ans = sqrt(pow(c, 2) - pow(b, 2));
			System.out.println("a = " + ans);

		}

		scan.close();

	}
}
