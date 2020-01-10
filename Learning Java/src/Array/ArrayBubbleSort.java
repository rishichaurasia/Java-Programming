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

}
