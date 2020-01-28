package Assignment;

import java.util.Scanner;

public class MaxSumPathIn2Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		You are provided two sorted arrays. You need to find the maximum length of bitonic subsequence. You need to find the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays. You can switch from one array to another array only at common elements.
//
//		Input Format
//		First line contains integer t which is number of test case. For each test case, it contains two integers n and m which is the size of arrays and next two lines contains n and m space separated integers respectively.
//
//		Constraints
//		1<=t<=100 1<=n,m<=100000
//
//		Output Format
//		Print the maximum path.
//
//		Sample Input
//		1
//		8 8
//		2 3 7 10 12 15 30 34
//		1 5 7 8 10 15 16 19
//		Sample Output
//		122
//		Explanation
//		122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34
		
		
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int i = 1; i<=t; i++) {
			int n = scn.nextInt();
			int m = scn.nextInt();
			int[] arr1 = new int[n];
			int[] arr2 = new int[m];
			for (int j = 0; j < arr1.length; j++) {
				arr1[j] = scn.nextInt();
			}
			for (int j = 0; j < arr2.length; j++) {
				arr2[j] = scn.nextInt();
			}
			int sum = maxSumPathInTwoArrays(arr1, arr2);
			System.out.println(sum);
		}

	}
	
	public static int maxSumPathInTwoArrays(int[] arr1, int[] arr2) {
		int i = 0;
		int j = 0;
		int sum1 = 0;
		int sum2 = 0;
		int sum = 0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<arr2[j]) {
				sum1+=arr1[i];
				i++;
			}
			else if(arr1[i]>arr2[j]) {
				sum2+=arr2[j];
				j++;
			}
			else {
				sum1+=arr1[i];
				sum2+=arr2[j];
				sum = Math.max(sum1, sum2);
				sum1 = sum;
				sum2 = sum;
				i++;
				j++;
			}
		}
		while(i<arr1.length)
			sum1+=arr1[i++];
		while(j<arr2.length)
			sum2+=arr2[j++];
		sum = Math.max(sum1, sum2);
		return sum;
	}

}
