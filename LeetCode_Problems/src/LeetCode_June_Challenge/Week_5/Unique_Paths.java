package LeetCode_June_Challenge.Week_5;

public class Unique_Paths {
	public int uniquePaths(int m, int n) {
        int[][] strg = new int[n+1][m+1];
        for(int row = n-1; row>=0; row--){
            for(int col = m-1; col>=0; col--){
                if(row == n-1 && col == m-1)
                    strg[row][col] = 1;
                else{
                    strg[row][col] = strg[row+1][col] + strg[row][col+1];
                }
            }
        }
        return strg[0][0];
    }
}
