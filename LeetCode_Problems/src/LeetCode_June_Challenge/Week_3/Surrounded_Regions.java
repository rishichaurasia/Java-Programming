package LeetCode_June_Challenge.Week_3;

public class Surrounded_Regions {

	public void solve(char[][] board) {
        if(board.length < 3 || board[0].length < 3)
            return;
        int nrow = board.length;
        int ncol = board[0].length;
        
        for(int row = 0; row<nrow; row++){
            if(board[row][0] == 'O') boundarySearch(board, row, 0);
            if(board[row][ncol-1] == 'O') boundarySearch(board, row, ncol-1);
        }
        
        for(int col = 0; col<ncol; col++){
            if(board[0][col] == 'O') boundarySearch(board, 0, col);
            if(board[nrow-1][col] == 'O') boundarySearch(board, nrow-1, col);
        }
        
        for(int row = 0; row < nrow; row++){
            for(int col = 0; col<ncol; col++){
                if(board[row][col] == 'O')
                    board[row][col] = 'X';
                if(board[row][col] == '#')
                    board[row][col] = 'O';
            }
        }
    }
    
    public void boundarySearch(char[][] board, int row, int col){
        if(row < 0 || col < 0 || row>=board.length || col>=board[0].length || board[row][col] != 'O')
            return;
        
        board[row][col] = '#';
        
        boundarySearch(board, row-1, col);
        boundarySearch(board, row+1, col);
        boundarySearch(board, row, col-1);
        boundarySearch(board, row, col+1);
    }
	
}
