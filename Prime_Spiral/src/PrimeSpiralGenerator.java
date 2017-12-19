import processing.core.PApplet;

public class PrimeSpiralGenerator extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("PrimeSpiralGenerator");
	}

	int[] primes;

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

		generatePrimes(1200000); // generating the primes
		/*
		 * scale = 1; 4,665,600 pixels
		 * scale = 2; 1,166,400	pixels
		 */
		
		
		// for (int i = 0; i < primes.length; i++) {
		// System.out.println(primes[i]);
		// }
		drawSquare(); // drawing the first square
	}

	public void drawSquare() {
		// checking if square number is prime (from array)
		if (primes[squareNum - 1] != 0) {
			// color blue
			stroke(24, 95, 173);
			fill(24, 95, 173);
			//System.out.println("yes: "+primes[squareNum-1]);
		} else {
			// color white
			stroke(255, 255, 255);
			fill(255, 255, 255);
		}
		rect(currX, currY, scale, scale);
		squareNum++;
	}

	public void draw() {
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

			len++;
			
			// flipping draw directions
			xDir *= -1;
			yDir *= -1;
		}

		// move xDir*scale (up)
		// move yDir*scale (left)
		// move xDir*scale (down)
		// move yDir*scale (right)

	}

	public void generatePrimes(int max) {
		primes = new int[max];
		int maxNum = max;
		int startPrime = 2;
		//int numPrimes = 0;
		for (int i = startPrime; i < maxNum; i++) { // i is the number we are checking to be prime

			boolean isPrime = true;
			for (int j = 2; j < Math.round(Math.sqrt(i))+1; j++) { // square rooting
				if (i % j == 0) { // checking if i/j is a whole number
					isPrime = false;
					break;
				}
			}

			if (isPrime) { // printing the prime only if it is true
				primes[i - 1] = i;
				//numPrimes++;
				//System.out.println(i);
			}
		}
	}
}
