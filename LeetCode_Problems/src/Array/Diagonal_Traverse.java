package Array;

public class Diagonal_Traverse {
	
//	O(m*n) time | O(1) space
	public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        if(matrix.length == 1)
            return matrix[0];
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int[] result = new int[nrow*ncol];
        int idx = 0;
        for(int i = 1; i<=nrow+ncol-1; i++){
            int row,col,d;
            if((i & 1) == 1){
                row = Math.min(i-1, nrow-1);
                col = Math.max(0, i-nrow);
                d = -1;
            }else{
                row = Math.max(0, i-ncol);
                col = Math.min(ncol-1, i-1);
                d = 1;
            }
            while(row >= 0 && row < nrow && col>=0 && col<ncol){
                result[idx++] = matrix[row][col];
                row+=d;
                col-=d;
            }
            
        }
        return result;
    }
	
//	O(m*n) time | O(1) space
	public int[] findDiagonalOrder1(int[][] matrix) {
        if(matrix.length == 0)
            return new int[0];
        if(matrix.length == 1)
            return matrix[0];
        int nrow = matrix.length;
        int ncol = matrix[0].length;
        int[] result = new int[nrow*ncol];
        int idx = 0;
        int row = 0, col = 0;
        boolean upDir = true;
        for(int i = 0; i<nrow*ncol; i++){
            result[i] = matrix[row][col];
            if(upDir){
                if(col == ncol-1){
                    row++;
                    upDir = !upDir;
                }else if(row == 0){
                    col++;
                    upDir = !upDir;
                }else{
                    row--;
                    col++;
                }
            }else{
                if(row == nrow-1){
                    col++;
                    upDir = !upDir;
                }else if(col == 0){
                    row++;
                    upDir = !upDir;
                }else{
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
