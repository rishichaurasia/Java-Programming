package Pattern;

import java.util.Scanner;

public class PatternDoubleSidedArrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take N as input. For a value of N=7, we wish to draw the following pattern :
//
//		            1 
//		        2 1   1 2 
//		    3 2 1       1 2 3 
//		4 3 2 1           1 2 3 4 
//		    3 2 1       1 2 3 
//		        2 1   1 2 
//		            1 

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nsp = n - 1;
		int nst = 1;
		int val1 = 1;
		for (int row = 1; row <= n; row++) {
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print("  ");
			}
			int val2 = val1;
			for (int cst = 1; cst <= nst; cst++) {
				if (val2 >= 1)
					System.out.print(val2 + " ");
				else
					System.out.print("  ");
				if (cst <= nst / 2)
					val2--;
				else
					val2++;
			}
			if (row <= n / 2) {
				nsp -= 2;
				nst += 4;
				val1++;
			} else {
				nsp += 2;
				nst -= 4;
				val1--;
			}
			System.out.println();
		}

	}

}
