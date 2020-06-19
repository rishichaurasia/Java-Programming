package Dynamic_Programming;

import java.util.Arrays;

//Min. no. of operations(add, delete, remove) to make s2 = s1

public class Edit_Distance {

	public static void main(String[] args) {
		String s1 = "agbgd";
		String s2 = "acgb";
		System.out.println(editDistanceRS(s1, s2));
		System.out.println(editDistanceRS1(s1, 0, s2, 0));
		int[][] strg = new int[s1.length()][s2.length()];
		for (int[] row : strg)
			Arrays.fill(row, -1);
		System.out.println(editDistanceTD(s1, 0, s2, 0, strg));
		System.out.println(editDistanceBU(s1, s2));
	}

	// O(3^(m+n)) time
	private static int editDistanceRS(String s1, String s2) {
		if (s1.length() == 0)
			return s2.length();
		if (s2.length() == 0)
			return s1.length();

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (s1.charAt(0) == s2.charAt(0))
			ans = editDistanceRS(ros1, ros2);
		else {
			int f1 = editDistanceRS(ros1, ros2); // replace
			int f2 = editDistanceRS(ros1, s2); // add
			int f3 = editDistanceRS(s1, ros2); // remove
			ans = Math.min(f1, Math.min(f2, f3)) + 1;
		}

		return ans;

	}

	private static int editDistanceRS1(String s1, int idx1, String s2, int idx2) {
		if (idx1 == s1.length() || idx2 == s2.length())
			return Math.max(s1.length() - idx1, s2.length() - idx2);

		int ans = 0;
		if (s1.charAt(idx1) == s2.charAt(idx2))
			ans = editDistanceRS1(s1, idx1 + 1, s2, idx2 + 1);
		else {
			int f1 = editDistanceRS1(s1, idx1 + 1, s2, idx2 + 1); // replace
			int f2 = editDistanceRS1(s1, idx1 + 1, s2, idx2); // add
			int f3 = editDistanceRS1(s1, idx1, s2, idx2 + 1); // remove
			ans = Math.min(f1, Math.min(f2, f3)) + 1;
		}

		return ans;

	}

	// O(m*n) Time | O(m*n) + Rec space
	private static int editDistanceTD(String s1, int idx1, String s2, int idx2, int[][] strg) {
		if (idx1 == s1.length() || idx2 == s2.length())
			return Math.max(s1.length() - idx1, s2.length() - idx2);

		if (strg[idx1][idx2] != -1)
			return strg[idx1][idx2];

		int ans = 0;
		if (s1.charAt(idx1) == s2.charAt(idx2))
			ans = editDistanceTD(s1, idx1 + 1, s2, idx2 + 1, strg);
		else {
			int f1 = editDistanceTD(s1, idx1 + 1, s2, idx2 + 1, strg); // replace
			int f2 = editDistanceTD(s1, idx1 + 1, s2, idx2, strg); // add
			int f3 = editDistanceTD(s1, idx1, s2, idx2 + 1, strg); // remove
			ans = Math.min(f1, Math.min(f2, f3)) + 1;
		}
		strg[idx1][idx2] = ans;
		return ans;

	}
	
	// O(m*n) Time | O(m*n)
	private static int editDistanceBU(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {
				if (row == s1.length())
					strg[row][col] = s2.length() - col;
				else if (col == s2.length())
					strg[row][col] = s1.length() - row;
				else if (s1.charAt(row) == s2.charAt(col))
					strg[row][col] = strg[row + 1][col + 1];
				else {
					int i = strg[row + 1][col];
					int d = strg[row][col + 1];
					int r = strg[row + 1][col + 1];
					strg[row][col] = Math.min(i, Math.min(d, r)) + 1;
				}
			}
		}
		return strg[0][0];
	}

}
