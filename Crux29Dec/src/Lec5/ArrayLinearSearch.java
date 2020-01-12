package Lec5;

import java.util.Scanner;

public class ArrayLinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int[] arr = { 12, 34, 23, 56, 24 };
		int item = scn.nextInt();
		int max_index = linearSearch(arr, item);
		System.out.println(max_index);

	}

	public static int linearSearch(int arr[], int item) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == item) {
				return i;
			}
		}
		return -1;
	}

}
