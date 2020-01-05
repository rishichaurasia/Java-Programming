package Lec2;

import java.util.Scanner;

public class Pattern14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int row=1, nsp=n-1, nst=1; row<=2*n-1; row++) {
			for(int csp=1; csp<=nsp; csp++) {
				System.out.print(" ");
			}
			for(int cst =1; cst<=nst; cst++) {
				System.out.print("*");
			}
			if(row<n) {
				nsp--;
				nst++;
			}
			else {
				nsp++;
				nst--;
			}
			System.out.println();
		}
	}

}
