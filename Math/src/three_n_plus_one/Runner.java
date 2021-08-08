package three_n_plus_one;

import java.util.ArrayList;
import java.util.HashSet;

import processing.core.PApplet;

public class Runner extends PApplet {

	public static void main(String[] args) {
		Runner r = new Runner();
		PApplet.runSketch(new String[] { "Runner" }, r);
	}

	public void settings() {
		size(1920, 1080);
		fullScreen();
	}

	public void draw() {
		background(0);
		Generator g = new Generator(1920);
		stroke(255);
		for (int num = 0; num < 1080; num += (int) (Math.random() * 20)) {
			ArrayList<Integer> sequence = g.getFullSolution(num + 1);
			System.out.println(sequence.size());
			for (int x = 0; x < sequence.size(); x++) {
				int white = color(255);
				set(sequence.get(x), x * 5, white);
//				int x1 = x;
//				int x2 = x + 1;
//				int y1 = sequence.get(x1);
//				int y2 = sequence.get(x2);
//				line(y1/10, x1 * 10, y2/10, x2 * 10);
			}
		}
	}

	private void drawInputVsValues(Generator g) {
		HashSet<Integer> primes = generatePrimes(3000);
		for (int y = 0; y < 1080; y++) {
			ArrayList<Integer> sequence = g.getFullSolution(y + 1);
			System.out.println(sequence.size());
			for (int value : sequence) {
				int clr = color(255);
				if (value % 2 == 0)
					clr = color(0, 255, 0);
				if (primes.contains(value))
					clr = color(255, 0, 255);
				set(value, y, clr);
			}
		}
	}

	private HashSet<Integer> generatePrimes(int max) {
		HashSet<Integer> primes = new HashSet<Integer>();
		int maxNum = max;
		int startPrime = 2;

		for (int i = startPrime; i < maxNum; i++) { // i is the number we are checking to be prime

			boolean isPrime = true;
			for (int j = 2; j < Math.round(Math.sqrt(i)) + 1; j++) { // square rooting to stop O(n^2) <- i have no idea
				if (i % j == 0) { // checking if i/j is a whole number, if it is, i is not prime
					isPrime = false;
					break;
				}
			}

			if (isPrime) { // printing the prime only if it is true
				primes.add(i);
			}
		}

		return primes;
	}
}
