package Leetcode_August_Challenge.Week_3;

import java.util.HashSet;
import java.util.Set;

public class Goat_Latin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String toGoatLatin(String S) {
		String[] words = S.split(" ");
		StringBuilder sb = new StringBuilder();
		StringBuilder add_a = new StringBuilder("a");
		for(int i = 0; i<words.length; i++) {
			sb.append(convert(words[i])).append(add_a);
			add_a.append('a');
			if(i<words.length-1)
				sb.append(" ");
		}
		return sb.toString();
	}
	
	private static String convert(String word) {
		
		char fch = Character.toLowerCase(word.charAt(0));
		if(fch == 'a' || fch == 'e' || fch == 'i' || fch == 'o' || fch == 'u') {
			return word + "ma";
		}else {
			return word.substring(1) + word.charAt(0) + "ma";
		}
	}
	
	public static String toGoatLatin1(String S) {
        Set<Character> hs = new HashSet<>();
        for (char x : "aeiouAEIOU".toCharArray()) {
            hs.add(x);
        }
        String[] words = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (hs.contains(words[i].charAt(0))) {
                sb.append(words[i]);
            }
            else{
                sb.append(words[i].substring(1, words[i].length()));
                sb.append(words[i].charAt(0));
            }
            sb.append("ma");
            for (int j = 0; j <= i; j++) {
                sb.append("a");
            }
            sb.append(" ");
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 1);
        return sb.toString();
    }

}
