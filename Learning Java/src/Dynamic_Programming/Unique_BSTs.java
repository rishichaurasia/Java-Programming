package Dynamic_Programming;

import java.util.stream.IntStream;

public class Unique_BSTs {

	public static void main(String[] args) {

		int n = 4;

//		System.out.println(uniqueBSTRS(n));

//		System.out.println(uniqueBSTTD(n, new int[n+1]));

		System.out.println(uniqueBSTBU(n));

	}

//	Unique BSTs = Sigma(ith node root node)
//				= Sigma( f(i-1) * f(n-i) )  // Catalan Series
//				= C(2n,n)/(n+1)
//	Catalan Series = 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, ... 
//	https://www.geeksforgeeks.org/applications-of-catalan-numbers/
	public static int uniqueBSTRS(int n) {

		if (n <= 1)
			return 1;

		int count = 0;

		for (int i = 1; i <= n; ++i) {

			count += uniqueBSTRS(i - 1) * uniqueBSTRS(n - i);

		}

		return count;

	}

	public static int uniqueBSTTD(int n, int[] strg) {

		if (n <= 1)
			return 1;

		if (strg[n] != 0)
			return strg[n];

		int count = 0;

		for (int i = 1; i <= n; ++i) {

			count += uniqueBSTTD(i - 1, strg) * uniqueBSTTD(n - i, strg);

		}

		strg[n] = count;

		return count;

	}

	public static int uniqueBSTBU(int n) {
		int[] strg = new int[n + 1];

		strg[0] = strg[1] = 1;

		for (int i = 2; i < n + 1; ++i) {

			int count = 0;

			for (int j = 1; j <= i; ++j) {

				count += strg[j - 1] * strg[i - j];

			}

			strg[i] = count;

		}

		return strg[n];
	}

}
