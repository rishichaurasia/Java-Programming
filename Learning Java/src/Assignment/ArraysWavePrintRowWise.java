package Assignment;

import java.util.Scanner;

public class ArraysWavePrintRowWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Take as input a two-d array. Wave print it row-wise.
		 * 
		 * Input Format Two integers M(row) and N(column) and further M * N integers(2-d
		 * array numbers).
		 * 
		 * Constraints Both M and N are between 1 to 10.
		 * 
		 * Output Format All M * N integers are seperated by commas with 'END' written
		 * in the end(as shown in example).
		 * 
		 * Sample Input 4 4 11 12 13 14 21 22 23 24 31 32 33 34 41 42 43 44 Sample
		 * Output 11, 12, 13, 14, 24, 23, 22, 21, 31, 32, 33, 34, 44, 43, 42, 41, END
		 */
		Scanner scn = new Scanner(System.in);
		int rows = scn.nextInt();
		int cols = scn.nextInt();
		int[][] arr = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				arr[i][j] = scn.nextInt();
		}
		printWave(arr);

	}

	public static void printWave(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			int rowLength = arr[row].length;
			for (int col = 0; col < rowLength; col++) {
				if (row % 2 == 0)
					System.out.print(arr[row][col] + ", ");
				else
					System.out.print(arr[row][rowLength - 1 - col] + ", ");
			}
		}
		System.out.print("END");
	}

}
