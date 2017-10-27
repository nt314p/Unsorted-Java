
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {};
		
		long startTime = System.currentTimeMillis();
		
		int[] sortedArray = bubbleSort(array);
		
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;

		for(int i = 0; i< sortedArray.length; i++) {
			System.out.println(sortedArray[i]);
		}
		
		System.out.println("Millis: " + time);
		
		
		
		/*
		long startTime = System.currentTimeMillis();

		int[] sortList = {1, 2, 3};

		boolean swap = true; // true if there was a swap made that iteration
		int ignore = 0; // ignoring the last n items since they will be greater
		int temp; // temporary variable for swapping

		while (swap) {
			ignore++;
			swap = false; // no swaps have taken place yet

			for (int i = 0; i < sortList.length - ignore; i++) {
				// comparing items and swapping

				if (sortList[i] > sortList[i + 1]) {
					// swapping
					temp = sortList[i + 1];
					sortList[i + 1] = sortList[i];
					sortList[i] = temp;
					swap = true;
				}
			}
		}
		
		for(int i = 0; i< sortList.length; i++) {
			System.out.println(sortList[i]);
		}

		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;

		System.out.println("Millis: " + time);
		*/
	}
	
	public static int[] bubbleSort(int[] sortList) {

		boolean swap = true; // true if there was a swap made that iteration
		int ignore = 0; // ignoring the last n items since they will be greater
		int temp; // temporary variable for swapping

		while (swap) {
			ignore++;
			swap = false; // no swaps have taken place yet

			for (int i = 0; i < sortList.length - ignore; i++) {
				// comparing items and swapping

				if (sortList[i] > sortList[i + 1]) {
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
