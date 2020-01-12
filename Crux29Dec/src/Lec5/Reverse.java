package Lec5;

import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int[] arr = { 10, 20, 30, 40, 50 };
		reverse(arr);
		display(arr);
	}

	public static void reverse(int[] arr) {
		for (int i = 0; i <= arr.length / 2; i++) {
			int rev_index = arr.length - i - 1;
			int temp = arr[i];
			arr[i] = arr[rev_index];
			arr[rev_index] = temp;
		}
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

}
