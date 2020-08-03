package Lec15;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 60, 30, 10, 50, 20, 10, 80 };
		quickSort(arr, 0, arr.length - 1);
		for (int val : arr)
			System.out.println(val);
	}

	// Best : O(nlogn) Time | O(logn) Space
	// Average : O(nlogn) Time | O(logn) Space
	// Worst : O(n^2) Time | O(logn) Space
	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];
		int left = lo;
		int right = hi;
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);
	}

}
