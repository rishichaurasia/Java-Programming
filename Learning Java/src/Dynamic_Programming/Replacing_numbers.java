package Dynamic_Programming;

import java.util.Scanner;

public class Replacing_numbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++)
			arr[i] = scn.nextInt();
//		int[] arr = {1,-5,8,12,-8};
		System.out.println(getMax(arr, 0, -10000001, -10000001, 0));
		
	}
	
	public static int getMax(int[] arr, int idx, int currSum, int maxSum, int isReplaced) {
		
		if(idx == arr.length) {
			if(isReplaced == 1)
				return maxSum;
			return Integer.MIN_VALUE;
		}
		
		int ans1 = Integer.MIN_VALUE;
		if(isReplaced == 0) {
			int currSum1 = Math.max(currSum+arr[idx]*arr[idx], arr[idx]*arr[idx]);
			int maxSum1 = Math.max(maxSum, currSum1);
			ans1 = getMax(arr, idx+1, currSum1, maxSum1, 1);
		}
		
		currSum = Math.max(currSum+arr[idx], arr[idx]);
		maxSum = Math.max(maxSum, currSum);
		int ans2 = getMax(arr, idx+1, currSum, maxSum, isReplaced);
		
		int ans = Math.max(ans1, ans2);
		
		return ans;
		
	}

}
