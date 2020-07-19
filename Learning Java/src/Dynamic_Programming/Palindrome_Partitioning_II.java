package Dynamic_Programming;

import java.util.Arrays;

public class Palindrome_Partitioning_II {

	public static void main(String[] args) {
		String s = "abacdce";
		System.out.println(minCutRS(s, 0, s.length()-1));
		
		int[][] strg = new int[s.length()][s.length()];
		for(int[] arr: strg)
			Arrays.fill(arr, -1);
		System.out.println(minCutTD(s, 0, s.length()-1, strg));
		
		System.out.println(minCutBU(s));
		
		System.out.println(minCutBUEff(s));
		
		System.out.println(minCutBUMoreEff(s));
	}
	
	public static int minCutRS(String s, int si, int ei) {
		
		int min = ei-si;
		
		if(isPalindrome(s, si, ei))
			min = 0;
		else {
			for(int i = si; i<ei; ++i) {
				int fp = minCutRS(s, si, i);
				int sp = minCutRS(s, i+1, ei);
				
				int totalCuts = fp+sp+1;
				
				min = Math.min(min, totalCuts);
			}
		}
		return min;
	}
	
	public static boolean isPalindrome(String s, int si, int ei) {
		while(si < ei) {
			if(s.charAt(si) != s.charAt(ei))
				return false;
			++si; --ei;
		}
		return true;
	}
	
	public static int minCutTD(String s, int si, int ei, int[][] strg) {
		
		if(strg[si][ei] != -1)
			return strg[si][ei];
		
		int min = ei-si;
		
		if(isPalindrome(s, si, ei))
			min = 0;
		else {
			for(int i = si; i<ei; ++i) {
				int fp = minCutTD(s, si, i, strg);
				int sp = minCutTD(s, i+1, ei, strg);
				
				int totalCuts = fp+sp+1;
				
				min = Math.min(min, totalCuts);
			}
		}
		
		strg[si][ei] = min;
		return min;
	}
	
	public static int minCutBU(String s) {
		int n = s.length();
		int[][] strg = new int[n][n];
		
		boolean[][] isStringPalindrome = palindromeInfo(s);
		
		for(int slide = 0; slide<n; ++slide) {
			for(int si = 0; si <= n-slide-1; ++si) {
				int ei = si+slide;
				
				int min = ei-si;
				
				if(isStringPalindrome[si][ei])
					min = 0;
				else {
					for(int i = si; i<ei; ++i) {
						int fp = strg[si][i];
						int sp = strg[i+1][ei];
						
						int totalCuts = fp+sp+1;
						
						min = Math.min(min, totalCuts);
					}
				}
				
				strg[si][ei] = min;
			}
		}
		
		return strg[0][s.length()-1];
	}
	
	public static boolean[][] palindromeInfo(String s){
		
		int n = s.length();
		boolean[][] isStringPalindrome =  new boolean[n][n];
		
		for(boolean[] i: isStringPalindrome)
			Arrays.fill(i, true);
		
		for(int i = n-1; i>=0; --i) {
			for(int j = i+1; j<n; ++j) {
				isStringPalindrome[i][j] = isStringPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j);
			}
		}
		
		return isStringPalindrome;
	}
	
	public static int minCutBUEff(String s) {
		int n = s.length();
		int[][] strg = new int[n][n];
		
		for(int slide = 1; slide<n; ++slide) {
			for(int si = 0; si <= n-slide-1; ++si) {
				int ei = si+slide;
				
				int min = ei-si;
				
				if(strg[si+1][ei-1] == 0 && s.charAt(si) == s.charAt(ei))
					min = 0;
				else {
					for(int i = si; i<ei; ++i) {
						int fp = strg[si][i];
						int sp = strg[i+1][ei];
						
						int totalCuts = fp+sp+1;
						
						min = Math.min(min, totalCuts);
					}
				}
				
				strg[si][ei] = min;
			}
		}
		
		return strg[0][s.length()-1];
	}
	
	public static int minCutBUMoreEff(String s) {
		int n = s.length();
		int[] strg = new int[n];
		
		boolean[][] isStringPalindrome = palindromeInfo(s);
		
		for(int i = 0; i<n; ++i) {
			if(isStringPalindrome[0][i]) {
				strg[i] = 0;
				continue;
			}
			
			int ans = Integer.MAX_VALUE;
			
			for(int j = 0; j<i; ++j) {
				if(isStringPalindrome[j+1][i]) {
					int partitions = strg[j] + 1;
					ans = Math.min(ans, partitions);
				}
			}
			
			strg[i] = ans;
		}
		
		return strg[n-1];
	}

}
