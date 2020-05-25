package Backtracking;

// https://leetcode.com/problems/path-with-maximum-gold/

public class Path_with_Maximum_Gold {

	public static void main(String[] args) {
		int[][] grid = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
		System.out.println(getMaximumGold(grid));
	}

	static int max;

	public static int getMaximumGold(int[][] grid) {
		max = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++)
				getMaximumGold(grid, row, col, 0, new boolean[grid.length][grid[0].length]);
		}
		return max;
	}

	private static void getMaximumGold(int[][] grid, int row, int col, int amount, boolean[][] visited) {
		if (amount > max)
			max = amount;
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col]
				|| grid[row][col] == 0)
			return;
		visited[row][col] = true;
		
		getMaximumGold(grid, row + 1, col, amount + grid[row][col], visited);
		getMaximumGold(grid, row - 1, col, amount + grid[row][col], visited);
		getMaximumGold(grid, row, col + 1, amount + grid[row][col], visited);
		getMaximumGold(grid, row, col - 1, amount + grid[row][col], visited);

		visited[row][col] = false;
	}

}
