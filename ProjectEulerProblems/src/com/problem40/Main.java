package com.problem40;

import java.util.Scanner;

public class Main {
	
	static String str = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		
		int maxGen = 1000;
		for (int i = 1; i <= maxGen; i++) {
			str += Integer.toString(i);
		}
		for (int i = 1; i <= maxGen; i *= 10) {
			//System.out.println(i + ": " + str.charAt(i - 1));
		}
		System.out.println("done!");
		
		int place = 1;
		int i = 1;
		while (place < 1000000) {
			for (int j = 6; j >= 0; j--) {
				if ((int) Math.pow(10, j) < i) {
					place += j;
				}
			}
			i++;
		}
		System.out.println("place: " + place);
		System.out.println("i: " + i);
		
		
		//while (true) {
			//System.out.println(getDigitAtN(reader.nextInt()));
			//System.out.println("result: " + getDigitAtNAndExp(reader.nextInt(), reader.nextInt()));
		//}
	}

	public static String getDigitAtN(int n) {
		int subtractValue = 0;
		for (int exponent = 6; exponent >= 0; exponent--) {
			int threshold = (int) (Math.pow(10, exponent) * 9 * (exponent + 1));
			if (n > threshold)
				n -= threshold;
		}
		//n -= subtractValue;
		return str.substring(n - 2, n + 2);
	}
	
	public static String getDigitAtNAndExp(int n, int exp) {
		String s = "";
		double fracN = (n * (exp + 1.0)) - exp;
		int floorN = (int) fracN - 1;
		// int) Math.pow(10, exp); i < (int) Math.pow(10, exp + 1);
		int i = (int) (floorN + Math.pow(10, exp));
		
		return Integer.toString(i).charAt(floorN % (exp + 1)) + "";
		
		//System.out.println(s);
		//double fracN = ((exp + 1.0)) - exp;
		//int floorN = (int) fracN - 1;
		//return s.substring(floorN, floorN + 1);
		//return s.substring(floorN, floorN + Math.max(exp, 1));
	}

}
