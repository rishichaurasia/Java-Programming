package Assignment;

import java.util.Scanner;

public class SplitArrayRecursion {

	/*
	 * Take as input N, a number. Take N more inputs and store that in an array.
	 * 
	 * a. Write a recursive function which counts the number of ways the array could
	 * be split in two groups, so that the sum of items in both groups is equal.
	 * Each number in the array must belong to one of the two groups. Print the
	 * value returned.
	 * 
	 * b. Write a recursive function which keeps track of ways an array could be
	 * split in two groups, so that the sum of items in both groups is equal. Each
	 * number in the array must belong to one of the two groups. Return type of
	 * function should be void. Print the two groups, each time you find a
	 * successful split.
	 * 
	 * Input Format Take as input N, a number. Take N more inputs and store that in
	 * an array.
	 * 
	 * Constraints None
	 * 
	 * Output Format Display the number of ways the array can be split and display
	 * all the groups in a comma separated manner
	 * 
	 * Sample Input 6 1 2 3 3 4 5 
	 * Sample Output 
	 * 1 2 3 3 and 4 5 
	 * 1 3 5 and 2 3 4 
	 * 1 3 5 and 2 3 4
	 * 2 3 4 and 1 3 5 
	 * 2 3 4 and 1 3 5 
	 * 4 5 and 1 2 3 3 
	 * 6
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		splitArray(arr, 0, 0, 0, "", "");
		System.out.println(count);

	}
	
	static int count = 0;
	
	public static void splitArray(int[] arr, int idx, int sum1, int sum2, String s1, String s2) {
		if(idx == arr.length) {
			if(sum1==sum2) {
				System.out.println(s1 + "and " + s2);
				count++;
			}
			return;
		}
		splitArray(arr, idx+1, sum1+arr[idx], sum2, s1+arr[idx]+" ", s2);
		splitArray(arr, idx+1, sum1, sum2+arr[idx], s1, s2+arr[idx]+ " ");
		
	}

}
