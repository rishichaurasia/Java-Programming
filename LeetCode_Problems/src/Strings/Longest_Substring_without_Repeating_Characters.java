package Strings;

public class Longest_Substring_without_Repeating_Characters {

	public static void main(String[] args) {
		
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s));

	}

	public static int lengthOfLongestSubstring(String s) {

		if (s == null || s.length() == 0)
			return 0;
		int[] count = new int[128];
		int max = 0;
		int start = 0;
		int cur = 0;
		while (cur < s.length() && start < s.length()) {
			if (count[s.charAt(cur)] == 0) {
				count[s.charAt(cur)]++;
				cur++;
				max = Math.max(max, cur - start);
			} else {
				count[s.charAt(start)]--;
				start++;
			}
		}
		return max;

	}

}
