package August_Long_Challenge;

import java.util.Scanner;

public class Smallest_KMP {

	static Scanner scn = new Scanner(System.in);

	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws java.lang.Exception {
		int t = scn.nextInt();
		scn.nextLine();
		while (t-- > 0) {
			solve();
		}
		System.out.println(result);
		
	}

	public static void solve() {

		String s = scn.next();
		String p = scn.next();
		
		int[] freq = new int[26];
		
		for(char ch: s.toCharArray()) {
			freq[ch - 'a']++;
		}
		
		for(char ch: p.toCharArray()) {
			freq[ch - 'a']--;
		}
		
		int i;
		
		for( i = 0; i<p.charAt(0) - 'a'; i++) {
			char ch = (char)('a' + i);
			for(int j = 1; j<=freq[i]; j++) {
				result.append(ch);
			}
		}
		
		if(freq[i] == 0)
			result.append(p);
		else {
			
			StringBuilder sb = new StringBuilder();
			char ch = (char)('a' + i);
			for(int j = 1; j<=freq[i]; j++) {
				sb.append(ch);
			}
			
			StringBuilder s1 = new StringBuilder(sb).append(p);
			StringBuilder s2 = new StringBuilder(p).append(sb);
			
			if(s1.compareTo(s2) < 0)
				result.append(s1);
			else
				result.append(s2);
		}
		
		i++;
		for(; i<26; i++) {
			for(int j = 1; j<=freq[i]; j++) {
				result.append((char)('a' + i));
			}
		}
		
		result.append("\n");
	}

}
