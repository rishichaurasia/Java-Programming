package Lec2;

import java.util.Scanner;

public class Pattern6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int row = 1, nst = n, nsp = 0; row <= n; row++, nst--, nsp++) {
			for (int csp = 1; csp <= 2*nsp; csp++)
				System.out.print(" ");
			for (int cst = 1; cst <= nst; cst++)
				System.out.print("*");
			System.out.println();
		}
	}

}
