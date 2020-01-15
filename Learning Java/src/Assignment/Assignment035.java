package Assignment;

import java.util.Scanner;

public class Assignment035 {

	public static void main(String[] args) {
//		Given coefficients of a quadratic equation , you need to print the nature of the roots (Real and Equal , Real and Distinct , Imaginary) and the roots.
//
//		Input Format
//		First contains three coefficients a,b,c from the equation ax^2 + bx + c = 0.
//
//		Constraints
//		-100 <= a, b, c <= 100
//
//		Output Format
//		Output contains one/two lines.First line contains nature of the roots .The next line contains roots(in non-decreasing order) separated by a space if they exist. If roots are imaginary do not print the roots.
//
//		Sample Input
//		1 -11 28
//		Sample Output
//		Real and Distinct
//		4 7
//		Explanation
//		The input corresponds to equation ax^2 + bx + c = 0. Roots = (-b + sqrt(b^2 - 4ac))/2a , (-b - sqrt(b^2 - 4ac))/2a
		
		
		
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();;
		int c = scn.nextInt();
		printRoots(a, b, c);
	}
	
	public static void printRoots(int a, int b, int c) {
		int D = (int)Math.pow(b, 2) - 4*a*c;
		if(D>0) {
			System.out.println("Real and Distinct");
			int r1 = (-b-(int)Math.sqrt(D))/(2*a);
			int r2 = (-b+(int)Math.sqrt(D))/(2*a);
			System.out.println(r1 + " " + r2);
		}
		else if(D==0) {
			System.out.println("Real and Equal");
			int r = -b/(2*a);
			System.out.println(r + " " + r);
		}
		else
			System.out.println("Imaginary");
	}

}
