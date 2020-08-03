package Array;

public class Search_a_2D_matrix_II {

	public static void main(String[] args) {
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		System.out.println(searchMatrix(matrix, 5));
		System.out.println(searchMatrix(matrix, 20));
	}
	
	// Recursively
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        return searchMatrix(matrix, 0, matrix[0].length-1, target);
    }
    
    public static boolean searchMatrix(int[][] matrix, int row, int col, int target){
        if(col == -1 || row == matrix.length)
            return false;
        
        if(matrix[row][col] > target)
            return searchMatrix(matrix, row, col-1, target);
        else if(matrix[row][col] < target)
            return searchMatrix(matrix, row+1, col, target);
        else
            return true;
        
    }
    
    // Iteratively
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int row = 0, col = matrix[0].length-1;
        
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] > target)
                col--;
            else if(matrix[row][col] < target)
                row++;
            else
                return true;
        }
        
        return false;
    }

}
