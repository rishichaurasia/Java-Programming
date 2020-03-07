package Assignment;

import java.util.Scanner;

public class SodokuSolver {
	
/*
You are given an N*N sudoku grid (N is a multiple of 3). Solve the sudoku and print the solution.
To learn more about sudoku, go to this link Sudoku-Wikipedia.

Input Format
First line contains a single integer N. Next N lines contains N integers each, where jth integer int ith line denotes the value at ith row and jth column in sudoku grid. This value is 0, if the cell is empty.

Constraints
N=9 Solution exists for input matrix.

Output Format
Print N lines containing N integers each, where jth integer int ith line denotes the value at ith row and jth column in sudoku grid, such that all cells are filled.

Sample Input
9
5 3 0 0 7 0 0 0 0 
6 0 0 1 9 5 0 0 0 
0 9 8 0 0 0 0 6 0 
8 0 0 0 6 0 0 0 3 
4 0 0 8 0 3 0 0 1 
7 0 0 0 2 0 0 0 6 
0 6 0 0 0 0 2 8 0 
0 0 0 4 1 9 0 0 5 
0 0 0 0 8 0 0 7 9 

Sample Output
5 3 4 6 7 8 9 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 2 8 6 1 7 9 
 */

	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scn.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = scn.nextInt();
			}
		}
		solveSudoku(arr, 0, 0);
	}
	
	public static boolean solveSudoku(int arr[][] , int row, int col) {
		
		if(col == arr[row].length) {
			row++;
			col=0;
		}
		
		if(row == arr.length) {
			print(arr);
			return true;
		}
		
		if(arr[row][col] == 0) {
			
			for(int i = 1; i<=9; i++) {
				if(isItSafe(arr, row, col, i)) {
					arr[row][col] = i;
					if(solveSudoku(arr, row, col+1))
						return true;
					arr[row][col] = 0;
				}
			}
			return false;
			
		}
		else
			return solveSudoku(arr, row, col+1);
		
	}
	
	public static boolean isItSafe(int[][] arr , int row, int col, int num) {
		for(int i = 0; i<arr.length; i++) {
			if(arr[i][col] == num)
				return false;
		}
		for(int i = 0; i<arr[row].length; i++) {
			if(arr[row][i] == num)
				return false;
		}
		int rowStart = row - row%3;
		int colStart = col - col%3;
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++) {
				if(arr[rowStart+i][colStart+j] == num)
					return false;
			}
		}
		return true;
	}
	
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}

