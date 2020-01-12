package Lec5;

import java.util.Scanner;

public class RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = { 10, 20, 30, 40, 50 };
		arrayRotate(arr, n);
		display(arr);
	}

	public static void arrayRotate(int[] arr, int n) {

		n %= arr.length;

		if (n < 0)
			n += arr.length;
		for (int i = 1; i <= n; i++) {
			int last = arr[arr.length - 1];
			for (int j = arr.length - 1; j > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[0] = last;
		}
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}
