
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long startTime = System.currentTimeMillis();

		int[] sortList = { 4, 3, 5, 1, 2 };

		boolean swap = true; // true if there was a swap made that iteration
		int ignore = 0; // ignoring the last n items since they will be greater
		int temp; // temporary variable for swapping
		
		while (swap) {
			
			for (int i = 0; i < sortList.length - ignore; i++) {
				//comparing items and swapping
				if (sortList[i] > sortList[i+1]) {
					// swapping
					temp = sortList[i+1];
					sortList[i+1] = sortList[i];
					sortList[i] = temp;
				}
			}
		}

		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;

		System.out.println("Millis: " + time);
	}

}
