package Array;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 23, 45, 34, 78, 46, 13, 28 };
		insertionSort(arr);
		for (int val : arr)
			System.out.print(val + " ");

	}

	public static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int val = arr[i];
			int j;
			for (j = i - 1; j >= 0 && arr[j] > val; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = val;

		}

	}

}
