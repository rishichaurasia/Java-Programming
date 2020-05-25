package Backtracking;

// https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/

public class The_Knights_Tour {

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		placeKnights(arr, 0, 0, 1);

	}
	
	public static void placeKnights(int[][] arr, int row, int col, int move) {
		if(row<0 || col<0 || row>=arr.length || col>=arr[0].length || arr[row][col] != 0)
			return;
		arr[row][col] = move;
		if(move == arr.length*arr.length) {
			display(arr);
			arr[row][col] = 0;
			return;
		}
		int[] rowArr = {-1, -1, 1, 1, -2, -2, 2, 2};
		int[] colArr = {-2, 2, -2, 2, -1, 1, -1, 1};
		for(int i = 0; i<rowArr.length; i++) {
			placeKnights(arr, row+rowArr[i], col + colArr[i], move+1);
		}
		arr[row][col] = 0;
	}
	
	public static void display(int[][] arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

}
