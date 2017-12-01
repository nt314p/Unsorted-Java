package testing;

public class PrimeNumGen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxNum = 1000;
		int startPrime = 2;
		int numPrimes = 0;
		for (int i = startPrime; i < maxNum; i++) { // i is the number we are checking to be prime

			boolean isPrime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) { // checking if i/j is a whole number
					isPrime = false;
					break;
				}
			}

			if (isPrime) { // printing the prime only if it is true
				numPrimes++;
				System.out.println(i);
			}
		}
		System.out.println(numPrimes);
	}

}
