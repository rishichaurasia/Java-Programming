package Assignment;

import java.util.Scanner;

public class Assignment028 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take the following as input.
//
//		A number (N1)
//		A number (N2)
//		Write a function which prints first N1 terms of the series 3n + 2 which are
//		not multiples of N2.
//
//		Input Format
//		Constraints
//		0 < N1 < 100 0 < N2 < 100
//
//		Output Format
//		Sample Input
//		10 
//		4
//		Sample Output
//		5 
//		11 
//		14 
//		17 
//		23 
//		26 
//		29 
//		35 
//		38 
//		41
//		Explanation
//		The output will've N1 terms which are not divisible by N2.
		
		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		generateSeries(n1, n2);
		
	}
	
	public static void generateSeries(int n1, int n2) {
		for(int n = 1, i=1 ; i<=10; n++) {
			int term = 3*n + 2;
			if(term%n2 != 0) {
				System.out.println(term);
				i++;
			}
		}
	}

}
