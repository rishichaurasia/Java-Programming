package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take as input N, the size of array. Take N more inputs and store that in an array. Take as input “target”, a number. Write a function which prints all pairs of numbers which sum to target.
//
//		Input Format
//		The first line contains input N. Next N lines contains the elements of array and (N+1)th line contains target number.
//
//		Constraints
//		Length of the arrays should be between 1 and 1000.
//
//		Output Format
//		Print all the pairs of numbers which sum to target. Print each pair in increasing order.
//
//		Sample Input
//		5
//		1
//		3
//		4
//		2
//		5
//		5
//		Sample Output
//		1 and 4
//		2 and 3
//		Explanation
//		Find any pair of elements in the array which has sum equal to target element and print them.

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scn.nextInt();
		int target = scn.nextInt();
//		arrayTargetSumPairs(arr, target);
		targetSum(arr, target);

	}

	public static void arrayTargetSumPairs(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] + arr[j]) == target)
					System.out.println(Math.min(arr[i], arr[j]) + " and " + Math.max(arr[i], arr[j]));
			}
		}
	}

	public static void targetSum(int[] arr, int target) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {
				System.out.println(arr[left] + " and " + arr[right]);
				left++;
				right--;
			}
		}
	}

}
