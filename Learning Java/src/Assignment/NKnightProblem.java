package Assignment;

import java.util.Scanner;

public class NKnightProblem {
	
/*
Take as input N, the size of a chess board. We are asked to place N number of Knights in it, so that no knight can kill other.

a. Write a recursive function which returns the count of different distinct ways the knights can be placed across the board. Print the value returned.

b.Write a recursive function which prints all valid configurations (void is the return type for function).

Input Format
Enter the size of the chessboard N

Constraints
None

Output Format
Display the number of ways a knight can be placed and print all the possible arrangements in a space separated manner

Sample Input
2
Sample Output
{0-0} {0-1}  {0-0} {1-0}  {0-0} {1-1}  {0-1} {1-0}  {0-1} {1-1}  {1-0} {1-1} 
6
 */

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n = scn.nextInt();
		placeKnights(new boolean[n][n], 0, 0, n, "");
		System.out.println();
		System.out.println(count);
	}
	
	static int count = 0;
	
	public static void placeKnights(boolean[][] board, int row, int col, int knightsleft, String ans) {
	
		if(knightsleft == 0) {
			System.out.print(ans + " ");
			count++;
			return;
		}
		
		if(col == board[row].length) {
			col = 0;
			row++;
		}
		
		if(row == board.length)
			return;
		
		if(isItSafe(board, row, col)) {
			board[row][col] = true;
			placeKnights(board, row, col+1, knightsleft-1, ans + "{" + row + "-" + col + "} ");
			board[row][col] = false;
		}
		placeKnights(board, row, col+1, knightsleft, ans);
		
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {
		
		int[] r = {-1, -1, -2, -2};
		int[] c = {-2, 2, -1, 1};
		for(int i = 0; i<r.length; i++) {
			int nr = row+r[i];
			int nc = col+c[i];
			if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length) {
				if(board[nr][nc])
					return false;
			}
		}
		
		return true;
	}

}
