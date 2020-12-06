package String;

public class Rabin_Karp_String_Matching {

	public static void main(String[] args) {
		String str = "ccaccaaedba";
		String pat = "dba";
		int idx = patternSearch(str,pat);
		System.out.println(idx);
	}
	
	static final int prime = 101;

	private static int patternSearch(String str, String pat) {
		int n = str.length();
		int m = pat.length();
		long patternHash = generateHash(pat, m);
		long textHash = generateHash(str, m);
		
		for(int i = 0; i+m-1<n; i++) {
			if(patternHash == textHash && isEqual(str,i,pat,m))
				return i;
			if(i+m<n)
				textHash = rerollHash(str,i,textHash,m);
		}
		
		return -1;
		
	}

	private static long rerollHash(String str, int oldIdx, long oldHash, int m) {
		return (oldHash - str.charAt(oldIdx))/prime + str.charAt(oldIdx+m) * (long)Math.pow(prime, m-1);
	}

	private static long generateHash(String str, int m) {
		long hash = 0;
		for(int i = 0; i<m; i++) {
			hash += str.charAt(i) * Math.pow(prime, i);
		}
		return hash;
	}
	
	private static boolean isEqual(String str, int sidx, String pat, int m) {
		
		for(int i = 0; i<m; i++) {
			if(str.charAt(sidx+i) != pat.charAt(i))
				return false;
		}
		
		return true;
		
	}

}
