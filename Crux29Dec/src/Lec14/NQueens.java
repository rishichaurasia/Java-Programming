package Lec14;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		NQueens2(new boolean[4][4], 0, "");
		kQueens(new boolean[4][4], 0, 3, 0, "");

	}
	
	static int count=0;
	
	public static void NQueens2 (boolean[][] board, int row, String ans) {
		if(row==board.length) {
			System.out.println(++count + " : " + ans);
			return;
		}
		for(int col = 0; col<board[row].length; col++) {
			if(isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				NQueens2(board, row+1, ans+"{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}
	}
	
	public static void kQueens (boolean[][] board, int row, int tq, int qpsf, String ans) {
		if(tq == qpsf) {
			System.out.println(++count + " : " + ans);
			return;
		}
		if(row==board.length) {
			return;
		}
		
		for(int col = 0; col<board[row].length; col++) {
			if(isItSafeToPlaceQueen(board, row, col)) {
				board[row][col] = true;
				kQueens(board, row+1, tq, qpsf+1, ans+"{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}
//		if(qpsf<tq)
		kQueens(board, row+1, tq, qpsf, ans);
		
		
	}
	
	public static boolean isItSafeToPlaceQueen(boolean[][] board, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i][col] == true)
				return false;
		}
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == true)
				return false;
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < board[row].length; i--, j++) {
			if (board[i][j] == true)
				return false;
		}
		return true;
	}

}
