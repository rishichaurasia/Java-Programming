package Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/

public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		System.out.println(permute(nums));

	}
	
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> main = new ArrayList<>();
        boolean[] selected = new boolean[nums.length];
        permute(nums, selected, new ArrayList<Integer>(), main);
        return main;
    }

	private static void permute(int[] nums, boolean[] selected, ArrayList<Integer> temp, List main) {
		if(temp.size() == nums.length) {
			main.add(new ArrayList(temp));
			return;
		}
		for(int i = 0; i<nums.length; i++) {
			if(!selected[i]) {
				selected[i] = true;
				temp.add(nums[i]);
				permute(nums, selected, temp, main);
				temp.remove(temp.size()-1);
				selected[i] = false;
			}
		}
		
	}

}
