package Lec12;

public class FindWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'C', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ADE";
		boolean res = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == word.charAt(0))
					res = res || findWord(board, i, j, word, 0, new boolean[board.length][board[0].length]);
			}
		}
		System.out.println(res);

	}

	public static boolean findWord(char[][] board, int row, int col, String word, int idx, boolean[][] visited) {
		if (row < 0 || col < 0 || row >= board.length || col >= board[row].length)
			return false;

		if (visited[row][col] == true)
			return false;
		if (board[row][col] != word.charAt(idx)) {
			return false;
		}
		if (idx == word.length() - 1) {
			return true;
		}

		visited[row][col] = true;
		boolean bool = findWord(board, row + 1, col, word, idx + 1, visited)
				|| findWord(board, row - 1, col, word, idx + 1, visited)
				|| findWord(board, row, col + 1, word, idx + 1, visited)
				|| findWord(board, row, col - 1, word, idx + 1, visited);
		visited[row][col] = false;
		return bool;

	}

}
