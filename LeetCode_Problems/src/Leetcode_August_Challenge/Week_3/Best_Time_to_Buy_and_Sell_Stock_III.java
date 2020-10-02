package Leetcode_August_Challenge.Week_3;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// Recursion + Memoisation
	public static int maxProfit(int[] prices) {
        strg = new int[prices.length][2][2];
        for(int[][] arr1: strg){
            for(int[] arr2: arr1)
                Arrays.fill(arr2,-1);
        }
        return maxProfit(prices, 0, 0, 0);
    }
    
    static int[][][] strg;
    
    public static int maxProfit(int[] prices, int idx, int txnType, int txnCount){

        if(txnCount == 2 || idx == prices.length){
            return 0;
        }
        
        if(strg[idx][txnType][txnCount] != -1)
            return strg[idx][txnType][txnCount];
        
        int ans1;
        if(txnType == 0){
            ans1 = maxProfit(prices, idx+1, 1, txnCount) - prices[idx];
        }else{
            ans1 = maxProfit(prices, idx+1, 0, txnCount+1) + prices[idx];
        }
        int ans2 = maxProfit(prices, idx+1, txnType, txnCount);
        int ans = Math.max(ans1, ans2);
        strg[idx][txnType][txnCount] = ans;
        return ans;
    }
    
    // O(n) Time | O(n) Space
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        if(n <= 1)
            return 0;
        int[] profit1 = new int[n];
        int[] profit2 = new int[n];
        int minLeft = prices[0];
        int maxRight = prices[n-1];
        int i = 1;
        while(i<n){
            if(prices[i] < minLeft)
                minLeft = prices[i];
            if(prices[n-i-1] > maxRight)
                maxRight = prices[n-i-1];
            profit1[i] = Math.max(profit1[i-1], prices[i] - minLeft);
            profit2[n-i-1] = Math.max(profit2[n-i], maxRight - prices[n-i-1]);
            i++;
        }
        int maxProfit = 0;
        for(int j = 0; j<n; j++){
            maxProfit = Math.max(maxProfit, profit1[j]+profit2[j]);
        }
        return maxProfit;
    }

}
