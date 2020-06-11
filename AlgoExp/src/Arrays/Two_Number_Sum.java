package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Two_Number_Sum {

	public static void main(String[] args) {
		int[] arr = {3, 5, -4, 8, 11, 1, -1, 6};
		int targetSum = 10;
//		int[] res = sol1(arr, targetSum);
//		int[] res = sol2(arr, targetSum);
		int[] res = sol3(arr, targetSum);
		for(int i: res)
			System.out.print(i+" ");
	}
	
	//O(n^2) time | O(1) space
	public static int[] sol1(int[] arr, int targetSum) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if(arr[i] + arr[j] == targetSum) {
					return new int[] {arr[i], arr[j]};
				}
			}
		}
		return new int[0];
	}
	
	//O(n) time | O(n) space
	public static int[] sol2(int[] arr, int targetSum) {
		Set<Integer> seen = new HashSet<Integer>();
		for(int curr: arr) {
			int currMatch = targetSum-curr;
			if(seen.contains(currMatch))
				return new int[] {curr, currMatch};
			else
				seen.add(curr);
		}
		return new int[0];
	}
	
	//O(nlogn) time | O(1) space
	public static int[] sol3(int[] arr, int targetSum) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length-1;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(sum < targetSum)
				left++;
			else if(sum > targetSum)
				right--;
			else
				return new int[] {arr[left], arr[right]};
		}
		return new int[0];
	}

}
