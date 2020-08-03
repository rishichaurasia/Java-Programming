package LeetCode_July_Challenge.Week_5;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit1(prices));
	}
	 // Recursion + Memoisation
    public static int maxProfit(int[] prices) {
        int[][] strg = new int[prices.length][2];
        for(int[] arr: strg)
            Arrays.fill(arr,-1);
        return maxProfit(prices, 0, 0, strg);
    }
    
    public static int maxProfit(int[] prices, int idx, int currTxn, int[][] strg){
        if(idx >= prices.length)
            return 0;
        
        if(strg[idx][currTxn] != -1)
            return strg[idx][currTxn];
        
        int ans;
        if(currTxn == 0){
            int buy = maxProfit(prices, idx+1, 1, strg) - prices[idx];
            int skip = maxProfit(prices, idx+1, currTxn, strg);
            ans = Math.max(buy, skip);
        }else{
            int sell = maxProfit(prices, idx+2, 0, strg) + prices[idx];
            int skip = maxProfit(prices, idx+1, currTxn, strg);
            ans = Math.max(sell, skip);
        }
        
        strg[idx][currTxn] = ans;
        
        return ans;
    }
    
    // Bottoms up DP
    public static int maxProfit1(int[] prices) {
        int[][] strg = new int[prices.length+2][2];
        
        for(int i = prices.length-1; i>=0; i--) {
        	for(int j = 0; j<2; j++) {
        		int ans;
                if(j == 0){
                    int buy = strg[i+1][1] - prices[i];
                    int skip = strg[i+1][j];
                    ans = Math.max(buy, skip);
                }else{
                    int sell = strg[i+2][0] + prices[i];
                    int skip = strg[i+1][j];
                    ans = Math.max(sell, skip);
                }
                
                strg[i][j] = ans;

        	}
        	
        }
        
        return strg[0][0];
    }

}
