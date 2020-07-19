package Dynamic_Programming;

import java.util.Scanner;

public class Buying_Fruits {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		
		while(t-- > 0) {
			int N = scn.nextInt();
			int[][] prices = new int[N][3];
			for(int i = 0; i<N; ++i) {
				prices[i][0] = scn.nextInt();
				prices[i][1] = scn.nextInt();
				prices[i][2] = scn.nextInt();
			}
			
			System.out.println(minCostTD(prices, 0, 3, new int[N][4]));
		}
	}
	
	public static int minCostRS(int[][] prices, int idx, int lastFruit) {
		
		if(idx == prices.length)
			return 0;
		
		int ans = 1000000;
		
		for(int i = 0; i<3; ++i) {
			if(i != lastFruit) {
				int p = minCostRS(prices, idx+1, i) + prices[idx][i];
				ans = Math.min(ans, p);
			}
		}
		
		return ans;
		
	}
	
	public static int minCostTD(int[][] prices, int idx, int lastFruit, int[][] strg) {
		
		if(idx == prices.length)
			return 0;
		
		if(strg[idx][lastFruit] != 0)
			return strg[idx][lastFruit];
		
		int p1, p2, p3;
		p1 = p2 = p3 = Integer.MAX_VALUE;
		
		if(p1 != lastFruit)
			p1 = minCostTD(prices, idx+1, 0, strg) + prices[idx][0];
		if(p2 != lastFruit)
			p2 = minCostTD(prices, idx+1, 1, strg) + prices[idx][1];
		if(p3 != lastFruit)
			p3 = minCostTD(prices, idx+1, 2, strg) + prices[idx][2];
		
		int ans = Math.min(p1, Math.min(p2, p3));
		
//		int ans = 1000000;
//		
//		for(int i = 0; i<3; ++i) {
//			if(i != lastFruit) {
//				int p = minCostTD(prices, idx+1, i, strg) + prices[idx][i];
//				ans = Math.min(ans, p);
//			}
//		}
		
		strg[idx][lastFruit] = ans;
		
		return ans;
		
	}


}
