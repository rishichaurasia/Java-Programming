package Lec2;

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= row; col++)
				System.out.print("*");
			System.out.println();
		}
	}

}
