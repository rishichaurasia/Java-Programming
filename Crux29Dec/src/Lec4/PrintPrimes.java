package Lec4;

import java.util.Scanner;

public class PrintPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int lo = scn.nextInt();
		int hi = scn.nextInt();
		printPrimes(lo, hi);
		System.out.println("End");
	}

	public static void printPrimes(int lo, int hi) {
		for (; lo <= hi; lo++) {
			if (isPrime(lo))
				System.out.print(lo + " ");
		}
	}

	public static boolean isPrime(int n) {
		if (n == 2)
			return true;
		if (n == 1 || n % 2 == 0)
			return false;
		
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
