package String;

public class KMP_String_Matching {

	public static void main(String[] args) {
		String str = "aaaaaaaaad";
		String pat = "aad";
		int idx = KMP(str,pat);
		System.out.println(idx);
	}

	private static int KMP(String str, String pat) {
		int n = str.length();
		int m = pat.length();
		int[] lps = new int[pat.length()];
		computeLPS(pat, lps, m);
		int i = 0, j = 0;
		while(i < n) {
			if(str.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
			}else {
				if(j != 0)
					j = lps[j-1];
				else
					i++;
			}
			if(j == m)
				return i-j;
		}
		return -1;
	}

	private static void computeLPS(String pat, int[] lps, int m) {
		
		int i = 0;
		int j = 1;
		while(j < m) {
			if(pat.charAt(i) == pat.charAt(j)) {
				lps[j] = i+1;
				i++;
				j++;
			}else {
				if(i == 0) {
					j++;
				}else {
					i = lps[i-1];
				}
			}
		}
	}

}
