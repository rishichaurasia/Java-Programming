package Assignment;

import java.util.Scanner;

public class RainWaterTrapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		You are given an input array whose each element represents the height of a line towers. The width of every tower is 1. It starts raining. Water is filled between the gap of towers if possible. You need to find how much water filled between these given towers.
//
//		Input Format
//		The first line consists of number of test cases T. Each test case consists an integer N as number of towers and next line contains the N space separated integers.
//
//		Constraints
//		1 <= N <= 1000000 1 <= t <= 10 0 <= A[i] <= 10000000
//
//		Output Format
//		Print how much unit of water collected among towers for each test case.
//
//		Sample Input
//		2
//		6
//		3  0  0  2  0  4
//		12
//		0  1  0  2  1  0  1  3  2  1  2  1
//		Sample Output
//		10
//		6
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		while(T-->0) {
			int N = scn.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			int water = trappedWater(arr);
			System.out.println(water);
		}

	}
	
	public static int trappedWater(int[] arr) {
		int water = 0;
		int n = arr.length;
		int[] left = new int[n];
		int[] right = new int[n];
		
		left[0] = arr[0];
		for (int i = 1; i < n; i++) {
			left[i] = Math.max(left[i-1], arr[i]);
		}
		
		right[n-1] = arr[n-1];
		for (int i = n-2; i >= 0; i--) {
			right[i] = Math.max(right[i+1], arr[i]);
		}
		
		for (int i = 1; i < n-1; i++) {
			water += Math.min(left[i], right[i]) - arr[i];
		}
		
		return water;
	}

}
