package Dynamic_Programming;

public class LCS_with_3_strings {

	public static void main(String[] args) {
		String s1 = "GHQWNV";
		String s2 = "SJNSDGH";
		String s3 = "CPGMAH";
		
		System.out.println(LCSBU(s1, s2, s3));

	}
	
	public static int LCSBU(String s1, String s2, String s3){
		
		int[][][] strg = new int[s1.length()+1][s2.length()+1][s3.length()+1];
		
		for(int i = s1.length()-1; i>=0; --i) {
			for(int j = s2.length()-1; j>=0; --j) {
				for(int k = s3.length()-1; k>=0; --k) {
					if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
						strg[i][j][k] = strg[i+1][j+1][k+1] + 1;
					}else {
						strg[i][j][k] = Math.max(strg[i+1][j][k], Math.max(strg[i][j+1][k], strg[i][j][k+1]));
					}
				}
			}
		}
		
		return strg[0][0][0];
		
	}

}
