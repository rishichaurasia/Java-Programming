package Assignment;

import java.util.Scanner;

public class MaxSubarrayWithEqual0and1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		You are Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s.
//
//		Input Format
//		The first line consists of number of test cases T. For each test case, consists an integer n as length of the array and next line contains n space separated integers.
//
//		Constraints
//		1 <= T <= 10  1 <= n <= 1000000
//
//		Output Format
//		Print the starting index and final index of the required largest subarray. If there is no subarray then print None.
//
//		Sample Input
//		2
//		7
//		1 0 0 1 0 1 1
//		4
//		1 1 1 1
//		Sample Output
//		0 5
//		None 
//		Explanation
//		For first test case largest subarray lies between index 0 to 5.
		
		
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0) {
			int[] arr = new int[scn.nextInt()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			maxSubarray(arr);
		}
	}
	
	public static void maxSubarray(int[] arr) {
		int n = arr.length;
		int sum = 0;
		int maxSize = -1;
		int startIndex = 0;
		for (int i = 0; i < n-1; i++) {
			if(arr[i] == 0)
				sum = -1;
			else
				sum = 1;
			for (int j = i+1; j < n; j++) {
				if(arr[j] == 0)
					sum+=-1;
				else
					sum+=1;
				if(sum == 0 && maxSize<j-i+1) {
					startIndex = i;
					maxSize = j - i + 1;
				}
			}
		}
		if(maxSize == -1)
			System.out.println("None");
		else
			System.out.println(startIndex + " " + (startIndex+maxSize-1));
	}

}
