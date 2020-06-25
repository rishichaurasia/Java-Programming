package LeetCode_June_Challenge.Week_3;

import java.util.ArrayList;

public class Permutation_Sequence {

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
