package Memoization;

public class Interleaving_String {
	
	public static void main(String[] args) {
		String s1 = "aaa"; // length m
		String s2 = "faaa"; // length n
		String s3 = "aaafaaa";
		System.out.println(isInterleave(s1, s2, s3));
	}
	
	public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length())
            return false;
//        return isInterleave(s1,s2,s3,0,0);
        return isInterleave(s1,s2,s3,0,0, new int[s1.length()][s2.length()]);
    }
    
	// Recursion O(2^(m+n)) Time | O(1) space
    public static boolean isInterleave(String s1, String s2, String s3, int idx1, int idx2) {
        int idx3 = idx1+idx2;
        if(idx3 == s3.length()){
            return true;
        }
        char ch = s3.charAt(idx3);
        if(idx1 < s1.length() && s1.charAt(idx1) == ch){
            if(isInterleave(s1, s2, s3, idx1+1, idx2))
                return true;
        }
        if(idx2 < s2.length() && s2.charAt(idx2) == ch){
            return isInterleave(s1, s2, s3, idx1, idx2+1);
        }
        return false;
    }
    
    // Memoization O(m*n) Time | O(m*n) space
    public static boolean isInterleave(String s1, String s2, String s3, int idx1, int idx2, int[][] strg) {
    	int idx3 = idx1+idx2;
    	
    	if(idx1 == s1.length())
        	return s2.substring(idx2).equals(s3.substring(idx3));
    	
    	if(idx2 == s2.length())
        	return s1.substring(idx1).equals(s3.substring(idx3));
        
        if(strg[idx1][idx2] != 0)
        	return strg[idx1][idx2] == 1 ? true : false;
        
        char ch = s3.charAt(idx3);
        
        boolean ans;
        ans = (s1.charAt(idx1) == ch && isInterleave(s1, s2, s3, idx1+1, idx2, strg))
        		|| (s2.charAt(idx2) == ch && isInterleave(s1, s2, s3, idx1, idx2+1, strg));
        
        strg[idx1][idx2] = ans ? 1 : -1;
        return ans;
    }
	
}
