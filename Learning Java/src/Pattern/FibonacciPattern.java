package Pattern;

import java.util.Scanner;

public class FibonacciPattern {
	
//	Take N as input. For a value of N=5, we wish to draw the following pattern :
//	0	
//	1	1	
//	2	3	5	
//	8	13	21	34	
//	55	89	144	233	377


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a = 0, b = 1;
		for(int row = 1; row<=n; row++) {
			for(int col = 1; col<=row; col++) {
				System.out.print(a + "\t");
				int sum = a+b;
				a = b;
				b = sum;
			}
			System.out.println();
		}
	}

}
