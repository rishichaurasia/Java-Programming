package Pattern;

import java.util.Scanner;

public class PatternRhombus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take N (number of rows), print the following pattern (for N = 3).
//				1
//			2	3	2
//		3	4	5	4	3
//			2	3	2
//				1

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int row = 1, val = 1, nst = 1, nsp = n - 1; row <= 2 * n - 1; row++) {
			for (int csp = 1; csp <= nsp; csp++)
				System.out.print("\t");
			int val1 = val;
			for (int i = 1; i <= nst; i++) {
				System.out.print(val1 + "\t");
				if (i < val)
					val1++;
				else
					val1--;
			}
			if (row < n) {
				nst += 2;
				nsp--;
				val++;
			} else {
				nst -= 2;
				nsp++;
				val--;
			}
			System.out.println();
		}
	}

}
