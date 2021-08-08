package hash;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.commons.codec.digest.DigestUtils;

public class HashCracker {

	static char[] letters;
	static StringBuilder testString;
	static final int len = 21;
	
	static String knownHash = "5F743387A031B7D515A7075ABBBB407FD764DC42C2EB1C45D9858A111F1264529F55C4D184F40B5FE02F5F77FB082A8A2232B959F2456940F7D60CECC9D36A1B";// DigestUtils.sha256Hex("aDaMs");

	public static void main(String[] args) throws Exception {

		final int sbCombs = 1 << len; // 2^len spongebob combinations
		final int maxIterations = (int) Math.pow(26, len);

		knownHash = knownHash.toLowerCase();

		BufferedReader reader = new BufferedReader(new FileReader("src/hash/words.txt"));

		letters = new char[len];
		testString = new StringBuilder("aaaaaaaaaaaaaaaaaaaaa");

		for (int i = 0; i < letters.length; i++) {
			letters[i] = 97;
		}

		long start = System.currentTimeMillis();
		long hashesChecked = 0;

		String nextString = null;

		for (int iterator = 0; iterator < maxIterations; iterator++) {

			nextString = generateNextSequence();
			//nextString = reader.readLine();
			
			checkHash(nextString);

//			String[] combs = getSpongebobCombinations(nextString);
//			for (String s : combs) {
//				checkHash(s);
//			}

			hashesChecked += 1;//(1 << testString.length());

			if (hashesChecked % 10000 == 0) {
				float MHashesPerSecond = ((float) hashesChecked / (System.currentTimeMillis() - start)) / 1000f;
				System.out.println(MHashesPerSecond + " MH/s | " + hashesChecked + " hashes checked");
			}
		}

		reader.close();
	}
	
	public static void checkHash(String hash) throws Exception {
		if (DigestUtils.sha512Hex(hash).equals(knownHash)) {
			System.out.println(hash);
			throw new Exception("Found match!");
		}
	}
	
	public static String generateNextSequence() {
		for (int i = 0; i < letters.length; i++) {
			testString.setCharAt(i, letters[i]);
		}
	
		int index = len - 1;
		letters[index]++;
		while (letters[index] >= 123) {
			letters[index] = 97;
			index -= 1;
			letters[index]++;
		}
		return testString.toString();
	}

	public static String[] getSpongebobCombinations(String str) {
		str = str.toLowerCase();
	
		String upperCaseStr = str.toUpperCase();
		int combinations = 1 << str.length();
		String[] ret = new String[combinations];
	
		StringBuilder temp = new StringBuilder(str);
	
		ret[0] = str;
	
		for (int i = 1; i < combinations; i++) {
			for (int j = str.length() - 1; j >= 0; j--) {
				char c = str.charAt(j);
				if ((i >> (str.length() - j - 1) & 1) == 1) { // odd, capitalize
					c = upperCaseStr.charAt(j);
				}
				temp.setCharAt(j, c);
			}
			ret[i] = temp.toString();
		}
	
		return ret;
	}
}
