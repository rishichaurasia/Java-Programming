package Lec6;

import java.util.Scanner;

public class TwoDimensionArray {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = takeInput();
		display(arr);

	}

	public static int[][] takeInput() {
		System.out.println("Rows?");
		int rows = scn.nextInt();
		int[][] arr = new int[rows][];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Cols in" + i + "Row?");
			int col = scn.nextInt();
			arr[i] = new int[col];
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("[" + i + "-" + j + "]");
				arr[i][j] = scn.nextInt();
			}
		}
		return arr;
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
