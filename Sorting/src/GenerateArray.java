
public class GenerateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = generateArray(-37, 7, 3);

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static int[] generateArray(int min, int max, int length) {
		if (max - min + 1 < length) {
			return null;
		} else {
			int[] nums = new int[max - min + 1];
			int[] genArray = new int[length];

			// filling num array with consecutive ints
			for (int i = 0; i < max - min + 1; i++) {
				nums[i] = min + i;
			}
			
			
			
			return nums;
		}

	}

}
