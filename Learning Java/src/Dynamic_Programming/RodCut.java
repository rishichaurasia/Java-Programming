package Dynamic_Programming;

import java.util.Scanner;

public class RodCut {
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int t = scn.nextInt();
		while(t-- > 0) {
			int n = scn.nextInt();
			int[] prices = new int[n+1];
			for(int i = 1; i<=n; ++i)
				prices[i] = scn.nextInt();
			System.out.println(rodcutRS(prices, n));
			
			System.out.println(rodcutTD(prices, n, new int[n+1]));
			System.out.println(rodcutBU(prices));
		}

	}
	
	public static int rodcutRS(int[] prices, int n) {
		
		int maxP = prices[n];
		
		int left = 1;
		int right = n-1;
		
		while(left <= right) {
			int price1 = rodcutRS(prices, left);
			int price2 = rodcutRS(prices, right);
			
			int totalP = price1 + price2;
			
			if(totalP > maxP)
				maxP = totalP;
			
			++left; --right;
		}
		
		return maxP;
	}
	
	public static int rodcutTD(int[] prices, int n, int[] strg) {
		
		if(strg[n] != 0)
			return strg[n];
	
		int maxP = prices[n];
		
		int left = 1;
		int right = n-1;
		
		while(left <= right) {
			int price1 = rodcutTD(prices, left, strg);
			int price2 = rodcutTD(prices, right, strg);
			
			int totalP = price1 + price2;
			
			if(totalP > maxP)
				maxP = totalP;
			
			++left; --right;
		}
		
		strg[n] = maxP;
		
		return maxP;
	}
	
	public static int rodcutBU(int[] prices) {
		
		int[] strg = new int[prices.length];
		strg[1] = prices[1];
		
		for(int n = 2; n<prices.length; ++n) {
			
			int maxP = prices[n];
			
			int left = 1;
			int right = n-1;
			
			while(left <= right) {
				int price1 = strg[left];
				int price2 = strg[right];
				
				int totalP = price1 + price2;
				
				if(totalP > maxP)
					maxP = totalP;
				
				++left; --right;
			}
			
			strg[n] = maxP;
			
		}
		
		return strg[prices.length-1];
		
	}

}
