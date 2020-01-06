package Pattern;

import java.util.Scanner;

public class MirrorStarPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int row = 1, nsp = 2, nst = 1; row<=n; row++) {
			for(int csp = 1; csp<=nsp; csp++)
				System.out.print("\t");
			for(int cst = 1; cst<=nst; cst++)
				System.out.print("*\t");
			if(row<=n/2) {
				nst+=2;
				nsp--;
			}
			else {
				nst-=2;
				nsp++;
			}
			
			System.out.println();
		}
	}

}
