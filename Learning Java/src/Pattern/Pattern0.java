package Pattern;

import java.util.Scanner;

public class Pattern0 {
	
//	Take N as input. For a value of N=5, we wish to draw the following pattern :
//	*
//	*
//	*
//	*
//	*

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("*");
		}

	}

}
