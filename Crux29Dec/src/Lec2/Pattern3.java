package Lec2;

import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int row = n; row > 0; row--) {
			for (int col = 1; col <= row; col++)
				System.out.print("*");
			System.out.println();
		}
	}

}
