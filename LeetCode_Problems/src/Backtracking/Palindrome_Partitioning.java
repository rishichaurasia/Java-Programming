package Backtracking;

import java.util.ArrayList;

// https://leetcode.com/problems/palindrome-partitioning/
//123
import java.util.List;

public class Palindrome_Partitioning {

	public static void main(String[] args) {
		String s = "aab";
		System.out.println(partition(s));

	}
	
	public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
		partition(s, 0, list, new ArrayList<String>());
		return list;
    }
	
	public static void partition(String s, int idx, List main, List temp) {
		if(s.length() == idx) {
			main.add(new ArrayList<>(temp));
			return;
		}
		for(int i = idx; i<s.length(); i++) {
			if(isPalindrome(s, idx, i)) {
                String part = s.substring(idx, i+1);
				temp.add(part);
				partition(s, i+1, main, temp);
				temp.remove(temp.size()-1);
			}
		}
	}
	
	public static boolean isPalindrome(String s, int start, int end) {
		while(start<end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
		return true;
	}

}
