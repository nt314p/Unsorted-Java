
public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 10, 3, 4, 5, 7, 1, 2 };

		for (int i = 0; i < arr.length; i++) {

			int min = 0;
			int index = i;

			for (int j = i; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					index = j;
				}
			}
			int tmp = arr[i];
			arr[i] = min;
			arr[index] = tmp;
		}

		for (int n : arr) {
			System.out.println(n);
		}
	}

}
