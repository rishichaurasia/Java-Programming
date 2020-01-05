//Take the following as input.
//
//A number (N1)
//A number (N2)
//Write a function which returns the LCM of N1 and N2. Print the value returned.
//
//Input Format:
//Constraints
//0 < N1 < 1000000000 0 < N2 < 1000000000
//
//Output Format:
//Sample Input
//4 
//6
//Sample Output:
//12
//Explanation:
//The smallest number that is divisible by both N1 and N2 is called the LCM of N1 and N2.
package Lec1;

import java.util.Scanner;

public class LCM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		int product = a*b;
		while(b != 0) {
			int rem = a%b;
			a = b;
			b = rem;
		}
		int gcd = a;
		System.out.println(product/gcd);
		
	}

}
