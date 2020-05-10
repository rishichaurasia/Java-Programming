package Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/

public class Combination_Sum {

	public static void main(String[] args) {
		int[] arr = new int[] {2, 3, 6, 7};
		int target = 7;
		System.out.println(combinationSum(arr, target));

	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combinationSum(candidates, 0, target, list, new ArrayList<>());
        return list;
    }

	private static void combinationSum(int[] candidates, int idx, int target, List<List<Integer>> list, ArrayList<Integer> temp) {
		if(target == 0) {
			list.add(new ArrayList<>(temp));
			return;
		}
		for(int i = idx; i<candidates.length; i++) {
			if(target - candidates[i] >= 0){
                temp.add(candidates[i]);
                combinationSum(candidates, i, target - candidates[i], list, temp);
                temp.remove(temp.size() - 1);
            }
		}
		
	}

}
