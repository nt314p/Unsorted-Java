import java.util.ArrayList;
import java.util.Scanner;

public class Prob1S {

	static ArrayList<Integer> primes;
	static int[] primesL;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int max = 1000;
		primes = new ArrayList<Integer>();

		generatePrimes(max);

		int t = in.nextInt();

		for (int i = 0; i < t; i++) {
			int n = in.nextInt();
			// n = in.nextInt();
			for (int j = 0; n - j > 0; j++) {
				int lower = primesL[n - j - 1];
				int higher = primesL[n + j - 1];
				if (lower != 0 && higher != 0) {
					System.out.println(lower + " " + higher);
					break;
				}
			}
		}

//		for (int n : primesL) {
//			System.out.println(n);
//		}
	}

	public static void generatePrimes(int max) {

		primesL = new int[max];
		int maxNum = max;
		int startPrime = 2;
		int numPrimes = 0;
		for (int i = startPrime; i < maxNum; i++) {

			boolean isPrime = true;
			for (int j = 2; j < Math.round(Math.sqrt(i)) + 1; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				primesL[i - 1] = i;
				primes.add(i);
				numPrimes++;
			}
		}
	}

}
