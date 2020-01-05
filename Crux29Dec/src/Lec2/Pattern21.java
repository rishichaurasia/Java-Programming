package Lec2;

import java.util.Scanner;

public class Pattern21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int row = 1, nst = 1, nsp = 2 * n - 3; row <= n; nst++, nsp -= 2, row++) {
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			int cst = 1;
			if (row == n)
				cst = 2;
			for (; cst <= nst; cst++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
