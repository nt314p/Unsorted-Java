import java.util.Arrays;
import java.util.Scanner;

public class Prob5 {

	static int n;
	static Path[] paths;
	static int placeInPath = 0;

	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);

		boolean allReachable = true;
		int numEndPages = 0;
		int endPages[];

		n = reader.nextInt();
		paths = new Path[n]; // array containing pages and info about them

		for (int i = 0; i < n; i++) {
			// instantiating array
			paths[i] = new Path(i + 1, new int[n], new int[n], false, false, false, Integer.MAX_VALUE);
		}

		// setting toPath data
		for (int i = 0; i < n; i++) { // i + 1 is the page number

			int m = reader.nextInt(); // getting the amount of options
			int[] toPaths = new int[m]; // temporary array with size of options

			if (m == 0) {
				numEndPages++;
			}
			for (int j = 0; j < m; j++) { // looping up to m, j is the path number
				toPaths[j] = reader.nextInt(); // putting input into the temporary array
			}

			paths[i].setToPath(toPaths); // setting the toPath to the temporary array
		}

		endPages = new int[numEndPages]; // creating array with size of the number of end pages
		int placeEndPages = 0; // the current place in the array endPages
		for (Path p : paths) {
			if (p.getToPath().length == 0) { // true only if the pages lead nowhere (endpage)
				endPages[placeEndPages] = p.getPage(); // adding the endPage to the endPages array
				placeEndPages++;
			}
		}

		checkSubpages(1); // recursive function to check if the subpages are accessible

		// current page gathering -> current page searching -> place in toPath

		// setting fromPath data
		for (int i = 0; i < n; i++) { // i + 1 is the page number we are finding pages that lead to it

			int numPages = 0; // the number of other pages that lead to the (i + 1)th page
			for (int h = 0; h < 2; h++) { // for loop to switch cases

				// switching what we want to
				// h = 0: finding out how many pages lead to the (i + 1)th page
				// h = 1: filling in the fromPath array for the (i + 1)th page
				switch (h) {
				case 0:
					// j + 1 is the page that we hope contains paths to the (i + 1)th page number
					for (int j = 0; j < n; j++) { // looping through pages

						for (int k = 0; k < paths[j].getToPath().length; k++) { // k is the place in toPath

							if (paths[j].getToPath()[k] == i + 1) { // true if the (j + 1)th page

								if (paths[j].isReachable()) { // true if the (j + 1)th page is reachable
									numPages++; // increment pages if it is found to lead to the current page
								}
							}
						}
					}

				case 1:
					if (!(numPages == 0)) { // true only if more than 0 pages lead to the (i + 1)th page

						// the temporary array where the pages that lead to the (i + 1)th page are
						int[] fromPaths = new int[numPages];
						int currPlace = 0; // our current place in fromPaths
						for (int j = 0; j < n; j++) { // loop though pages again to gather pages that lead

							for (int k = 0; k < paths[j].getToPath().length; k++) { // k is the place in toPath

								// true if the (j + 1)th page has a path that equals our page
								// or in other words, the (j + 1)th page leads to the (i + 1)th page
								if (paths[j].getToPath()[k] == i + 1) {

									if (paths[j].isReachable()) { // true if the (j + 1)th page is reachable

										fromPaths[currPlace] = paths[j].getPage(); // adding the page # to the array
										currPlace++; // incrementing currPlace to avoid overwriting the value
									}
								}
							}
						}

						Arrays.sort(fromPaths); // sorting fromPaths so we get a nice result
						paths[i].setFromPath(fromPaths); // setting the temporary array to fromPaths

					} else {
						// setting fromPath to a blank array 
						// if there are no pages that lead to the (j + 1)th page
						paths[i].setFromPath(new int[0]);
					}
				}
			}
		}

		for (int p : endPages) { // testing distances from all endPages
			generateDistance(p, 1); // generating distances
		}

		// uncomment to get more detailed info about the pages
		// printPageInfo();

		for (Path p : paths) {
			allReachable = allReachable & p.isReachable(); // AND operator to make it false if any are false
		}

		if (allReachable) {
			System.out.println("Y");
		} else {
			System.out.println("N");
		}
		
		System.out.println(paths[0].getDistToEnd()); // printing the distance to the end from the first page

		reader.close(); // closing reader
	}

	// traverses the paths forwards using pages that lead TO other pages
	// it checks if pages are reachable
	public static void checkSubpages(int pNum) { // only to be used if pNum is reachable
		Path p = paths[pNum - 1];

		p.setReachable(true); // the page is reachable

		if (!(p.checkedTo())) { // we don't want to check the subpages of something we already checked
			p.setCheckedTo(true); // the page was checked

			for (int n : p.getToPath()) {
				checkSubpages(n); // looping though the pages that the current page leads to (OHHH RECURSION)
			}
		}
	}

	// traverses the paths backwards using pages that come FROM other pages
	public static void generateDistance(int pNum, int dist) {
		Path p = paths[pNum - 1];

		// setting the distance only if it is smaller than the current one

		if (p.getDistToEnd() > dist) { // running only if it was not checked before (prevents loops)
			p.setDistToEnd(dist);
			p.setCheckedFrom(true); // the page was checked

			for (int i = 0; i < p.getFromPath().length; i++) {
				// run the generate distance for subpages, but add one to the distance
				generateDistance(p.getFromPath()[i], p.getDistToEnd() + 1);
			}
		}
	}

	public static void printPageInfo() {
		// printing out the page path array
		for (int i = 0; i < n; i++) {
			int toPathLen = paths[i].getToPath().length;
			for (int j = 0; j < toPathLen + paths[i].getFromPath().length + 1; j++) { // down

				if (j == 0) {

					System.out.print("Page #");
					System.out.print(paths[i].getPage()); // PAGE
					System.out.print(" | reachable: ");
					System.out.print(paths[i].isReachable()); // REACHABLE
					System.out.print(" | distance to end: ");
					System.out.print(paths[i].getDistToEnd()); // DISTANCE TO THE END
					System.out.print(" | paths: ");
				} else if (j < toPathLen + 1) {

					System.out.print("to page ");
					System.out.print(paths[i].getToPath()[j - 1]); // PAGES THAT IT LEADS TO
					System.out.print(", ");
				} else {

					System.out.print("from page ");
					System.out.print(paths[i].getFromPath()[j - (toPathLen + 1)]); // PAGES IT COMES FROM
					System.out.print(", ");
				}
			}
			System.out.print("\n"); // newline
		}
	}
}