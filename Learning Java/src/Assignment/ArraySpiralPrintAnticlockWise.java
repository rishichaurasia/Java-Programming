package Assignment;

import java.util.Scanner;

public class ArraySpiralPrintAnticlockWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Take as input a 2-d array. Print the 2-D array in spiral form anti-clockwise.
		 * 
		 * Input Format Two integers M(row) and N(colomn) and further M * N integers(2-d
		 * array numbers).
		 * 
		 * Constraints Both M and N are between 1 to 10.
		 * 
		 * Output Format All M * N integers separated by commas with 'END' written in
		 * the end(as shown in example).
		 * 
		 * Sample Input 4 4 11 12 13 14 21 22 23 24 31 32 33 34 41 42 43 44 Sample
		 * Output 11, 21, 31, 41, 42, 43, 44, 34, 24, 14, 13, 12, 22, 32, 33, 23, END
		 * Explanation For spiral level anti-clockwise traversal, Go for first column->
		 * last row ->last column-> first row and then do the same traversal for the
		 * remaining matrix .
		 */

		Scanner scn = new Scanner(System.in);
		int rows = scn.nextInt();
		int cols = scn.nextInt();
		int[][] arr = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				arr[i][j] = scn.nextInt();
		}
		printSpiral(arr);

	}

	public static void printSpiral(int[][] arr) {
		int min_row = 0;
		int max_row = arr.length - 1;
		int min_col = 0;
		int max_col = arr[0].length - 1;
		int total = arr.length * arr[0].length;
		int count = 0;
		while (count < total) {
			for (int r = min_row; r <= max_row && count < total; r++, count++)
				System.out.print(arr[r][min_col] + ", ");
			min_col++;
			for (int c = min_col; c <= max_col && count < total; c++, count++)
				System.out.print(arr[max_row][c] + ", ");
			max_row--;
			for (int r = max_row; r >= min_row && count < total; r--, count++)
				System.out.print(arr[r][max_col] + ", ");
			max_col--;
			for (int c = max_col; c >= min_col && count < total; c--, count++)
				System.out.print(arr[min_row][c] + ", ");
			min_row++;

		}
		System.out.print("END");
	}

}
