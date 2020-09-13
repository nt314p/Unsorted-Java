package com.problem50;

public class Main {

	public static void main(String[] args) {
		int[] primes = new int[78498];
		primes[0] = 2;
		primes[1] = 3;
		int index = 2;

		for (int i = 4; i <= 1000000; i++) {
			boolean isPrime = true;
			for (int j = 0; j < index; j++) {
				if (i % primes[j] == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime)
				primes[index++] = i;
		}
		System.out.println("Done!");
		System.out.println("Generated: " + index);
		for (int i : primes) {
				System.out.println(i);
		}
		BinaryTree bt = new BinaryTree(primes);
		System.out.println("Generated BST!");
		
	}

}
