package Lec5;

import java.util.Scanner;

public class binarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int[] arr = { 10, 20, 30, 40, 50 };
		int item = scn.nextInt();
		int ret = binarySearch(arr, item);
		System.out.println(ret);
	}

	public static int binarySearch(int[] arr, int item) {
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (item < arr[mid])
				hi = mid - 1;
			else if (item > arr[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}

}
