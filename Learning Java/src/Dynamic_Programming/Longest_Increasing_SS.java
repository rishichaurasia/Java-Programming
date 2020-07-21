package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_Increasing_SS {

	public static void main(String[] args) {
//		Scanner scn =new Scanner(System.in);
//		int n = scn.nextInt();
//		int[] nums = new int[n];
//		for(int i = 0; i<n; ++i)
//			nums[i] = scn.nextInt();
		
		int nums[] = {10,9,2,5,3,7,101,18};
		
		System.out.println(LISRS(nums, Integer.MIN_VALUE, 0));
		
		int memo[][] = new int[nums.length][nums.length];
		for (int[] l : memo) {
            Arrays.fill(l, -1);
        }
		
		System.out.println(LISTD(nums, -1, 0, new int[nums.length][nums.length]));
		
		System.out.println(LISBU(nums));
		
		System.out.println(LISBUEff(nums));
	}
	
	// O(2^n) Time
	public static int LISRS(int[] nums, int prev, int idx) {
		
		if(idx == nums.length)
			return 0;
		
		int taken = 0;
		if(nums[idx] > prev)
			taken = LISRS(nums, nums[idx], idx+1) + 1;
		int notTaken = LISRS(nums, prev, idx+1);
		
		return Math.max(taken, notTaken);
		
	}
	
//	Recursion with memoisation
//	O(n^2) Time | O(n^2) space + Rec. space
	public static int LISTD(int[] nums, int prevIdx, int cidx, int[][] memo) {
		
		if(cidx == nums.length)
			return 0;
		
		if(memo[prevIdx+1][cidx] != 0)
			return memo[prevIdx+1][cidx];
		
		int taken = 0;
		if(prevIdx < 0 || nums[cidx] > nums[prevIdx])
			taken = LISTD(nums, cidx, cidx+1, memo) + 1;
		int notTaken = LISTD(nums, prevIdx, cidx+1, memo);
		
		int ans = Math.max(taken, notTaken);
		
		memo[prevIdx+1][cidx] = ans;
		
		return ans;
		
	}

//	O(n^2) Time | O(n) space
	public static int LISBU(int[] nums) {
		if(nums == null || nums.length == 0)
            return 0;
		int[] strg = new int[nums.length];
		strg[0] = 1;
		int maxans = 1;
		for (int i = 1; i < strg.length; i++) {
			int maxval = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					strg[i] = Math.max(strg[i], strg[j]);
				}
			}
			strg[i] += 1;
			maxans = Math.max(maxans, strg[i]);
		}
		return maxans;
	}
	
//	O(nlogn) Time | O(n) space
	public static int LISBUEff(int[] nums) {
		if(nums == null || nums.length == 0)
            return 0;
		
		int[] le = new int[nums.length];
		le[0] = nums[0];
		int len = 1;
		
		for(int i = 1; i<nums.length; ++i) {
			
			if(nums[i] > le[len-1]) {
				le[len] = nums[i];
				++len;
			}else {
				int idx = binarySearch(le, 0, len-1, nums[i]);
				le[idx] = nums[i];
			}
			
		}
		
		return len;
	}
	
	public static int binarySearch(int[] le, int si, int ei, int item) {
		
		while(si <= ei) {
			int mid = (si+ei)/2;
			
			if(le[mid] < item)
				si = mid+1;
			else
				ei = mid-1;
		}
		
		return si;
		
	}

}
