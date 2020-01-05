package Lec2;

import java.util.Scanner;

public class Pattern12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int row = 1, nst = 1, nsp = n - 1; row <= n; row++, nst += 2, nsp--) {
			for (int csp = 1; csp <= nsp; csp++)
				System.out.print(" ");
			for (int cst = 1; cst <= nst; cst++) {
				if (cst % 2 == 1)
					System.out.print("*");
				else {
					System.out.print("!");
				}
			}
			System.out.println();
		}
	}

}
