package Backtracking;

//https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(subsets(nums));

	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		subsets(nums, 0, list, new ArrayList<>());
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

}
