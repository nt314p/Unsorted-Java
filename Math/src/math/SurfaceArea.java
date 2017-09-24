package math;

import java.util.Scanner;

public class SurfaceArea {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int l;
		int w;
		int h;
		int ans;

		System.out.println("Enter l:");
		l = scan.nextInt();
		System.out.println("Enter w:");
		w = scan.nextInt();
		System.out.println("Enter h:");
		h = scan.nextInt();

		ans = 2 * ((l * w) + (l * h) + (w * h));
		System.out.println("The surface area of a rectangular prism with sides of " + l + ", " + w + ", and " + h + " is " + ans);
		
		scan.close();
	}

}
