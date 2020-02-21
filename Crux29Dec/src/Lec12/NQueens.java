package Lec12;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] board = new boolean[4][4];
		System.out.println(countNQueens(board, 0));
		printNQueens(board, 0, "");

	}
	
	public static int countNQueens(boolean[][] board, int row) {
		if(row == board.length) {
			return 1;
		}
		int count = 0;
		for (int col = 0; col < board[row].length; col++) {
			if(isItSafeToPlaceQueen(board, row, col)){
				board[row][col] = true;
				count += countNQueens(board, row+1);
				board[row][col] = false;
			}
		}
		return count;
	}
	
	public static void printNQueens(boolean[][] board, int row, String ans) {
		if(row == board.length) {
			System.out.println(ans);
			return;
		}
		for (int col = 0; col < board[row].length; col++) {
			if(isItSafeToPlaceQueen(board, row, col)){
				board[row][col] = true;
				printNQueens(board, row+1, ans+"{" + (row+1) + "," + (col+1) + "}");
				board[row][col] = false;
			}
		}
	}
	
	public static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {
		for (int i = 0; i < row; i++) {
			if(board[i][col] == true)
				return false;
		}
		for (int i = row-1, j = col-1; i >= 0 && j>=0; i--, j--) {
			if(board[i][j] == true)
				return false;
		}
		for (int i = row-1, j = col+1; i >= 0 && j<board[row].length; i--, j++) {
			if(board[i][j] == true)
				return false;
		}
		return true;
	}

}
