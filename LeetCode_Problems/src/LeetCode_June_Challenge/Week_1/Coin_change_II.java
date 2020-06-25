package LeetCode_June_Challenge.Week_1;

public class Coin_change_II {
	public int change(int amount, int[] coins) {
        int[][] res = new int[coins.length + 1][amount + 1];
        
        res[0][0] = 1;
      
        for (int i = 1; i <= coins.length; i++) {
            res[i][0] = 1;
            
            for (int j = 1; j <= amount; j++) {
                res[i][j] = res[i-1][j] + (j >= coins[i-1] ? res[i][j - coins[i-1]] : 0);
            }
        }
        
        return res[coins.length][amount];
    }
}
