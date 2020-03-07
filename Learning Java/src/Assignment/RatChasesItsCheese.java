package Assignment;

import java.util.Scanner;

public class RatChasesItsCheese {
	
/*
You are given an N*M grid. Each cell (i,j) in the grid is either blocked, or empty. The rat can move from a position towards left, right, up or down on the grid.
Initially rat is on the position (1,1). It wants to reach position (N,M) where it's cheese is waiting for. There exits a unique path in the grid . Find that path and help the rat reach its cheese.

Input Format
First line contains 2 integers N and M denoting the rows and columns in the grid.
Next N line contains M characters each. An 'X' in position (i,j) denotes that the cell is blocked and ans 'O' denotes that the cell is empty.

Constraints
1 <= N , M <= 10

Output Format
Print N lines, containing M integers each. A 1 at a position (i,j) denotes that the (i,j)th cell is covered in the path and a 0 denotes that the cell is not covered in the path.
If a path does not exits then print "NO PATH FOUND"

Sample Input
5 4
OXOO
OOOX
XOXO
XOOX
XXOO
Sample Output
1 0 0 0 
1 1 0 0 
0 1 0 0 
0 1 1 0 
0 0 1 1 
 */

	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = scn.nextInt();
		int m = scn.nextInt();
		char[][] maze = new char[n][m];
		int[][] path = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = scn.next();
			for(int j = 0; j<m; j++)
				maze[i][j] = str.charAt(j);
		}
		if(findPath(maze, 0, 0, path)) {
			print(path);
		}
		else {
			System.out.println("NO PATH FOUND");
		}
	}
	
	public static boolean findPath(char[][] maze, int startRow, int startCol, int[][] path) {
		if(startRow<0 || startRow==maze.length || startCol<0 || startCol==maze[0].length )
			return false;
		if(path[startRow][startCol] == 1 || maze[startRow][startCol] == 'X')
			return false;
		path[startRow][startCol] = 1;
		if(startRow == maze.length-1 && startCol == maze[0].length-1)
			return true;
		path[startRow][startCol] = 1;
		boolean res = findPath(maze, startRow, startCol+1, path) 
				|| findPath(maze, startRow+1, startCol, path)
				|| findPath(maze, startRow, startCol-1, path)
				|| findPath(maze, startRow-1, startCol, path);
		if(res == true)
			return res;
		path[startRow][startCol] = 0;
		return res;
	}
	
	public static void print(int[][] path) {
		for (int i = 0; i < path.length; i++) {
			for (int j = 0; j < path[0].length; j++) {
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
	}
	
/*
public class rat_cheese {

    static boolean flag = false;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();

        char[][] maze = new char[n][m];

        for (int i = 0; i < n; i++) {

            String ans = scn.next();
            for (int j = 0; j < m; j++) {
                maze[i][j] = ans.charAt(j);
            }

        }

        chase(new int[n][m], maze, 0, 0);
        if (flag == false) {
            System.out.println("NO PATH FOUND");
        }

    }

    public static void chase(int[][] visited, char[][] maze, int row, int col) {

        if (row < 0 || row >= visited.length || col < 0 || col >= visited[0].length || visited[row][col] == 1
                || maze[row][col] == 'X') {
            return;
        }

        if (row == maze.length - 1 && col == maze[0].length - 1) {

            flag = true;
            visited[visited.length - 1][visited[0].length - 1] = 1;
            for (int i = 0; i < visited.length; i++) {
                for (int j = 0; j < visited[0].length; j++)
                    System.out.print(visited[i][j] + " ");
                System.out.println();
            }
            return;

        }

        visited[row][col] = 1;
        chase(visited, maze, row, col - 1);
        chase(visited, maze, row, col + 1);
        chase(visited, maze, row + 1, col);
        chase(visited, maze, row - 1, col);
        visited[row][col] = 0;
    }
 */

}
