package Array;

public class ArrayBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {88, 66, 55, 33, 22};
		int[] arr = { 23, 45, 34, 78, 45, 13, 28 };
		bubbleSort(arr);
		for (int val : arr)
			System.out.print(val + " ");
	}

	// Best : O(n^2) Time | O(1) Space
	// Average : O(n^2) Time | O(1) Space
	// Worst : O(n^2) Time | O(1) Space
	public static void bubbleSort(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int i = 0; i < arr.length - counter - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

	// Best : O(n) Time | O(1) Space
	// Average : O(n^2) Time | O(1) Space
	// Worst : O(n^2) Time | O(1) Space
	// An optimized version of Bubble Sort
	static void bubbleSort(int arr[], int n) {
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < n - 1; i++) {
			swapped = false;
			for (j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j] and arr[j+1]
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			// IF no two elements were
			// swapped by inner loop, then break
			if (swapped == false)
				break;
		}
	}

}
