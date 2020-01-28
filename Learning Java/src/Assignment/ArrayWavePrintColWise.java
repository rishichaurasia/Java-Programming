package Assignment;

import java.util.Scanner;

public class ArrayWavePrintColWise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Take as input a two-d array. Wave print it column-wise.
		 * 
		 * Input Format Two integers M(row) and N(colomn) and further M * N integers(2-d
		 * array numbers).
		 * 
		 * Constraints Both M and N are between 1 to 10.
		 * 
		 * Output Format All M * N integers seperated by commas with 'END' wriiten in
		 * the end(as shown in example).
		 * 
		 * Sample Input 4 4 11 12 13 14 21 22 23 24 31 32 33 34 41 42 43 44 Sample
		 * Output 11, 21, 31, 41, 42, 32, 22, 12, 13, 23, 33, 43, 44, 34, 24, 14, END
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
		for (int col = 0; col < arr[0].length; col++) {
			int rows = arr.length;
			for (int row = 0; row < rows; row++) {
				if (col % 2 == 0)
					System.out.print(arr[row][col] + ", ");
				else
					System.out.print(arr[rows - 1 - row][col] + ", ");
			}
		}
		System.out.print("END");
	}

}
