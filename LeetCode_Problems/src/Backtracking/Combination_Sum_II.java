package Backtracking;

// https://leetcode.com/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Combination_Sum_II {

	public static void main(String[] args) {
		int[] arr = new int[] {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		System.out.println(combinationSum2(arr, target));

	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new ArrayList<>();
		if(candidates.length==0 || candidates==null)
        {
            return list;
        }
		Arrays.sort(candidates);
        combinationSum2(candidates, 0, target, list, new ArrayList<>());
        return list;
    }
	
	private static void combinationSum2(int[] candidates, int idx, int target, List<List<Integer>> list, ArrayList<Integer> temp) {
		if(target == 0) {
			list.add(new ArrayList<>(temp));
			return;
		}
		for(int i = idx; i<candidates.length; i++) {
			if(i > idx && candidates[i] == candidates[i-1])
				continue;
			if(target - candidates[i] < 0)
                break;
            temp.add(candidates[i]);
            combinationSum2(candidates, i+1, target - candidates[i], list, temp);
            temp.remove(temp.size() - 1);
            
			
		}
		
	}
}
