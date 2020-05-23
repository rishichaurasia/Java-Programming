package Backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

public class Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {

	public static void main(String[] args) {
		List<String> arr = new ArrayList<>();
		arr.add("cha");
		arr.add("r");
		arr.add("act");
		arr.add("ers");
		System.out.println(maxLength(arr));
	}
	
	static int maxLen;
	
	public static int maxLength(List<String> arr) {
        maxLen = 0;
		maxLength(arr, 0, "");
        return maxLen;
    }
	
	public static void maxLength(List<String> arr, int idx, String ans) {
		if(isDistinct(ans)) {
			if(maxLen < ans.length())
				maxLen = ans.length();
		}
		else
			return;
		for(int i = idx; i<arr.size(); i++) {
			maxLength(arr, i+1, ans+arr.get(i));
		}
	}
	
//	// To display all subsequences
//	public static void maxLength(List<String> arr, int idx, String ans) {
//		if(isDistinct(ans))
//			System.out.println(ans);
//		else
//			return;
//		for(int i = idx; i<arr.size(); i++) {
//			maxLength(arr, i+1, ans+arr.get(i));
//		}
//	}
	
	public static boolean isDistinct(String str) {
		int[] freq = new int[26];
		for(int i = 0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(freq[ch - 'a'] > 0)
				return false;
			freq[ch-'a']++;
		}
		return true;
	}
	
	

}
