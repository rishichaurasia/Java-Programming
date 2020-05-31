package Dynamic_Programming;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 40;
//		System.out.println(fibRS(n));
//		System.out.println(fibTD(n, new int[n + 1]));
//		System.out.println(fibBU(n));
		System.out.println(fibBUSE(n));
	}

	// TC: 2^n	SC: Rec. extra space
	public static int fibRS(int n) {
		if (n == 1 || n == 0)
			return n;

		int fnm1 = fibRS(n - 1);
		int fnm2 = fibRS(n - 2);
		int fn = fnm1 + fnm2;
		return fn;
	}

	// Top Down Approach (Memoisation)
	// TC: O(n)	SC: O(n) + Rec. extra space
	public static int fibTD(int n, int[] strg) {
		if (n == 1 || n == 0)
			return n;

		if (strg[n] != 0)
			return strg[n];
		int fnm1 = fibTD(n - 1, strg);
		int fnm2 = fibTD(n - 2, strg);
		int fn = fnm1 + fnm2;
		strg[n] = fn;
		return fn;
	}
	
	// Button up approach (Tabulation) 
	// TC: O(n)	SC: O(n)
	public static int fibBU(int n) {
		int[] strg = new int[n+1];
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i < strg.length; i++) {
			strg[i] = strg[i-1] + strg[i-2];
		}
		return strg[n];
	}
	
	// Bottom's up space efficient
	// TC: O(n)	SC: O(1)
	public static int fibBUSE(int n) {
		int[] strg = new int[2];
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			int nth = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = nth;
			
		}
		return strg[1];
	}

}
