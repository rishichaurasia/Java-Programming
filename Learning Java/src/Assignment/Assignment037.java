package Assignment;

import java.util.Scanner;

public class Assignment037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int i = 1; i<=t; i++) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = scn.nextInt();
			}
			int sum = maxCircularSum(arr);
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

}
