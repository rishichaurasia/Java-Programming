package Assignment;

import java.util.Scanner;

public class Assignment025 {
	
//	Take sb (source number system base), db (destination number system base) and 
//	sn (number in source format). Write a function that converts sn to its counterpart
//	in destination number system. Print the value returned.
//
//	Input Format
//	Constraints
//	0 < N <= 1000000000
//
//	Output Format
//	Sample Input
//	8
//	2 
//	33
//	Sample Output
//	11011
//	Explanation
//	All input output is as integers and in separate lines.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int sb = scn.nextInt();
		int db = scn.nextInt();
		int n = scn.nextInt();
		int result = convert(sb, db, n);
		System.out.println(result);
	}
	
	public static int convert(int sb, int db, int n) {
		int temp = n, sum = 0;
		for(int i = 0; temp>0; i++, temp/=10) {
			int rem = temp % 10;
			sum += rem*Math.pow(sb, i);
		}
		temp = sum;
		sum = 0;
		for(int i = 0; temp>0; i++, temp/=db) {
			int rem = temp%db;
			sum += rem*Math.pow(10, i);
		}
		return sum;
	}

}
