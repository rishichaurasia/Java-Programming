package Pattern;

import java.util.Scanner;

public class PatternHourGlass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take N as input. For a value of N=5, we wish to draw the following pattern :
//
//            5 4 3 2 1 0 1 2 3 4 5
//              4 3 2 1 0 1 2 3 4 
//                3 2 1 0 1 2 3 
//                  2 1 0 1 2 
//                    1 0 1 
//                      0 
//                    1 0 1 
//                  2 1 0 1 2 
//                3 2 1 0 1 2 3 
//              4 3 2 1 0 1 2 3 4 
//            5 4 3 2 1 0 1 2 3 4 5
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int val1 = n;
		int nsp = 0;
		int nst = 2 * n + 1;
		for (int row = 1; row <= 2 * n + 1; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			int val2 = val1;
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print(val2 + " ");
				if (cst <= nst / 2) {
					val2--;
				} else {
					val2++;

				}
			}
			if (row <= n) {
				val1--;
				nst -= 2;
				nsp += 2;
			} else {
				val1++;
				nst += 2;
				nsp -= 2;
			}
			System.out.println();
		}
	}

}
