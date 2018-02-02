import processing.core.PApplet;

public class PrimeSpiralGenerator extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("PrimeSpiralGenerator");
	}

	int[] primes;
	int[] semiprimes;
	int[] primePlaces; // the nth prime number list, where the nth element is the (n+1)th prime number

	int sWidth = 2160;
	int sHeight = 1440;
	int scale = 2;

	int currX = Math.round(sWidth / 2);
	int currY = Math.round(sHeight / 2);

	int xDir = -1;
	int yDir = -1;
	int len = 1;
	int squareNum = 1;

	int startX = currX;
	int startY = currY;

	public void settings() {
		// size(sWidth, sHeight);
		fullScreen();
	}

	public void setup() {
		frameRate(60);

		rectMode(CENTER); // draw rectangle from center

		strokeWeight(0); // no stroke
		generatePrimes(300000); // generating the primes
		generateSemiprimes(1200000);

		// scale = 1; 4,665,600 pixels
		// scale = 2; 1,166,400 pixels
		// scale = 4; 0,291,600 pixels

		drawSquare(); // drawing the first square
	}

	public void drawSquare() {
		// me splendid if else statements

		if (squareNum == 1) {
			// coloring first square red
			stroke(255, 0, 0);
			fill(255, 0, 0);

		} else if (isSemiprime(squareNum)) {

			stroke(0, 128, 0);
			fill(0, 128, 0);

		} else if (isPrime(squareNum)) { // checking if square number is prime (from array)

			// color blue
			stroke(24, 95, 173);
			fill(24, 95, 173);

		} else {
			// color white
			stroke(255, 255, 255);
			fill(255, 255, 255);
		}
		rect(currX, currY, scale, scale);
		squareNum++;
	}

	public void draw() {
		if (squareNum < (Math.pow((sWidth / scale + 1), 2))) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < len; j++) {
					// y movement
					currY += yDir * scale;
					drawSquare();
				}

				for (int j = 0; j < len; j++) {
					// x movement
					currX += xDir * scale;
					drawSquare();
				}

				// increasing the side length
				len++;

				// flipping draw directions
				xDir *= -1;
				yDir *= -1;
			}
		}

		// move xDir*scale (up)
		// move yDir*scale (left)
		// move xDir*scale (down)
		// move yDir*scale (right)
	}

	public void generatePrimes(int max) {
		long startTime = System.currentTimeMillis();
		
		primes = new int[max];
		int maxNum = max;
		int startPrime = 2;
		int numPrimes = 0;
		for (int i = startPrime; i < maxNum; i++) { // i is the number we are checking to be prime

			boolean isPrime = true;
			for (int j = 2; j < Math.round(Math.sqrt(i)) + 1; j++) { // square rooting to stop O(n^2) <- i have no idea
				if (i % j == 0) { // checking if i/j is a whole number, if it is, i is not prime
					isPrime = false;
					break;
				}
			}

			if (isPrime) { // printing the prime only if it is true
				primes[i - 1] = i;
				numPrimes++;
			}
		}
		
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		System.out.println("Generated " + numPrimes + " prime numbers in " + time + " milliseconds!");
		
		numberOffPrimes(numPrimes); // generating a list without spaces... HackSort??!??
	}

	public void numberOffPrimes(int numOfPrimes) {
		int n = 0; // the current place in the array
		primePlaces = new int[numOfPrimes]; // setting the value of the array to hold the prime numbers
		for (int number : primes) {
			if (number != 0) { // if it doesn't equal 0, it's prime!
				primePlaces[n] = primes[number - 1];
				n++;
			}
		}
	}

	public void generateSemiprimes(int max) {
		int highestPrime = nextHighestPrime(max);
		int hPrimeRoot = (int) Math.round(Math.sqrt(highestPrime));
		int currNum = 1; // the current number we are on (may or may not be prime)
		int primeNum = -1; // the nth place of the prime number where n is the (n+1)th place
		semiprimes = new int[highestPrime];
		while (currNum < hPrimeRoot) {
			if (isPrime(currNum)) { // checking for primeness
				// the prime number's place to iterate up to
				int iterPrimePlace = primePosition(nextHighestPrime((int) (highestPrime / currNum - 0.5f)));
				primeNum++;

				for (int i = 0; i < iterPrimePlace; i++) {
					try {
						int semiMultiple = currNum * primePlaces[i];
						semiprimes[semiMultiple - 1] = semiMultiple;
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Semiprime multiple not in prime bounds");
					}
				}
			}
			currNum++;
		}
	}

	public int primePosition(int prime) {
		for (int n = 0; n < primePlaces.length; n++) {
			if (primePlaces[n] == prime) {
				return n;
			}
		}

		System.out.println("Prime position not found");
		return 0;
	}

	public int nextHighestPrime(int num) {
		int i = 0;
		while (true) { // I like to live dangerously...
			if (isPrime(num + i)) { // checking if number is prime (from array)
				return num + i;
			} else {
				i++;
			}
		}
	}

	public boolean isPrime(int num) {
		try {
			if (primes[num - 1] != 0) { // checking if number is prime (from array)
				return true;
			} else {
				return false;
			}
		} catch (IndexOutOfBoundsException e) {

		}
		// System.out.println("isPrime reached exception with a value of: " + num);
		return false;
	}

	public boolean isSemiprime(int num) {
		try {
			if (semiprimes[num - 1] != 0) { // checking if number is semiprime (from array)
				return true;
			} else {
				return false;
			}
		} catch (IndexOutOfBoundsException e) {

		}
		System.out.println("isSemiprime reached default of false");
		return false;
	}
}
