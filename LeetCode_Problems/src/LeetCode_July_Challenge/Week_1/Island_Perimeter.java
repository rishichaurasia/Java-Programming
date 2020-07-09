package LeetCode_July_Challenge.Week_1;

public class Island_Perimeter {
	// dfs
	public int islandPerimeter(int[][] grid) {
        for(int i = 0; i<grid.length; ++i){
            for(int j = 0; j<grid[0].length; ++j){
                if(grid[i][j] == 1){
                    return islandPerimeter(grid, i, j);
                }
            }
        }
        return 0;
    }
    
    public int islandPerimeter(int[][] grid, int row, int col){
        if(row<0 || col<0 || row==grid.length || col==grid[0].length || grid[row][col]==0)
            return 1;
        if(grid[row][col]==-1)
            return 0;
        grid[row][col] = -1;
        return islandPerimeter(grid, row-1, col)
            + islandPerimeter(grid, row+1, col)
            + islandPerimeter(grid, row, col-1)
            + islandPerimeter(grid, row, col+1);
    }
    
    // Iterative
    public int islandPerimeter1(int[][] grid) {
        int res = 0;
        for(int row = 0; row<grid.length; ++row){
            for(int col = 0; col<grid[0].length; ++col){
                if(grid[row][col] == 1){
                    res += 4;
                    if(row>0 && grid[row-1][col] == 1)
                        res-=2;
                    if(col>0 && grid[row][col-1] == 1)
                        res-=2;
                }
            }
        }
        return res;
    }
}
