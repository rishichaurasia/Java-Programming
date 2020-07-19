package Dynamic_Programming;

/*
 * To find the max profit that we can get by selling items not having total weight greater than
 * the given knapsack capacity
 */

public class Knapsack {

	public static void main(String[] args) {
		int[] wt = {1,3,4,5};
		int[] prices = {1,4,5,7};
		int cap = 7;
		
//		int[] wt = new int[1000];
//		int[] prices = new int[1000];
//		for(int i = 0; i<wt.length; i++) {
//			wt[i] = i+1;
//			prices[i] = i+1;
//		}
//		int cap = 70;
		
//		System.out.println(knapsack(wt, prices, 0, cap));
//		System.out.println(knapsackTD(wt, prices, 0, cap, new int[wt.length][cap+1]));
		System.out.println(knapsackBU(wt, prices, cap));

	}
	
//	O(2^n) Time	|	Recursion space
	public static int knapsack(int[] wt, int[] prices, int idx, int cap) {
		if(idx == wt.length || cap == 0)
			return 0;
		
		// Exclude
		int e = knapsack(wt, prices, idx+1, cap);
		// Include
		int i = 0;
		if(cap >= wt[idx])
			i = knapsack(wt, prices, idx+1, cap-wt[idx]) + prices[idx];
		
		int ans = Math.max(e, i);
		return ans;
	}
	
	public static int knapsackTD(int[] wt, int[] prices, int idx, int cap, int[][] strg) {
		if(idx == wt.length || cap == 0)
			return 0;
		
		if(strg[idx][cap] != 0)
			return strg[idx][cap];
		
		// Exclude
		int e = knapsackTD(wt, prices, idx+1, cap, strg);
		// Include
		int i = 0;
		if(cap >= wt[idx])
			i = knapsackTD(wt, prices, idx+1, cap-wt[idx], strg) + prices[idx];
		
		int ans = Math.max(e, i);
		strg[idx][cap] = ans;
		return ans;
	}
	
	// O(n*cap) Time	| O(n*cap) Space
	public static int knapsackBU(int[] wt, int[] prices, int cap) {
		int n = wt.length;
		int[][] strg = new int[n+1][cap+1];
		for(int row = n-1; row >= 0; row--) {
			for(int col = 1; col<=cap; col++) {
				int e = strg[row+1][col];
				int i = 0;
				if(col >= wt[row])
					i = strg[row+1][col-wt[row]] + prices[row];
				strg[row][col] = Math.max(e, i);
			}
		}
		return strg[0][cap];
	}

}
