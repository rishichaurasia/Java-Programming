package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/

public class Permutations_II {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2};
		System.out.println(permute(nums));

	}
	
	public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer>> main = new ArrayList<>();
        boolean[] selected = new boolean[nums.length];
        permuteUnique(nums, selected, new ArrayList<Integer>(), main);
        return main;
    }

	private static void permuteUnique(int[] nums, boolean[] selected, ArrayList<Integer> temp, List main) {
		if(temp.size() == nums.length) {
			main.add(new ArrayList(temp));
			return;
		}
		for(int i = 0; i<nums.length; i++) {
			if(selected[i]) {
				continue;
			}
			if(i>0 && nums[i] == nums[i-1] && selected[i-1])
				continue;
			selected[i] = true;
			temp.add(nums[i]);
			permuteUnique(nums, selected, temp, main);
			temp.remove(temp.size()-1);
			selected[i] = false;
		}
		
	}
	
//	public static List<List<Integer>> permuteUnique(int[] nums) {
//        
//    }

}
