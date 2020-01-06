package Pattern;

import java.util.Scanner;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take as input N, a number. Print the pascal triangle of given input N.
//		As an example, pascal's triangle for n=5 is given below.
//		1
//
//		1	1
//
//		1	2	1
//
//		1	3	3	1
//
//		1	4	6	4	1	
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int row = 1; row<=n; row++) {
			int c = 1;
			for(int i = 1; i<=row; i++) {
				System.out.print(c + "\t");
				c = c*(row-i)/i;
			}
			System.out.println();
		}
		
	}

}
