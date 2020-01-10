package Array;

import java.util.Scanner;

public class ArrayLinearSearch {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 12, 34, 23, 45, 24 };
		System.out.println("Enter search value");
		int item = scn.nextInt();
		int output = arrayLinearSearch(arr, item);
		System.out.println(output);

	}

	public static int arrayLinearSearch(int arr[], int item) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == item) {
				return i;
			}

		}
		return -1;

	}

}
