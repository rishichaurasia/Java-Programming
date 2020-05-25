package Backtracking;

import java.util.ArrayList;

// https://leetcode.com/problems/permutation-sequence/

public class Permutation_Sequence {

	public static void main(String[] args) {
		int n = 4;
		int k = 17;
		System.out.println(getPermutation(n, k));
	}
	
	public static String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList();
        for(int i = 0; i<=n; i++) {
        	list.add(i);
        }
        int[] factorial = new int[n];
        factorial[0] = 1;
        for(int i = 1; i<n; i++)
        	factorial[i] = factorial[i-1]*i;
        return getPermutation(n, k, list, factorial, "");   
    }
	
	// Recursive
//	private static String getPermutation(int n, int k, ArrayList<Integer> list, int[] factorial, String ans) {
//		if(n==0) {
//			return ans;
//		}
//		int group = k/factorial[n-1];
//		if(k%factorial[n-1] != 0)
//			group++;
//		int newk = k - factorial[n-1]*(group-1);
//		ans+=list.remove(group);
//		return getPermutation(n-1, newk, list, factorial, ans);
//		
//	}
	
	// Iterative
	private static String getPermutation(int n, int k, ArrayList<Integer> list, int[] factorial, String ans) {
		while(n!=0) {
			int group = (int)Math.ceil((double)k/factorial[n-1]);
			k = k - factorial[n-1]*(group-1);
			ans+=list.remove(group);
			n--;
		}
		return ans;
		
	}
	
}
