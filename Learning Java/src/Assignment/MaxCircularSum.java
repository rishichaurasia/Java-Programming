package Assignment;

import java.util.Scanner;

public class MaxCircularSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * You are provided n numbers (both +ve and -ve). Numbers are arranged in a circular form. You need to find the maximum sum of consecutive numbers.

Input Format
First line contains integer t which is number of test case.
For each test case, it contains an integer n which is the size of array and next line contains n space separated integers denoting the elements of the array.

Constraints
1<=t<=100
1<=n<=1000
|Ai| <= 10000

Output Format
Print the maximum circular sum for each testcase in a new line.

Sample Input
1
7
8 -8 9 -9 10 -11 12
Sample Output
22
Explanation
Maximum Circular Sum = 22 (12 + 8 - 8 + 9 - 9 + 10)
		 */
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int i = 1; i<=t; i++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scn.nextInt();
			}
			int sum = Math.max(maxCircularSum(arr),kadane(arr));
			System.out.println(sum);
		}

	}
	
	public static int maxCircularSum(int[] arr) {
		int min_ending_here = arr[0];
		int min_so_far = arr[0];
		int sum = arr[0];
		for(int i = 1; i<arr.length; i++) {
			sum+=arr[i];
			min_ending_here = Math.min(arr[i], min_ending_here + arr[i]);
			min_so_far = Math.min(min_so_far, min_ending_here);
		}
		return sum - min_so_far;
	}
	
	public static int kadane(int[] arr) {
		int max_current = 0;
		int max_so_far = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max_current+=arr[i];
			max_so_far = Math.max(max_so_far, max_current);
			if(max_current<0)
				max_current = 0;
		}
		return max_so_far;
	}
	
	public static int maxCircularSum2(int[] arr) {
		int max_kadane = kadane(arr);
		int sum_total = 0;
		for (int i = 0; i < arr.length; i++) {
			sum_total += arr[i];
			arr[i] = -arr[i];
		}
		return Math.max(max_kadane, sum_total + kadane(arr));
	}

}
