package Dynamic_Programming;

public class Longest_Palindromic_Subsequence {

	public static void main(String[] args) {
		
		String s = "bbbab";
//		System.out.println(longestPalindromeSubseq(s, 0, s.length()-1));
//		System.out.println(longestPalindromeSubseqTD(s, 0, s.length()-1, new int[s.length()][s.length()]));
		System.out.println(longestPalindromeSubseqBU(s));
	}
	
	public static int longestPalindromeSubseq(String s, int lidx, int ridx) {
        
		if(lidx == ridx)
			return 1;
		
		if(lidx > ridx)
			return 0;
		
		int ans;
		
		if(s.charAt(lidx) == s.charAt(ridx))
			ans = longestPalindromeSubseq(s, lidx+1, ridx-1) + 2;
		else {
			int ans1 = longestPalindromeSubseq(s, lidx+1, ridx);
			int ans2 = longestPalindromeSubseq(s, lidx, ridx-1);
			
			ans = Math.max(ans1, ans2);
		}
		
		return ans;
		
    }
	
	public static int longestPalindromeSubseqTD(String s, int lidx, int ridx, int[][] strg) {
        
		if(lidx == ridx)
			return 1;
		
		if(lidx > ridx)
			return 0;
		
		if(strg[lidx][ridx] != 0)
			return strg[lidx][ridx];
		
		int ans;
		
		if(s.charAt(lidx) == s.charAt(ridx))
			ans = longestPalindromeSubseq(s, lidx+1, ridx-1) + 2;
		else {
			int ans1 = longestPalindromeSubseqTD(s, lidx+1, ridx, strg);
			int ans2 = longestPalindromeSubseqTD(s, lidx, ridx-1, strg);
			
			ans = Math.max(ans1, ans2);
		}
		
		strg[lidx][ridx] = ans;
		
		return ans;
		
    }
	
	public static int longestPalindromeSubseqBU(String s) {
		
		int n = s.length();
		int[][] strg = new int[n][n];
		
		for(int i = n-1; i>=0; --i) {
			
			strg[i][i] = 1;
			
			for(int j = i+1; j<n; ++j) {
					
				int ans;
				
				if(s.charAt(i) == s.charAt(j))
					ans = strg[i+1][j-1] + 2;
				else {
					int ans1 = strg[i+1][j];
					int ans2 = strg[i][j-1];
					
					ans = Math.max(ans1, ans2);
				}
				
				strg[i][j] = ans;
					
			}
			
		}
		
		return strg[0][n-1];
		
	}

}
