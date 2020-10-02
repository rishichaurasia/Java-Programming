package July_Long_Challenge;

import java.util.Arrays;
import java.util.Scanner;

public class Doctor_Chef {

	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		int t = scn.nextInt();
		while(t-- > 0) {
			int n = scn.nextInt();
			int x = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			solve(arr, x);
		}

	}
	
	public static void solve(int[] arr, long x) {
//		System.out.println(Integer);
		Arrays.sort(arr);
		int i = 0;
		long min = 0;
		while(i<arr.length && arr[i] < x) {
			++i;
			++min;
		}
		int j = i;
		int min1 = 0;
		for(; i<arr.length; ++i) {
			while(x < arr[i]) {
				x = x<<1;
				min1++;
//				System.out.println(x + " " + min);
			}
			min1++;
			x = (long)arr[i] * 2;
		}
		if(j != 0) {
			--j;
			x = arr[j];
			int min2 = -1;
			for(; j<arr.length; ++j) {
				while(x < arr[j]) {
					x = x<<1;
					min2++;
//					System.out.println(x + " " + min);
				}
				min2++;
				x = (long)arr[j] * 2;
			}
			System.out.println(Math.min(min1, min2) + min);
			return;
		}
		System.out.println(min + min1);
	}

}
