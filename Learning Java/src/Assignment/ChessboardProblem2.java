package Assignment;

import java.util.Scanner;

public class ChessboardProblem2 {

	/*
	 * Take as input N, a number. N represents the size of a chess board. The cells
	 * in board are numbered. The top-left cell is numbered 1 and numbering
	 * increases from left to right and top to bottom. E.g. The following is the
	 * chessboard for a value of n=4.
	 * 
	 * 1 2 3 4
	 * 
	 * 5 6 7 8
	 * 
	 * 9 10 11 12
	 * 
	 * 13 14 15 16
	 * 
	 * Prime numbers act as mines and ports alternately i.e. first prime number is a
	 * mine while second is a port and so on. Piece can go over a mine but cannot
	 * stop on it. Piece can directly move from a port to the destination (but may
	 * not chose to).
	 * 
	 * We’ve a piece standing in top-left corner and it must reach the bottom-right
	 * corner. The piece moves as follows –
	 * 
	 * a. In any cell, the piece moves like a knight. But out of the possible 8
	 * moves for a knight, only the positive ones are valid i.e. both row and column
	 * must increase in a move.
	 * 
	 * b. On the walls (4 possible walls), the piece can move like a rook as well
	 * (in addition of knight moves). But, only the positive moves are allowed i.e.
	 * as a rook, piece can move any number of steps horizontally or vertically but
	 * in a manner, such that row or column must increase.
	 * 
	 * c. On the diagonals (2 possible diagonals), the piece can move like a bishop
	 * as well (in addition to the knight and possibly rook moves). But, only the
	 * positive moves are allowed i.e. as a bishop, piece can move in a way such
	 * that row and column must increase.
	 * 
	 * You are supposed to write the following functions
	 * 
	 * a. Write a recursive function which returns the count of different distinct
	 * ways this board can be crossed. Print the value returned.
	 * 
	 * b. Write a recursive function which prints all valid paths (void is the
	 * return type for function).
	 * 
	 * Input Format Enter the size of the chessboard N
	 * 
	 * Constraints None
	 * 
	 * Output Format Display the total number of ways to cross the board and display
	 * all the possible paths in a space separated manner
	 * 
	 * Sample Input 3 Sample Output {0-0}K{2-1}R{2-2} {0-0}K{1-2}R{2-2}
	 * {0-0}R{0-2}P{2-2} {0-0}R{0-2}R{1-2}R{2-2} {0-0}R{0-2}R{2-2} {0-0}R{1-0}K{2-2}
	 * {0-0}R{1-0}R{1-2}R{2-2} {0-0}R{1-0}R{2-0}P{2-2} {0-0}R{1-0}R{2-0}R{2-1}R{2-2}
	 * {0-0}R{1-0}R{2-0}R{2-2} {0-0}R{2-0}P{2-2} {0-0}R{2-0}R{2-1}R{2-2}
	 * {0-0}R{2-0}R{2-2} {0-0}B{2-2} 14
	 */

//	{0-0}K{2-1}R{2-2} {0-0}K{1-2}R{2-2} {0-0}R{0-2}P{2-2} {0-0}R{0-2}R{1-2}R{2-2} {0-0}R{0-2}R{2-2} {0-0}R{1-0}K{2-2} {0-0}R{1-0}R{1-2}R{2-2} {0-0}R{1-0}R{2-0}P{2-2} {0-0}R{1-0}R{2-0}R{2-1}R{2-2} {0-0}R{1-0}R{2-0}R{2-2} {0-0}R{2-0}P{2-2} {0-0}R{2-0}R{2-1}R{2-2} {0-0}R{2-0}R{2-2} {0-0}B{2-2}
//	14
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[][] board = new int[n][n];
		int k = 0;
		boolean mine = true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				++k;
				if (isPrime(k)) {
					if (mine)
						board[i][j] = -1;
					else
						board[i][j] = 0;
					mine = !mine;
				} else {
					board[i][j] = k;
				}
			}
		}
		chessBoard(board, 0, 0, n - 1, "");
		System.out.println();
		System.out.println(count);
	}

	static int count = 0;

	public static void chessBoard(int[][] board, int sr, int sc, int n, String ans) {
		if (sr == n && sc == n) {
			System.out.print(ans + "{" + sr + "-" + sc + "} ");
			count++;
			return;
		}

		if (sr > n || sc > n)
			return;

		if (board[sr][sc] == -1) {
			return;
		}

		String str = "{" + sr + "-" + sc + "}";

		// Port
		if (board[sr][sc] == 0) {
			chessBoard(board, n, n, n, ans + str + "P");
		}

		// Knight
		chessBoard(board, sr + 2, sc + 1, n, ans + str + "K");
		chessBoard(board, sr + 1, sc + 2, n, ans + str + "K");

		// Rook
		if (sr == 0 || sc == 0 || sr == n || sc == n) {
			for (int i = 1; i <= n - sc; i++) {
				chessBoard(board, sr, sc + i, n, ans + str + "R");
			}
			for (int i = 1; i <= n - sr; i++) {
				chessBoard(board, sr + i, sc, n, ans + str + "R");
			}
		}

		// Bishop
		if (sr == sc || sr + sc == n) {
			for (int i = 1; sr + i <= n && sc + i <= n; i++) {
				chessBoard(board, sr + i, sc + i, n, ans + str + "B");
			}
		}

	}

	public static boolean isPrime(int n) {

		if (n == 2) {
			return true;
		} else if (n == 1 || n % 2 == 0) {
			return false;
		} else {
			int div = 3;
			while (div <= Math.sqrt(n)) {
				if (n % div == 0) {
					return false;
				}
				div += 2;
			}
			return true;
		}
	}

}
