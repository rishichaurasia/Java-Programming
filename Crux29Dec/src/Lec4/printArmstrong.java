package Lec4;

import java.util.Scanner;

public class printArmstrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int lo = scn.nextInt();
		int hi = scn.nextInt();
		printArmstrong(lo, hi);

	}

	public static void printArmstrong(int lo, int hi) {
		for (; lo <= hi; lo++) {
			if (isArmstrong(lo))
				System.out.println(lo);
		}
	}

	public static boolean isArmstrong(int n) {
		int digits = countDigits(n);
		int ans = 0;
		for (int n1 = n; n1 > 0; n1 /= 10) {
			int rem = n1 % 10;
			ans += Math.pow(rem, digits);
		}
		if (ans == n)
			return true;
		return false;
	}

	public static int countDigits(int n) {
		int i = 0;
		for (; n > 0; n /= 10) {
			i++;
		}
		return i;
	}

}
