package Pattern;

import java.util.Scanner;

public class PatternWithZeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= row; col++) {
				if (col == 1 || col == row)
					System.out.print(row + "\t");
				else
					System.out.print(0 + "\t");
			}
			System.out.println();
		}
	}

}
