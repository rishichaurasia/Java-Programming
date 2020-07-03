package LeetCode_June_Challenge.Week_4;

import java.util.Arrays;

public class Perfect_Squares {

	public static void main(String[] args) {
		int n = 121143;
		System.out.println(numSquares(n));

	}

	public static int numSquares(int n) {
//		return numSquaresRecur(n);
//		return numSquaresTD(n, new int[n+1]);
		return numSquaresBU(n);
	}

	// Recursion
	private static int numSquaresRecur(int n) {
		if (n == 0)
			return 0;
		int root = (int) Math.sqrt(n);
		if (root * root == n)
			return 1;
		int min = n;
		for (int i = 2; i <= root; i++) {
			min = Math.min(min, numSquaresRecur(n - i * i) + 1);
		}
		return min;
	}

	// Memoisation
	// O(n*sqrt(n)) Time
	private static int numSquaresTD(int n, int[] strg) {
		if (n == 0)
			return 0;
		if (strg[n] != 0)
			return strg[n];
		int root = (int) Math.sqrt(n);
		if (root * root == n)
			return 1;
		int min = n;
		for (int i = 2; i <= root; i++) {
			min = Math.min(min, numSquaresTD(n - i * i, strg) + 1);
		}
		strg[n] = min;
		return min;
	}

	// DP
	// O(n*sqrt(n)) Time
	private static int numSquaresBU(int n) {
		int[] strg = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			int min = i;
			for (int j = 2; j * j <= i; j++) {
				int rv = strg[i - j * j] + 1;
				min = Math.min(min, rv);
			}
			strg[i] = min;
		}
		return strg[n];
	}

	// Legendre's 3-Square Theorem
	// O(sqrt(n)) Time
	public int numSquaresL3ST(int n) {
		// four-square and three-square theorems.
		while (n % 4 == 0)
			n /= 4;
		if (n % 8 == 7)
			return 4;

		if (isSquare(n))
			return 1;

		// enumeration to check if the number can be decomposed into sum of two squares.
		for (int i = 1; i * i <= n; ++i) {
			if (isSquare(n - i * i))
				return 2;
		}
		// bottom case of three-square theorem.
		return 3;
	}

	protected static boolean isSquare(int n) {
		int sq = (int) Math.sqrt(n);
		return n == sq * sq;
	}

}
