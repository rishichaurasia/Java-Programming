package Backtracking;

// https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.List;

public class Coombination_Sum_III {

	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		System.out.println(combinationSum3(k, n));
	}

	private static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
        combinationSum3(k, 1, n, list, new ArrayList<>());
        return list;
	}

	private static void combinationSum3(int k, int start, int n, List<List<Integer>> list, ArrayList temp) {
		if(k == 0 && n == 0) {
			list.add(new ArrayList<>(temp));
			return;
		}
		if(k < 0)
			return;
		for(int i = start; i<=n && i<=9; i++) {
			if(n - i >= 0) {
				temp.add(i);
                combinationSum3(k-1, i + 1, n - i, list, temp);
                temp.remove(temp.size() - 1);
			}else
				break;
		}
		
	}

}
