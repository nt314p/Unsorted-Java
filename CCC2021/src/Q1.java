import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		
		int n = reader.nextInt();
		
		int[] heights = new int[n + 1];
		int[] widths = new int[n];
		
		int area = 0;
		
		for (int i = 0; i <= n; i++) {
			heights[i] = reader.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			widths[i] = reader.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			int h1 = heights[i];
			int h2 = heights[i + 1];
			int w = widths[i];
			area += (h1 + h2) * w;
		}
		
		System.out.println(area*0.5);
	}

}
