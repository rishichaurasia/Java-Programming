package Pattern;

import java.util.Scanner;

public class Pattern_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int row = 1, nst = n, nsp = -1; row <= 2 * n - 1; row++) {
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			int cst = 1;
			if (row == 1 || row == 2 * n - 1)
				cst = 2;
			for (; cst <= nst; cst++) {
				System.out.print("*");
			}
			if (row < n) {
				nst--;
				nsp += 2;
			} else {
				nst++;
				nsp -= 2;
			}
			System.out.println();
		}
	}

}
