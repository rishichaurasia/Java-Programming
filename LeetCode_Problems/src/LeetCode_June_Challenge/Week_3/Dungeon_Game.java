package LeetCode_June_Challenge.Week_3;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Dungeon_Game {

	public static void main(String[] args) {
		int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(calculateMinimumHP(dungeon));

	}
	
	public static int calculateMinimumHP(int[][] dungeon) {
        int[][] strg = new int[dungeon.length][dungeon[0].length];
        return calculateMinimumHP(dungeon, 0, 0, strg);
    }
    
    public static int calculateMinimumHP(int[][] dungeon, int row, int col, int[][] strg){
        if(row == dungeon.length || col == dungeon[0].length)
            return Integer.MAX_VALUE;
        if(strg[row][col] != 0)
            return strg[row][col];
        if(row == dungeon.length-1 && col == dungeon[0].length-1)
            return Math.max(1 - dungeon[row][col], 1);
        int path1 = calculateMinimumHP(dungeon, row+1, col, strg);
        int path2 = calculateMinimumHP(dungeon, row, col+1, strg);
        int ans = Math.max(Math.min(path1, path2) - dungeon[row][col], 1);
        strg[row][col] = ans;
        return ans;
    }
    
    
    public static int calculateMinimumHP1(int[][] dungeon) {
    	int nr = dungeon.length;
    	int nc = dungeon[0].length;
        int[][] strg = new int[nr + 1][nc + 1];
        Arrays.fill(strg[nr], Integer.MAX_VALUE);
        for(int row = nr-1; row>=0; row--) {
        	strg[row][nc] = Integer.MAX_VALUE;
        	int col = nc-1;
        	if(row == nr-1) {
        		strg[row][col] = Math.max(1-dungeon[row][col], 1);
        		col--;
        	}
        	for(; col>= 0; col--) {
        		int minPath = Math.min(strg[row+1][col], strg[row][col+1]);
        		strg[row][col] = Math.max(minPath-dungeon[row][col], 1);
        	}
        }
        return strg[0][0];
    }

}
