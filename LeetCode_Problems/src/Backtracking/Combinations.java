package Backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/

public class Combinations {

	public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println(combine(n, k));
	}
	
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		combine(n, 1, k, list, new ArrayList<>());
//		combine1(n, 1, k, list, new ArrayList<>());
		return list;
    }

	private static void combine(int n, int start, int k, List<List<Integer>> list, ArrayList arrayList) {
		if(k == 0) {
			list.add(new ArrayList<>(arrayList));
			return;
		}
		
		for(int i = start; i<=n-k+1; i++) {
			arrayList.add(i);
			combine(n, i+1, k-1, list, arrayList);
			arrayList.remove(arrayList.size() - 1);
		}

	}
	
	private static void combine1(int n, int start, int k, List<List<Integer>> list, ArrayList arrayList) {
		if(k == 0) {
			list.add(new ArrayList<>(arrayList));
			return;
		}
		if(k > n-start+1)
			return;
		arrayList.add(start);
		combine1(n, start+1, k-1, list, arrayList);
		arrayList.remove(arrayList.size() - 1);
		combine1(n, start+1, k, list, arrayList);
//		for(int i = start; i<=n-k+1; i++) {
//			arrayList.add(i);
//			combine1(n, i+1, k-1, list, arrayList);
//			arrayList.remove(arrayList.size() - 1);
//		}

	}

}
