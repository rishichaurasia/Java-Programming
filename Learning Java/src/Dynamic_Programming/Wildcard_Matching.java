package Dynamic_Programming;

public class Wildcard_Matching {

	public static void main(String[] args) {
		String s = "adceb";
		String p = "*a*b";
//		System.out.println(isMatchRS(s, p, 0, 0));
		
//		System.out.println(isMatchTD(s, p, 0, 0, new int[s.length()][p.length()]));
		
		System.out.println(isMatchBU(s, p));
	}

	public static boolean isMatchRS(String s, String p, int sidx, int pidx) {

		if (sidx == s.length()) {
			if (pidx == p.length())
				return true;
			else {
				while (pidx < p.length()) {
					if (p.charAt(pidx) != '*')
						return false;
					++pidx;
				}
				return true;
			}
		}

		if (pidx == p.length())
			return false;

		char schar = s.charAt(sidx);
		char pchar = p.charAt(pidx);

		boolean ans;

		if (pchar == '?' || schar == pchar)
			ans = isMatchRS(s, p, sidx + 1, pidx + 1);
		else if (pchar == '*')
			ans = isMatchRS(s, p, sidx, pidx + 1) || isMatchRS(s, p, sidx + 1, pidx);
		else
			ans = false;

		return ans;

	}

	public static boolean isMatchTD(String s, String p, int sidx, int pidx, int[][] strg) {

		if (sidx == s.length()) {
			if (pidx == p.length())
				return true;
			else {
				while (pidx < p.length()) {
					if (p.charAt(pidx) != '*')
						return false;
					++pidx;
				}
				return true;
			}
		}

		if (pidx == p.length())
			return false;

		if (strg[sidx][pidx] != 0)
			return strg[sidx][pidx] == 1;

		char schar = s.charAt(sidx);
		char pchar = p.charAt(pidx);

		boolean ans;

		if (pchar == '?' || schar == pchar)
			ans = isMatchTD(s, p, sidx + 1, pidx + 1, strg);
		else if (pchar == '*')
			ans = isMatchTD(s, p, sidx, pidx + 1, strg) || isMatchTD(s, p, sidx + 1, pidx, strg);
		else
			ans = false;

		strg[sidx][pidx] = ans ? 1 : -1;

		return ans;

	}
	
	public static boolean isMatchBU(String s, String p) {
		
		boolean[][] strg = new boolean[s.length()+1][p.length()+1];
		
		strg[s.length()][p.length()] = true;
		
		for(int sidx = s.length(); sidx>=0; sidx--) {
			
			for(int pidx = p.length()-1; pidx>=0; pidx--) {
				
				if(sidx == s.length()) {
					strg[sidx][pidx] = strg[sidx][pidx+1] && p.charAt(pidx) == '*';
				}else {
					
					char schar = s.charAt(sidx);
					char pchar = p.charAt(pidx);
					
					boolean ans;
					
					if(schar == pchar || pchar == '?')
						ans = strg[sidx+1][pidx+1];
					else if(pchar == '*')
						ans = strg[sidx][pidx+1] || strg[sidx+1][pidx];
					else
						ans = false;
					
					strg[sidx][pidx] = ans;
					
				}
				
			}
		}
		
		return strg[0][0];
		
	}

}
