import java.util.Scanner;

public class Prob2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		String out = "";
		int n = in.nextInt();
		
		for (int i = 0; i < n; i++) {
			int m = in.nextInt();
			String k = in.next();
			//System.out.println(k);
			String[] kArr = k.split(" ");
			//int m = Integer.parseInt(kArr[0]);
			for (int j = 0; j < m; j++) {
				out += k;
			}
			out += "\n";
		}
		System.out.println(out);
	}

}
