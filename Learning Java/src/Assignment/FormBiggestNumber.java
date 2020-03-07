package Assignment;

import java.util.Scanner;

public class FormBiggestNumber {

	/*
	 * You are provided an array of numbers. You need to arrange them in a way that yields the largest value.

Input Format
First line contains integer t which is number of test case.
For each test case, you are given a single integer n in the first line which is the size of array A[] and next line contains n space separated integers denoting the elements of the array A .

Constraints
1<=t<=100
1<=m<=100
1<=A[i]<=10^5

Output Format
Print the largest value.

Sample Input
1
4
54 546 548 60

Sample Output
6054854654
Explanation
Upon rearranging the elements of the array , 6054854654 is the largest possible number that can be generated.
	 */
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0) {
			int n = scn.nextInt();
			int[] num_arr = new int[n];
			for (int i = 0; i < num_arr.length; i++) {
				num_arr[i] = scn.nextInt();
			}

			formBiggestNumber(num_arr);
			for (int i = 0; i < num_arr.length; i++) {
				System.out.print(num_arr[i]);
			}
			System.out.println();
		}
	}
	
	public static void formBiggestNumber(int[] num_arr) {
		
		for(int i = 0; i<num_arr.length - 1; i++) {
			for(int j = i+1; j<num_arr.length; j++) {
				if(compare(num_arr[i], num_arr[j]) < 0)
					swap(num_arr, i , j);
			}
		}
	}
	
	public static int compare(int val1, int val2) {
		String s1 = "" + val1 + val2;
		String s2 = "" + val2 + val1;
		long num1 = Long.parseLong(s1);
		long num2 = Long.parseLong(s2);
		if(num1>=num2)
			return 1;
		else
			return -1;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
