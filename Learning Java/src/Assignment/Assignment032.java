package Assignment;

import java.util.Scanner;

public class Assignment032 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Luke Skywalker gave Chewbacca an integer number x. Chewbacca isn't good at 
//		numbers but he loves inverting digits in them. Inverting digit t means 
//		replacing it with digit 9 - t.
//
//		Help Chewbacca to transform the initial number x to the minimum possible 
//		positive number by inverting some (possibly, zero) digits. The decimal 
//		representation of the final number shouldn't start with a zero.
//
//		Input Format
//		The first line contains a single integer x (1 ≤ x ≤ 10^18) — the number that 
//		Luke Skywalker gave to Chewbacca.
//
//		Constraints
//		x <= 100000000000000000
//
//		Output Format
//		Print the minimum possible positive number that Chewbacca can obtain after 
//		inverting some digits. The number shouldn't contain leading zeroes.
//
//		Sample Input
//		4545
//		Sample Output
//		4444
//		Explanation
//		There are many numbers form after inverting the digit. For minimum number, 
//		check if inverting digit is less than or greater than the original digit.
//		If it is less, then invert it otherwise leave it.

		Scanner scn = new Scanner(System.in);
		long n = scn.nextLong();
		printChewbacca(n);

	}

	public static void printChewbacca(long n) {
		long sum = 0;
		for (int i = 0; n > 0; n /= 10, i++) {
			if (n == 9) {
				sum += n * Math.pow(10, i);
				continue;
			}
			int rem = (int) (n % 10);
			if (rem > 4)
				rem = 9 - rem;
			sum += rem * Math.pow(10, i);
		}
		System.out.println(sum);
	}

}
