package Dynamic_Programming;

import java.util.Arrays;

public class LCS_with_3_strings {

	public static void main(String[] args) {
		String s1 = "GHQWNV";
		String s2 = "SJNSDGH";
		String s3 = "CPGMAH";

		System.out.println(LCSRS(s1, s2, s3, 0, 0, 0));
		
		int[][][] strg = new int[s1.length()][s2.length()][s3.length()];
		
		for(int[][] arr1: strg) {
			for(int[] arr2: arr1)
				Arrays.fill(arr2, -1);
		}
		
		System.out.println(LCSTD(s1, s2, s3, 0, 0, 0, strg));
		System.out.println(LCSBU(s1, s2, s3));

	}

	public static int LCSRS(String s1, String s2, String s3, int idx1, int idx2, int idx3) {

		if (idx1 == s1.length() || idx2 == s2.length() || idx3 == s3.length())
			return 0;

		int ans = 0;

		if (s1.charAt(idx1) == s2.charAt(idx2) && s2.charAt(idx2) == s3.charAt(idx3))
			ans = 1 + LCSRS(s1, s2, s3, idx1 + 1, idx2 + 1, idx3 + 1);
		else {
			int ans1 = LCSRS(s1, s2, s3, idx1 + 1, idx2, idx3);
			int ans2 = LCSRS(s1, s2, s3, idx1, idx2 + 1, idx3);
			int ans3 = LCSRS(s1, s2, s3, idx1, idx2, idx3 + 1);

			ans = Math.max(ans1, Math.max(ans2, ans3));
		}

		return ans;

	}

	public static int LCSTD(String s1, String s2, String s3, int idx1, int idx2, int idx3, int[][][] strg) {

		if (idx1 == s1.length() || idx2 == s2.length() || idx3 == s3.length())
			return 0;

		if (strg[idx1][idx2][idx3] != -1)
			return strg[idx1][idx2][idx3];

		int ans = 0;

		if (s1.charAt(idx1) == s2.charAt(idx2) && s2.charAt(idx2) == s3.charAt(idx3))
			ans = 1 + LCSTD(s1, s2, s3, idx1 + 1, idx2 + 1, idx3 + 1, strg);
		else {
			int ans1 = LCSTD(s1, s2, s3, idx1 + 1, idx2, idx3, strg);
			int ans2 = LCSTD(s1, s2, s3, idx1, idx2 + 1, idx3, strg);
			int ans3 = LCSTD(s1, s2, s3, idx1, idx2, idx3 + 1, strg);

			ans = Math.max(ans1, Math.max(ans2, ans3));
		}

		strg[idx1][idx2][idx3] = ans;

		return ans;

	}

	public static int LCSBU(String s1, String s2, String s3) {

		int[][][] strg = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

		for (int i = s1.length() - 1; i >= 0; --i) {
			for (int j = s2.length() - 1; j >= 0; --j) {
				for (int k = s3.length() - 1; k >= 0; --k) {
					if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
						strg[i][j][k] = strg[i + 1][j + 1][k + 1] + 1;
					} else {
						strg[i][j][k] = Math.max(strg[i + 1][j][k], Math.max(strg[i][j + 1][k], strg[i][j][k + 1]));
					}
				}
			}
		}

		return strg[0][0][0];

	}

}
