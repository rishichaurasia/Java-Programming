package Dynamic_Programming;

import java.util.Arrays;

public class Longest_Common_SubSequence {
	public static void main(String[] args) {
		String str1 = "abbg";
		String str2 = "agbg";
		System.out.println(LCS(str1, 0, str2, 0));
		System.out.println(LCSTD(str1, 0, str2, 0, new int[str1.length()][str2.length()]));
		System.out.println(LCSBU(str1, str2));
		System.out.println(LCSBUSE(str1, str2));
	}
	
	// TC: 2^(str1.length+str2.length)	SC: Rec. extra space
	public static int LCS(String str1, int idx1, String str2, int idx2) {
		if(idx1 == str1.length() || idx2 == str2.length())
			return 0;
		int count = 0;
		if(str1.charAt(idx1) == str2.charAt(idx2)) {
			count = 1 + LCS(str1, idx1+1, str2, idx2+1);
		}else {
			count = Math.max(LCS(str1, idx1+1, str2, idx2), LCS(str1, idx1, str2, idx2+1));
		}
		return count;
	}
	
//	TC: O(str1.length * str2.length)	SC: O(str1.length * str2.length) + rec. extra space
	public static int LCSTD(String str1, int idx1, String str2, int idx2, int[][] strg) {
		if(idx1 == str1.length() || idx2 == str2.length())
			return 0;
		if(strg[idx1][idx2] != 0)
			return strg[idx1][idx2];
		int count = 0;
		if(str1.charAt(idx1) == str2.charAt(idx2)) {
			count = 1 + LCSTD(str1, idx1+1, str2, idx2+1, strg);
		}else {
			count = Math.max(LCSTD(str1, idx1+1, str2, idx2, strg), LCSTD(str1, idx1, str2, idx2+1, strg));
		}
		strg[idx1][idx2] = count;
		return count;
	}
	
	// TC: O(str1.length * str2.length)	 SC: O(str1.length * str2.length)
	public static int LCSBU(String str1, String str2) {
		int[][] strg = new int[str1.length()+1][str2.length()+1];
		Arrays.fill(strg[str1.length()], 0);
		for(int row = str1.length()-1; row>=0; row--) {
			strg[row][str2.length()] = 0;
			for(int col = str2.length()-1; col>=0; col--) {
				if(str1.charAt(row) == str2.charAt(col))
					strg[row][col] = strg[row+1][col+1] + 1;
				else
					strg[row][col] = Math.max(strg[row+1][col], strg[row][col+1]);
			}
		}
		return strg[0][0];
	}
	
	// TC: O(str1.length * str2.length)	 SC: O(str2.length)
	public static int LCSBUSE(String str1, String str2) {
		int[] strg = new int[str2.length()+1];
		Arrays.fill(strg, 0);
		for(int row = str1.length()-1; row>=0; row--) {
			int diag = strg[str2.length()];
			for(int col = str2.length()-1; col>=0; col--) {
				int temp = strg[col];
				if(str1.charAt(row) == str2.charAt(col))
					strg[col] = diag + 1;
				else
					strg[col] = Math.max(strg[col], strg[col+1]);
				diag = temp;
			}
		}
		return strg[0];
	}

}
