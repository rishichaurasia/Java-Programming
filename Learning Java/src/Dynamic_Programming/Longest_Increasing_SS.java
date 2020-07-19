package Dynamic_Programming;

import java.util.Scanner;

public class Longest_Increasing_SS {

	public static void main(String[] args) {
		Scanner scn =new Scanner(System.in);
		int n = scn.nextInt();
		int[] nums = new int[n];
		for(int i = 0; i<n; ++i)
			nums[i] = scn.nextInt();
		System.out.println(LISBU(nums));
	}

	public static int LISBU(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] strg = new int[nums.length];
		strg[0] = 1;
		int maxans = 1;
		for (int i = 1; i < strg.length; i++) {
			int maxval = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					maxval = Math.max(maxval, strg[j]);
				}
			}
			strg[i] = maxval + 1;
			maxans = Math.max(maxans, strg[i]);
		}
		return maxans;
	}

}
