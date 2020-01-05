//Take the following as input.
//
//A number (N1)
//A number (N2)
//Write a function which returns the GCD of N1 and N2. Print the value returned.
package Lec1;

import java.util.Scanner;

public class gcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		while (b != 0) {
			int rem = a % b;
			a = b;
			b = rem;
		}
		System.out.print(a);
	}

}
