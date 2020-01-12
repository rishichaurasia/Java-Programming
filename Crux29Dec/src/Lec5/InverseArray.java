package Lec5;

public class InverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 0, 4, 2, 1 };
		int[] arr1 = inverse(arr);
		display(arr1);
	}

	public static int[] inverse(int[] arr) {
		int[] arr1 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i];
			arr1[val] = i;
		}
		return arr1;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}
