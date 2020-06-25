package Dynamic_Programming;

import java.util.stream.IntStream;

public class Wine_Problem {

	public static void main(String[] args) {
//		int[] prices = new int[1000];
//		for(int i=0; i<1000; i++)
//			prices[i] = i;
		int[] prices = { 2, 3, 5, 1, 4 };
		int n = prices.length;
		System.out.println(getMaxProfit1(prices, 0, prices.length - 1, new int[n][n]));
		System.out.println(getMaxProfitBU(prices));
		System.out.println(getMaxProfitBUSE(prices));
	}

//	O(2^n) time | O(1) space
	public static int getMaxProfit(int[] prices, int left, int right, int year) {
		if (left == right)
			return prices[left] * year;
		int profitFromLeft = prices[left] * year + getMaxProfit(prices, left + 1, right, year + 1);
		int profitFromright = prices[right] * year + getMaxProfit(prices, left, right - 1, year + 1);
		return Math.max(profitFromLeft, profitFromright);
	}

	// Top-Down
	// O(n^2) time | O(n^2) space
	public static int getMaxProfit1(int[] prices, int left, int right, int[][] strg) {
		int year = prices.length - (right - left + 1) + 1;
		if (left == right)
			return prices[left] * year;
		if (strg[left][right] != 0)
			return strg[left][right];
		int profitFromLeft = prices[left] * year + getMaxProfit1(prices, left + 1, right, strg);
		int profitFromright = prices[right] * year + getMaxProfit1(prices, left, right - 1, strg);
		int maxProfit = Math.max(profitFromLeft, profitFromright);
		strg[left][right] = maxProfit;
		return maxProfit;
	}
	
	// Buttom's-up
	// O((n^2)/2) = O(n^2) time | O(n^2) space
	public static int getMaxProfitBU(int[] prices) {
		int n = prices.length;
		int[][] strg = new int[n][n];
		for(int slide = 0; slide<n; slide++) {
			for(int row = 0; row+slide<n; row++) {
				int col = row+slide;
				int yr = n-slide;
				if(slide == 0)
					strg[row][col] = yr*prices[row];
				else {
					int profitFromLeft = prices[row]*yr + strg[row+1][col];
					int prifitFromRight = prices[col] * yr + strg[row][col-1];
					strg[row][col] = Math.max(profitFromLeft, prifitFromRight);
				}
			}
		}
//		for(int i = 0; i<n; i++) {
//			for(int j = 0; j<n; j++)
//				System.out.print(strg[i][j] + "\t ");
//			System.out.println();
//		}
		return strg[0][n-1];
	}
	
	// Buttom's-up
	// O((n^2)/2) = O(n^2) time | O(n^2) space
	public static int getMaxProfitBUSE(int[] prices) {
		int n = prices.length;
		int[] strg = new int[n];
		for(int i = 0; i<n; i++) {
			int yr = n-i;
			for(int j = 0; j<n-i; j++) {
				if(i == 0)
					strg[j] = prices[j]*yr;
				else {
					int profitFromLeft = prices[j+i]*yr + strg[j];
					int prifitFromRight = prices[j] * yr + strg[j+1];
					strg[j] = Math.max(profitFromLeft, prifitFromRight);
				}
			}
		}
		return strg[0];
	}


}
