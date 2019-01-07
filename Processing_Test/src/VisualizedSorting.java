import java.util.ArrayList;

import processing.core.PApplet;
import processing.sound.*;


public class VisualizedSorting extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VisualizedSorting rs = new VisualizedSorting();
		PApplet.runSketch(new String[] { "VisualizedSorting" }, rs);

	}

	final int msdelay = 1;

	float sWidth = 1200;
	float sHeight = 800;
	int[] x = createSequentialArray(500);
	
	SinOsc sine;
	TriOsc triOsc;

	Runnable myrunnable = new Runnable() {
		public void run() {
			// radixSort(x, 2);
			// selectionSort(x);
			 insertionSort(x);
			// cocktailSort(x);
			System.out.println("Sort Complete.");
		}
	};

	public void setup() {
		frameRate(10);
		stroke(255);
//		sine = new SinOsc(this);
//		sine.play();
		
		triOsc = new TriOsc(this);
		triOsc.play();
		new Thread(myrunnable).start();
	}
	
	public void settings() {
		fullScreen();

		size((int) sWidth, (int) sHeight);
		System.out.println(width + "x" + height);
	}

	public void draw() {
		background(0);
		drawArray(x);
	}
	
	public int get(int arr[], int index) {
		//sine.freq(map(arr[index], 1, x.length, 200, 3000));
		triOsc.freq(map(arr[index], 1, x.length, 200, 2000));
		return arr[index];
	}

	public void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j])
					minIndex = j;
				delay(msdelay);
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}

	public void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int temp = get(arr, i);
			int j;

			for (j = i - 1; j >= 0 && temp < get(arr, j); j--) {
				arr[j + 1] = get(arr, j);
				delay(msdelay);
			}

			arr[j + 1] = temp;
		}
	}

	public int[] bubbleSort(int[] arr) {

		boolean swap = true; // true if there was a swap made that iteration
		int ignore = 0; // ignoring the last n items since they will be greater
		int temp; // temporary variable for swapping

		while (swap) {
			ignore++;
			swap = false; // no swaps have taken place yet

			for (int i = 0; i < arr.length - ignore; i++) {
				// comparing items and swapping

				if (arr[i] > arr[i + 1]) {
					// swapping
					temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
					swap = true;
				}
				delay(msdelay);
			}
		}

		return arr;
	}

	public void cocktailSort(int[] arr) {

		boolean swap = true; // true if there was a swap made that iteration
		int ignoreLast = 0; // ignoring the last n items since they will be greater
		int ignoreFirst = 0;
		int temp; // temporary variable for swapping

		while (swap) {
			swap = false; // no swaps have taken place yet
			ignoreLast++;

			for (int i = ignoreFirst; i < arr.length - ignoreLast; i++) {
				// comparing items and swapping

				if (arr[i] > arr[i + 1]) {
					// swapping
					temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
					swap = true;
				}
				delay(msdelay);
			}

			for (int i = arr.length - ignoreLast - 1; i >= ignoreFirst; i--) {
				// comparing items and swapping

				if (arr[i] > arr[i + 1]) {
					// swapping
					temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
					swap = true;
				}
				delay(msdelay);
			}
			ignoreFirst++;

		}
	}

	public void radixSort(int[] arr, int base) {
		int maxValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
			}
		}

		int exponent = (int) Math.ceil(Math.log(maxValue) / Math.log(base)) + 1;

		ArrayList<Integer>[] queue = new ArrayList[base];

		for (int exp = 0; exp < exponent; exp++) { //

			for (int i = 0; i < queue.length; i++) {
				queue[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < arr.length; i++) { // which digit are we sorting, ex: base=2, digits are 0 and 1
				int digit = (int) (arr[i] / (Math.pow(base, exp)) % base);
				queue[digit].add(arr[i]);
			}

			int j = 0;
			for (int k = 0; k < queue.length; k++) {
				for (int l = 0; l < queue[k].size(); l++) {
					arr[j] = queue[k].get(l);
					j++;
				}
			}
			delay(msdelay);
			System.out.println("Exponent: " + exp + ", Multiple: " + Math.pow(base, exp));
			display(queue);
		}
	}

	public static void display(ArrayList<Integer>[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(j + ": ");
			for (int i : arr[j]) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public void drawArray(int[] arr) {
		float hScaler = (float) height / arr.length;
		float wScaler = (float) width / arr.length;
		//System.out.println("w: " + wScaler + ", h: " + hScaler);
		//System.out.println(width+ "W:H" + height);
		for (int i = 0; i < arr.length; i++) {
			float x = i * wScaler;
			float h = (float) (hScaler * arr[i]);
			float y = (height - h);
			//System.out.println("x: " + x + ", y: " + y);

			rect(x, y, wScaler, h);
		}
	}

	public static int[] createArray(int size) {
		int[] arr = new int[size];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10000);
		}

		return arr;
	}

	public int[] createSequentialArray(int size) {
		int[] arr = new int[size];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}

		for (int i = 0; i < size * 4; i++) {
			int index1 = (int) (Math.random() * arr.length);
			int index2 = (int) (Math.random() * arr.length);
			swap(arr, index1, index2);
		}

		return arr;
	}

	public void swap(int[] arr, int index1, int index2) { // NO WORK
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	public static void display(int[] arr) {
		for (int a : arr) {
			System.out.printf("%2d ", a);
		}
		System.out.println();
	}

}
