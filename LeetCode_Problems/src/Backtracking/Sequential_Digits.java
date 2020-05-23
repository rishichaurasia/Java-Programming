package Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/sequential-digits/

public class Sequential_Digits {

	public static void main(String[] args) {
		int low = 1000;
		int high = 13000;
		System.out.println(sequentialDigits(low, high));
	}
	
//	public static List<Integer> sequentialDigits(int low, int high) {
//        List<Integer> list = new ArrayList<Integer>();
//		for(int i = 1; i<=9; i++)
//        	sequentialDigits(i, low, high, list);
//		Collections.sort(list);
//		return list;
//    }
	
	public static void sequentialDigits(int curr, int low, int high, List list) {
        if(curr > high)
        	return;
        if(curr > low)
        	list.add(curr);
		int ld = curr % 10;
		if(ld == 9)
			return;
        sequentialDigits(curr*10 + (ld+1), low, high, list);
    }
	
	// Solved using queues
	public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i<=9; i++)
			queue.add(i);
		while(!queue.isEmpty()) {
			int n = queue.remove();
			if(n>high)
				continue;
			if(n>=low)
				list.add(n);
			int ld = n%10;
			if(ld == 9)
				continue;
			queue.add(n*10 + (ld+1));
		}
		return list;
    }
	

}
