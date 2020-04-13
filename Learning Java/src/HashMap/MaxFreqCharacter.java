package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaxFreqCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aabbaaabcdda";
		System.out.println(getMaxFreqChar(str));
	}
	
	public static char getMaxFreqChar(String str) {
		HashMap<Character, Integer> f = new HashMap<>();
		for(int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(f.containsKey(ch)) {
				int c = f.get(ch);
				f.put(ch, c+1);
			}else {
				f.put(ch, 1);
			}
		}
		char maxchar = '\0';  // null
		int max = 0;
		Set<Map.Entry<Character, Integer>> entries = f.entrySet(); 
		for(Map.Entry<Character, Integer> entry: entries) {
			if(entry.getValue() > max) {
				max = entry.getValue();
				maxchar = entry.getKey();
			}
		}
		return maxchar;
	}

}
