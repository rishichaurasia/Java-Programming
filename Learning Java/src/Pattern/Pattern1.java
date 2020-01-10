package Pattern;

import java.util.Scanner;

public class Pattern1 {
	
//	Take N as input. For a value of N=5, we wish to draw the following pattern :
//	*****
//	*****
//	*****
//	*****
//	*****
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
