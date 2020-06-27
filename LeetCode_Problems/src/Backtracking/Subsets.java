package Backtracking;

//https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(subsets2(nums));

	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
//		subsets(nums, 0, list, new ArrayList<>());
		subsets1(nums, 0, list, new ArrayList<>());
		return list;
	}

	private static void subsets(int[] nums, int idx, List<List<Integer>> list, ArrayList temp) {
		if(idx == nums.length) {
			list.add(new ArrayList<>(temp));
			return;
		}
		temp.add(nums[idx]);
		subsets(nums, idx + 1, list, temp);
		temp.remove(temp.size() - 1);
		subsets(nums, idx + 1, list, temp);
	}
	
	private static void subsets1(int[] nums, int idx, List<List<Integer>> list, ArrayList temp) {
		list.add(new ArrayList<>(temp));
		for(int i = idx; i < nums.length; i++) {
			temp.add(nums[i]);
			subsets1(nums, i+1, list, temp);
			temp.remove(temp.size() - 1);
		}

	}
	
	private static List<List<Integer>> subsets2(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<>());
		for(int i = 0; i<nums.length; i++) {
			int length = subsets.size();
			for(int j= 0; j<length; j++) {
				List<Integer> currentSS = new ArrayList<>(subsets.get(j));
				currentSS.add(nums[i]);
				subsets.add(currentSS);
			}
		}
		return subsets;
	}

}
