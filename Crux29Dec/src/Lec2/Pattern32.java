package Lec2;

import java.util.Scanner;

public class Pattern32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int row = 1, val=1, nst = 1; row<=2*n-1; row++) {
			for(int cst = 1; cst<=nst; cst++) {
				if(cst%2==0)
					System.out.print("*");
				else
					System.out.print(val);
			}
			if(row<n) {
				nst+=2;
				val++;
			}
			else {
				nst-=2;
				val--;
			}
			System.out.println();
		}

	}

}
