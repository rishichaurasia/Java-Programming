package Assignment;

import java.util.Scanner;

public class Assignment033 {

	public static void main(String[] args) {

//		Given a integer as a input and replace all the '0' with '5' in the integer
//
//		Input Format
//		Enter an integer n
//
//		Constraints
//		0<=n<=1000000000000
//
//		Output Format
//		All zeroes are replaced with 5
//
//		Sample Input
//		102
//		Sample Output
//		152
//		Explanation
//		Check each digit , if it is nonzero, then no change required but if it is 
//		zero then replace it by 5.

		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		replaceZeroes(n);

	}

	public static void replaceZeroes(long n) {
		long sum = 0;
		if (n == 0) {
			System.out.println(5);
			return;
		}
		for (int i = 0; n > 0; n /= 10, i++) {
			long rem = n % 10;
			if (rem == 0)
				rem = 5;
			sum += rem * Math.pow(10, i);
		}
		System.out.println(sum);

	}

}
