package Assignment;

import java.util.Scanner;

public class ChessBoard {

	/*
	 * Take as input N, a number. N represents the size of a chess board. We’ve a
	 * piece standing in top-left corner and it must reach the bottom-right corner.
	 * The piece moves as follows –
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
	 * Output Format Display the total number of valid paths and print all the valid
	 * paths in a space separated manner
	 * 
	 * Sample Input 3 
	 * 
	 * Sample Output 
	 * {0-0}K{2-1}R{2-2} {0-0}K{1-2}R{2-2}
	 * {0-0}R{0-1}K{2-2} {0-0}R{0-1}R{0-2}R{1-2}R{2-2} {0-0}R{0-1}R{0-2}R{2-2}
	 * {0-0}R{0-1}R{1-1}B{2-2} {0-0}R{0-1}R{2-1}R{2-2} {0-0}R{0-2}R{1-2}R{2-2}
	 * {0-0}R{0-2}R{2-2} {0-0}R{1-0}K{2-2} {0-0}R{1-0}R{1-1}B{2-2}
	 * {0-0}R{1-0}R{1-2}R{2-2} {0-0}R{1-0}R{2-0}R{2-1}R{2-2} {0-0}R{1-0}R{2-0}R{2-2}
	 * {0-0}R{2-0}R{2-1}R{2-2} {0-0}R{2-0}R{2-2} {0-0}B{1-1}B{2-2} {0-0}B{2-2} 
	 * 18
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		chessBoard(0, 0, n-1, "");
		System.out.println();
		System.out.println(count);
	}
	
	static int count = 0;

	public static void chessBoard(int sr, int sc, int n, String ans) {
		if(sr==n && sc==n) {
			System.out.print(ans+"{" + sr + "-" + sc +"} ");
			count++;
		}
		
		if(sr>n || sc>n)
			return;
		
		String str = "{" + sr + "-" + sc + "}";
		// Knight
		chessBoard(sr+2, sc+1, n, ans + str + "K");
		chessBoard(sr+1, sc+2, n, ans + str + "K");
		
		//Rook
		if(sr == 0 || sc == 0 || sr == n || sc == n) {
			for(int i = 1; i<=n-sc; i++) {
				chessBoard(sr, sc+i, n, ans + str + "R");
			}
			for(int i = 1; i<=n-sr; i++) {
				chessBoard(sr+i, sc, n, ans+str +"R");
			}
		}
		
		//Bishop
		if(sr == sc || sr+sc==n) {
			for(int i =1; sr+i<=n && sc+i<=n; i++) {
				chessBoard(sr+i, sc+i, n, ans + str + "B");
			}
		}
	}
	
}
