package Lec12;

public class Backtracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		boolean[] board = new boolean[4];
//		queenCombinationBoxRespect(board, 0, 2, 0, "");

//		int[] denom = {2,3,5,6};
//		coinChange(denom, 0, 10, "");

//		boolean[][] board = new boolean[2][3];
//		queenCombinationBoxRespect2D(board, 0, 0, 2, 0, "");

//		NQueens(new boolean[4][4], 0, 0, 4, 0, "");

//		NKnight(new boolean[4][4], 0, 0, 4, 0, "");

		char[][] board = { { 'o', 'x', 'o', 'o' }, { 'o', 'o', 'o', 'o' }, { 'o', 'x', 'o', 'o' },
				{ 'o', 'o', 'x', 'o' } };
		blockedMaze(board, 0, 0, 3, 3, "");

	}
	
	public static void blockedMaze(char[][] board, int sr, int sc, int er, int ec, String ans) {
		if(sr==er && sc==ec) {
			System.out.println(ans);
			return;
		}
		if (sr < 0 || sr > er || sc < 0 || sc > ec)
			return;
		if(board[sr][sc] == 'x')
			return;
		if(board[sr][sc] == 'p')
			return;
		board[sr][sc] = 'p';
		blockedMaze(board, sr+1, sc, er, ec, ans+"D");
		blockedMaze(board, sr-1, sc, er, ec, ans+"U");
		blockedMaze(board, sr, sc+1, er, ec, ans+"R");
		blockedMaze(board, sr, sc-1, er, ec, ans+"L");
		board[sr][sc] = 'o';
	}

	static int count = 0;

	public static void NKnight(boolean[][] board, int row, int col, int tq, int qpsf, String ans) {
		if (tq == qpsf) {
			System.out.println(++count + " : " + ans);
			return;
		}

		if (col == board[row].length) {
			row++;
			col = 0;
		}
		if (row == board.length)
			return;
		if (isItSafeToPlaceKnight(board, row, col)) {
			board[row][col] = true;
			NKnight(board, row, col + 1, tq, qpsf + 1, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}
		NKnight(board, row, col + 1, tq, qpsf, ans);
	}

	public static boolean isItSafeToPlaceKnight(boolean[][] board, int row, int col) {
		int[] r = { -1, -1, -2, -2 };
		int[] c = { -2, 2, -1, 1 };
		for (int i = 0; i < r.length; i++) {
			int nr = row + r[i];
			int nc = col + c[i];
			if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[nr].length) {
				if (board[nr][nc] == true)
					return false;
			}
		}
		return true;
	}

	public static void NQueens(boolean[][] board, int row, int col, int tq, int qpsf, String ans) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}

		if (row < board.length && col == board[row].length) {
			row++;
			col = 0;
		}
		if (row == board.length)
			return;
		if (isItSafeToPlaceQueen(board, row, col)) {
			board[row][col] = true;
			NQueens(board, row + 1, 0, tq, qpsf + 1, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}
		NQueens(board, row, col + 1, tq, qpsf, ans);
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

	public static void queenCombinationBoxRespect2D(boolean[][] board, int row, int col, int tq, int qpsf, String ans) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}

		if (col == board[row].length) {
			row++;
			col = 0;
		}
		if (row == board.length)
			return;

		board[row][col] = true;
		queenCombinationBoxRespect2D(board, row, col + 1, tq, qpsf + 1, ans + "[" + row + "-" + col + "]");
		board[row][col] = false;
		queenCombinationBoxRespect2D(board, row, col + 1, tq, qpsf, ans);
	}

	public static void queenCombinationBoxRespect(boolean[] board, int col, int tq, int qpsf, String ans) {
		if (tq == qpsf) {
			System.out.println(ans);
			return;
		}
		if (col >= board.length)
			return;

		board[col] = true;
		queenCombinationBoxRespect(board, col + 1, tq, qpsf + 1, ans + " b" + col);
		board[col] = false;
		queenCombinationBoxRespect(board, col + 1, tq, qpsf, ans);
	}

	public static void coinChange(int[] denom, int idx, int amount, String ans) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		if (amount < 0)
			return;
		if (idx == denom.length)
			return;
		coinChange(denom, idx + 1, amount, ans);

		coinChange(denom, idx, amount - denom[idx], ans + denom[idx]);
	}

}
