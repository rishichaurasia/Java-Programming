package Assignment;

import java.util.Scanner;

public class SubsetProblem {
	
	/*
	 Take as input N, a number. Take N more inputs and store that in an array. Take as input target, a number

a. Write a recursive function which counts the number of subsets of the array which sum to target. Print the value returned.

b. Write a recursive function which prints subsets of the array which sum to target. Return type of functions is void.

Input Format
Take as input N, a number. Take N more inputs and store that in an array.Take as input target, a number

Constraints
None

Output Format
Display the number of subsets and print the subsets in a space separated manner.

Sample Input
3
1
2
3
3
Sample Output
1 2  3
2
	 */
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int sum = scn.nextInt();
		printSS(arr, 0, 0, sum, "");
		System.out.println();
		System.out.println(countSS(arr, 0, 0, sum));
		
	}
	
	public static void printSS(int[] arr, int idx, int curr_sum, int sum, String ans) {
		if(curr_sum == sum) {
			System.out.print(ans + " ");
		}
		if(curr_sum>sum)
			return;
		for(int i = idx; i<arr.length; i++) {
			int num = arr[i];
			printSS(arr, i+1, curr_sum + num, sum, ans + num + " " );
		}
		
	}
	
	public static int countSS(int[] arr, int idx, int curr_sum, int sum) {
		if(curr_sum == sum) {
			return 1;
		}
		if(curr_sum>sum)
			return 0;
		int count = 0;
		for(int i = idx; i<arr.length; i++) {
			int num = arr[i];
			count += countSS(arr, i+1, curr_sum + num, sum);
		}
		return count;
	}

}
