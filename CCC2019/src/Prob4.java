import java.util.Arrays;
import java.util.Scanner;

public class Prob4 {

	static int[][] arr = { { 1, 2 }, { 3, 4 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		String s = in.next();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'H') { 
				h();
			}
			if (c == 'V') {
				v();
			}
		}
		
		display();

	}

	public static void display() {
		for (int[] j : arr) {
			for (int n : j) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

	public static void h() {
		int[] tmp = Arrays.copyOf(arr[0], arr[0].length); // holds top
		arr[0] = arr[1];
		arr[1] = tmp;
	}
	
	public static void v() {
		int LT = arr[0][0];
		int LB = arr[1][0];
		
		arr[0][0] = arr[0][1];
		arr[0][1] = LT;
		
		arr[1][0] = arr[1][1];
		arr[1][1] = LB;
	}

}
