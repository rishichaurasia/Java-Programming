package Pattern;

import java.util.Scanner;

public class HollowRhombusPattern {
	
//	Take N as input. For a value of N=5, we wish to draw the following pattern :
//	    *****
//	   *   *
//	  *   *
//	 *   *
//	*****

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int row = 1, nst = n, nsp = n-1; row<=n; row++) {
			for(int csp = 1; csp<=nsp; csp++)
				System.out.print(" ");
			for(int cst=1; cst<=nst; cst++) {
				if(row == 1 || row==n || cst==1 || cst==n)
					System.out.print("*");
				else
					System.out.print(" ");
			}
				nsp--;
				System.out.println();
		}
	}

}
