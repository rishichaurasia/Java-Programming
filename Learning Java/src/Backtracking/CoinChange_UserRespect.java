package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CoinChange_UserRespect {

	public static void main(String[] args) {
		int[] denominations = new int[] { 1, 2, 3 };
		int target = 5;
		System.out.println(printCombinations(denominations, target));

	}

	private static List<List<Integer>> printCombinations(int[] denominations, int target) {
		List<List<Integer>> list = new ArrayList<>();
//		printCombinations1(denominations, 0, target, list, new ArrayList<Integer>());
		printCombinations2(denominations, 0, target, list, new ArrayList<Integer>());
		return list;
	}
	
	// Infinite supply of coins
	private static void printCombinations1(int[] denominations, int idx, int target, List list, ArrayList temp) {
		if(target == 0)
			list.add(new ArrayList<>(temp));
		for (int i = idx; i < denominations.length; i++) {
			if(target - denominations[i] >= 0) {
				temp.add(denominations[i]);
				printCombinations1(denominations, i, target - denominations[i], list, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
	
	// Limited supply of coins
	private static void printCombinations2(int[] denominations, int idx, int target, List list, ArrayList temp) {
		if(target == 0)
			list.add(new ArrayList<>(temp));
		for (int i = idx; i < denominations.length; i++) {
			if(target - denominations[i] >= 0) {
				temp.add(denominations[i]);
				printCombinations2(denominations, i+1, target - denominations[i], list, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}


}
