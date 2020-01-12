package Lec5;

import java.util.Scanner;

public class SubarrySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40 };
//		printSubarraySum3loops(arr);
		printSubarraySum2loops(arr);
	}

	public static void printSubarraySum3loops(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				System.out.println(sum);
			}
			System.out.println();
		}
	}

	public static void printSubarraySum2loops(int[] arr) {
		for (int si = 0; si < arr.length; si++) {
			int sum = 0;
			for (int ei = si; ei < arr.length; ei++) {
				sum += arr[ei];
				System.out.println(sum);
			}

		}
	}

}
