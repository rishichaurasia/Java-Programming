package Assignment;

import java.util.Scanner;

public class NQueens {
	
/*
Take as input N, the size of a chess board. We are asked to place N number of queens in it, so that no queen can kill other.

a. Write a recursive function which returns the count of different distinct ways the queens can be placed across the board. Print the value returned.

b. Write a recursive function which prints all valid configurations (void is the return type for function).

Input Format
Enter the number N(Size of the chessboard)

Constraints
None

Output Format
Display the number of possible ways of arranging N queens and print all the possible arrangements in a space separated manner

Sample Input
4
Sample Output
{1-2} {2-4} {3-1} {4-3}  {1-3} {2-1} {3-4} {4-2}
2
 */
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		int n = scn.nextInt();
		placeQueens(new boolean[n][n], 0, "");
		System.out.println();
		System.out.println(count);
	}
	
	static int count = 0;
	
	public static void placeQueens(boolean[][] board, int row, String ans) {
	
		if(row == board.length) {
			System.out.print(ans + " ");
			count++;
			return;
		}
		
		for(int col = 0; col<board[row].length; col++) {
			if(isItSafe(board, row, col)) {
				board[row][col] = true;
				placeQueens(board, row+1, ans + "{" + (row+1) + "-" + (col+1) + "} ");
				board[row][col] = false;
			}
		}
		
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {
		for(int i = row-1; i>=0; i--) {
			if(board[i][col])
				return false;
		}
		
		for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j--) {
			if(board[i][j])
				return false;
		}
		
		for(int i = row-1, j = col+1; i>=0 && j<board[i].length; i--, j++) {
			if(board[i][j])
				return false;
		}
		
		return true;
	}
	
}
