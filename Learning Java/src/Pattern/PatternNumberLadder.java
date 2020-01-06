package Pattern;

import java.util.Scanner;

public class PatternNumberLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int row = 1, val = 1; row <= n; row++) {
			for (int col = 1; col <= row; col++, val++)
				System.out.print(val + "\t");
			System.out.println();
		}
	}

}
