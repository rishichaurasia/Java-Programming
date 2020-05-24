package Backtracking;

import java.util.ArrayList;

// https://leetcode.com/problems/split-array-into-fibonacci-sequence/

import java.util.List;

public class Split_Array_into_Fibonacci_Sequence {

	public static void main(String[] args) {
		String S = "5511816597";
//		String S = "1011";
		System.out.println(splitIntoFibonacci(S));
	}

	public static List<Integer> splitIntoFibonacci(String S) {
		List<Integer> list = new ArrayList<>();
		splitIntoFibonacci(S, 0, list, new ArrayList<Integer>());
		return list;
	}

	private static void splitIntoFibonacci(String s, int idx, List main, List<Integer> temp) {
		if (idx == s.length() && temp.size() >= 3) {
			main.addAll(temp);
			return;
		}
		for (int i = idx; i < s.length() && main.isEmpty() && (i-idx+1)<11; i++) {
			String part = s.substring(idx, i + 1);
			if (hasLeadingZeroes(part) || !inRange(part))
				continue;
			int n = Integer.parseInt(part);
			if (checkFibonacciSeq(temp, n)) {
				temp.add(n);
				splitIntoFibonacci(s, i + 1, main, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}

	private static boolean inRange(String part) {
		return Long.parseLong(part) <= ((1 << 31) - 1);
	}

	private static boolean hasLeadingZeroes(String s) {
		return s.length() > 1 && s.charAt(0) == '0';
	}

	private static boolean checkFibonacciSeq(List<Integer> list, int n) {
		if (list.size() < 2)
			return true;
		return (list.get(list.size() - 1) + list.get(list.size() - 2)) == n;
	}

}
