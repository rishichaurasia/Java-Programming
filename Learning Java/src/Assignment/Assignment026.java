package Assignment;

import java.util.Scanner;

public class Assignment026 {
	
//	Given a binary number ,help Von Neuman to find out its decimal representation. 
//	For eg 000111 in binary is 7 in decimal.
//
//	Input Format
//	The first line contains N , the number of binary numbers. Next N lines contain N 
//	integers each representing binary represenation of number.
//
//	Constraints
//	N<=1000 Digits in binary representation is <=16.
//
//	Output Format
//	N lines,each containing a decimal equivalent of the binary number.
//
//	Sample Input
//	4
//	101
//	1111
//	00110
//	111111
//	
//	Sample Output
//	5
//	15
//	6
//	63
//	Explanation
//	For binary number fedcba , Decimal number = f * 25 + e * 24 + d * 23 + …..+ a *
//	20.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++)
			arr[i] = scn.nextInt();
		for(int val: arr) {
			int result = bin2dec(val);
			System.out.println(result);
		}
			
	}
	
	public static int bin2dec(int n) {
		
		int sum = 0;
		for(int i = 0; n>0; i++, n/=10) {
			int rem = n%10;
			sum += rem*Math.pow(2, i);
		}
		return sum;
	}

}
