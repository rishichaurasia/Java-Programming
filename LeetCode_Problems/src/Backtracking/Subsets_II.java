package Backtracking;

//https://leetcode.com/problems/subsets-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {

	public static void main(String[] args) {
		int[] nums = new int[] { 4, 4, 4, 1, 4 };
		System.out.println(subsetsWithDup(nums));

	}
	
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		subsetsWithDup1(nums, 0, list, new ArrayList<>());
		return list;
    }

	private static void subsetsWithDup(int[] nums, int idx, List<List<Integer>> list, ArrayList temp) {
		if(idx == nums.length) {
			list.add(new ArrayList<>(temp));
			return;
		}
		temp.add(nums[idx]);
		subsetsWithDup(nums, idx + 1, list, temp);
		temp.remove(temp.size() - 1);
		idx++;
		while(idx < nums.length && nums[idx-1] == nums[idx])
			idx++;
		subsetsWithDup(nums, idx, list, temp);
		
	}
	
	private static void subsetsWithDup1(int[] nums, int idx, List<List<Integer>> list, ArrayList temp) {
		list.add(new ArrayList<>(temp));

		for(int i = idx; i<nums.length; i++) {
			if(i > idx && nums[i] == nums[i-1])
				continue;
			temp.add(nums[i]);
			subsetsWithDup1(nums, i + 1, list, temp);
			temp.remove(temp.size() - 1);
		}
	}

}
