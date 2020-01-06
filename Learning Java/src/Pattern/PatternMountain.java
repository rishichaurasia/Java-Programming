package Pattern;

import java.util.Scanner;

public class PatternMountain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take N (number of rows), print the following pattern (for N = 4).
//		1						1
//		1	2				2	1
//		1	2	3		3	2	1
//		1	2	3	4	3	2	1
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int row = 1, nsp = 2*n-3; row<=n; row++, nsp-=2) {
			for(int i = 1; i<=row; i++)
				System.out.print(i + "\t");
			for(int csp = 1; csp<=nsp; csp++) {
				System.out.print("\t");
			}
			int i = row;
			if(row == n)
				i--;
			for( ; i>0; i-- )
				System.out.print(i + "\t");
			System.out.println();
		}
		
		
	}
	
}
