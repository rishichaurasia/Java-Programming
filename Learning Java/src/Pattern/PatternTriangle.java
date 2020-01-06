package Pattern;

import java.util.Scanner;

public class PatternTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take N (number of rows), print the following pattern (for N = 4).
//					1
//				2	3	2
//	        3	4	5	4	3
//		4	5	6	7	6	5	4

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int row = 1, nsp = n - 1; row <= n; row++, nsp--) {
			for (int col = 1; col <= nsp; col++)
				System.out.print("\t");
			int val = row;
			for (int col = 1; col <= 2 * row - 1; col++) {
				System.out.print(val + "\t");
				if (col < row)
					val++;
				else
					val--;
			}
			System.out.println();
		}

	}

}
