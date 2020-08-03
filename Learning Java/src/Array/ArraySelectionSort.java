package Array;

public class ArraySelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 23, 45, 34, 78, 46, 13, 28 };
		selectionSort(arr);
		for (int val : arr)
			System.out.print(val + " ");
	}

	// Best : O(n^2) Time | O(1) Space
	// Average : O(n^2) Time | O(1) Space
	// Worst : O(n^2) Time | O(1) Space
	public static void selectionSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min])
					min = j;
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}

	}

}
