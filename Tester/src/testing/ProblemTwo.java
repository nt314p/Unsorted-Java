package testing;

import java.util.Scanner;

public class ProblemTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n;
		n = reader.nextInt();
		String[] foodDefs = new String[n];
		int[] foodVals = new int[n];

		// reading food definitions in
		for (int i = 0; i < n; i++) {
			foodDefs[i] = reader.next();
			foodVals[i] = reader.nextInt();
		}

		int f; // i think its f
		f = reader.nextInt();

		String[] foodNames = new String[f];
		int[] dist = new int[f];

		// reading food distances and names in
		for (int i = 0; i < f; i++) {
			foodNames[i] = reader.next();
			dist[i] = reader.nextInt();
		}


		// int[] sortedList = new int[dist.length]; // Output

		int maxItem = dist[0];
		int minItem = dist[0];

		// Finding maximum and minimum item in the sortList array
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] > maxItem) {
				maxItem = dist[i];
			}

			if (dist[i] < minItem) {
				minItem = dist[i];
			}
		}

		if (minItem == 0) {

			int[] spaceSorted = new int[maxItem + 1]; // This is the sorted array, but it has spaces

			// Setting input list to the spaced out list
			for (int i = 0; i < dist.length; i++) {
				spaceSorted[dist[i]] = dist[i];
			}

			for (int i = 0; i < spaceSorted.length; i++) {
				//System.out.println(spaceSorted[i]);
			}
			
			
		} else {
			System.out.println("0");
		}
		
		reader.close();
	}
}
