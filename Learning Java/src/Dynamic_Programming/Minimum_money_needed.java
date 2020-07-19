package Dynamic_Programming;

import java.util.Scanner;

public class Minimum_money_needed {

	public static void main(String[] args) {
//		int[] prices = {0,1,2,3,4,5};
//		int weight = 5;

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int W = scn.nextInt();
		int[] prices = new int[W];
		for (int i = 0; i < W; ++i)
			prices[i] = scn.nextInt();

//		int res = minPrice(prices, 0, W, new int[W][W+1]);
		int res = minPriceBU(prices);
		if (res == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(res);
	}

	public static int minPrice(int[] prices, int pidx, int weight, int[][] strg) {
		if (weight == 0)
			return 0;

		if (strg[pidx][weight] != 0)
			return strg[pidx][weight];

		int ans = Integer.MAX_VALUE;

		for (int i = pidx; i < prices.length && i < weight; ++i) {
			if (prices[i] != -1) {

				int p = minPrice(prices, i, weight - i - 1, strg);

				if (p != Integer.MAX_VALUE)
					ans = Math.min(ans, p + prices[i]);

			}
		}

		strg[pidx][weight] = ans;

		return ans;

	}

	public static int MinMoney(int[] prices, int vidx, int cap, int[][] strg) {

		if (cap == 0) {
			return 0;
		}

		if (vidx == prices.length) {
			return 10000000;
		}

		if (strg[vidx][cap] != -1) {
			return strg[vidx][cap];
		}

		int inc = 10000000;
		if (cap >= vidx + 1 && prices[vidx] != -1) {
			inc = MinMoney(prices, vidx, cap - vidx - 1, strg) + prices[vidx];
		}
		int exc = MinMoney(prices, vidx + 1, cap, strg);

		return strg[vidx][cap] = Math.min(inc, exc);
	}

	public static int minPriceBU(int[] prices) {
		int w = prices.length;
		int[] dp = new int[w + 1];
		dp[0] = 0;
		for (int i = 1; i <= w; i++)
			dp[i] = Integer.MAX_VALUE;
		for (int i = 1; i <= w; i++) {
			for (int j = 0; j < w; j++) {
				if (prices[j] != -1 && (j + 1) <= i && dp[i - (j + 1)] != Integer.MAX_VALUE && dp[i - (j + 1)] + prices[j] < dp[i]) {
					dp[i] = dp[i - (j + 1)] + prices[j];
				}
			}
		}

		if (dp[w] == Integer.MAX_VALUE)
			return -1;

		return dp[w];

//	   int n = prices.length;
//	   int[][] strg = new int[n+1][n+1];
//	   
//	   Arrays.fill(strg[n], 1000000);
//	   
//	   strg[n][0] = 0;
//	   
//	   for(int i = n-1; i>=0; --i) {
//		   
//		   for(int w = 1; w<=n; ++w) {
//			   
//			   if(i+1<=w) {
//				   int inc = strg[i][w-i-1] + prices[i]; // include
//				   
//				   int exc = strg[i+1][w]; // exclude
//				   
//				   strg[i][w] = Math.min(inc, exc);
//			   }else
//				   strg[i][w] = 1000000;
//		   }
//	   }
//
//		return strg[0][n];

	}

}
