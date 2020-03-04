package Assignment;

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
	 * Prime numbers act as mines and ports alternately i.e. first prime
	 * number is a mine while second is a port and so on. Piece can go over a mine
	 * but cannot stop on it. Piece can directly move from a port to the destination
	 * (but may not chose to).
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
	 * Sample Input 3 
	 * Sample Output {0-0}K{2-1}R{2-2} {0-0}K{1-2}R{2-2}
	 * {0-0}R{0-2}P{2-2} {0-0}R{0-2}R{1-2}R{2-2} {0-0}R{0-2}R{2-2} {0-0}R{1-0}K{2-2}
	 * {0-0}R{1-0}R{1-2}R{2-2} {0-0}R{1-0}R{2-0}P{2-2} {0-0}R{1-0}R{2-0}R{2-1}R{2-2}
	 * {0-0}R{1-0}R{2-0}R{2-2} {0-0}R{2-0}P{2-2} {0-0}R{2-0}R{2-1}R{2-2}
	 * {0-0}R{2-0}R{2-2} {0-0}B{2-2} 14
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
