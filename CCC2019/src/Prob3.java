import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		String out = "";

		for (int i = 0; i < n + 1; i++) {
			int repeated = 0;
			char prevChar = '!';
			String s = in.nextLine();
			for (int j = 0; j <= s.length(); j++) {
				if (j == s.length()) {
					if (j == 0) {
						break;
					}
					out += repeated + " " + prevChar + " ";
					repeated = 1;
					break;
				}
				char currChar = s.charAt(j);
				if (j == 0) {
					prevChar = currChar;
					repeated = 1;
					continue;
				}
				if (currChar == prevChar) {
					repeated++;
					prevChar = currChar;
				} else {
					out += repeated + " " + prevChar + " ";
					prevChar = currChar;
					repeated = 1;
				}
			}
			out += "\n";
		}

		System.out.println(out);

	}

}
