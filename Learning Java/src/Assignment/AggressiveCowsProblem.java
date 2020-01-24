package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCowsProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Farmer John has built a new long barn, with N (2 <= N <= 100,000) stalls. The stalls are located along a straight line at positions x1,...,xN (0 <= xi <= 1,000,000,000).
//
//		His C (2 <= C <= N) cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, FJ wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
//		Input
//		t – the number of test cases, then t test cases follows.
//		* Line 1: Two space-separated integers: N and C
//		* Lines 2..N+1: Line i+1 contains an integer stall location, xi
//		Output
//		For each test case output one integer: the largest minimum distance.
//		Example
//		Input:
//
//		1
//		5 3
//		1
//		2
//		8
//		4
//		9
//		Output:
//
//		3
//		Output details:
//
//		FJ can put his 3 cows in the stalls at positions 1, 4 and 8,
//		resulting in a minimum distance of 3.
		
		
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int C = scn.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int largestMinDist = binarySearch(arr, C);
		System.out.println(largestMinDist);
	}
	
	public static int binarySearch(int[] arr, int C) {
		Arrays.sort(arr);
		int start = 0, end = arr[arr.length-1], max = -1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(check(arr, mid, C)) {
				if(mid>max)
					max = mid;
				start = mid+1;
			}
			else
				end = mid-1;
		}
		
		return max;
	}
	
	public static boolean check(int[] arr, int mid, int C) {
		int cows = 1, pos = arr[0];
		for(int i = 1; i<arr.length; i++) {
			if(arr[i] - pos >= mid) {
				pos = arr[i];
				cows++;
				if(cows == C)
					return true;
			}
		}
		return false;
	}

}
