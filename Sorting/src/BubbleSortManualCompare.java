import java.util.Scanner;

public class BubbleSortManualCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "adaptable,  affordable, lively, agreeable, accessible, good education options, safe, stable, good jobs, friendly, low unemployment, access to services, walkable or bikeable, develop relationships, welcoming, growing, exciting, healthy, interesting population, good health care, happy, functional, good infrastructure, desirable human features, attractive physical features";
		String[] sortList = s.split(", ");
		Scanner reader = new Scanner(System.in);

		boolean swap = true; // true if there was a swap made that iteration
		int ignore = 0; // ignoring the last n items since they will be greater
		String temp; // temporary variable for swapping

		while (swap) {
			ignore++;
			swap = false; // no swaps have taken place yet

			for (int i = 0; i < sortList.length - ignore; i++) {
				// comparing items and swapping

				System.out.println("a: " + sortList[i] + " or b: " + sortList[i + 1]);
				String in = reader.next();

				if (in.equals("a")) { // only switch if the first one is better
					// swapping
					temp = sortList[i + 1];
					sortList[i + 1] = sortList[i];
					sortList[i] = temp;
					swap = true;
				}
			}
		}

		reader.close();

		for (int i = 0; i < sortList.length; i++) {
			System.out.println(sortList[i]);
		}
	}

	public static String manualCompare(String a, String b) {
		System.out.println("1: " + a + " or 2: " + b);
		int in = reader.nextInt();
		reader.close();

		if (in == 1) {
			return a;
		} else if (in == 2) {
			return b;
		} else {
			return "URBAD";
		}
	}

	public static String[] bubbleSort(String[] sortList) {

		boolean swap = true; // true if there was a swap made that iteration
		int ignore = 0; // ignoring the last n items since they will be greater
		String temp; // temporary variable for swapping

		while (swap) {
			ignore++;
			swap = false; // no swaps have taken place yet

			for (int i = 0; i < sortList.length - ignore; i++) {
				// comparing items and swapping

				String selected = manualCompare(sortList[i], sortList[i + 1]);
				if (sortList[i] == selected) {
					// swapping
					temp = sortList[i + 1];
					sortList[i + 1] = sortList[i];
					sortList[i] = temp;
					swap = true;
				}
			}
		}

		return sortList;
	}
}
