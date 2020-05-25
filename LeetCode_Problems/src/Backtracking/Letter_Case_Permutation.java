package Backtracking;

import java.util.ArrayList;

// https://leetcode.com/problems/letter-case-permutation/

import java.util.List;

public class Letter_Case_Permutation {

	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a1B2"));
//		System.out.println(letterCasePermutation2("a1B2"));

	}
	
	public static List<String> letterCasePermutation(String S) {
        if(S.length() == 0) {
        	List<String> br = new ArrayList<String>();
        	br.add("");
        	return br;
        }
		char ch = S.charAt(0);
        String ros = S.substring(1);
        List<String> rr = letterCasePermutation(ros);
        List<String> mr = new ArrayList<String>();
        for(String str: rr) {
        	if(Character.isAlphabetic(ch)) {
	        	mr.add(Character.toLowerCase(ch)+str);
	        	mr.add(Character.toUpperCase(ch) + str);
        	}else {
        		mr.add(ch+str);
        	}
        }
        return mr;
    }
	
	public static List<String> letterCasePermutation2(String S) {

		List<String> main = new ArrayList<String>();

		letterCasePermutation2(S, 0, "", main);

		return main;
	}

	public static void letterCasePermutation2(String ques, int idx, String ans, List<String> main) {

		if (ques.length() == idx) {
			main.add(ans);
			return;
		}

		char ch = ques.charAt(idx);

		if (Character.isDigit(ch)) {
			letterCasePermutation2(ques, idx + 1, ans + ch, main);
		} else {
			letterCasePermutation2(ques, idx + 1, ans + Character.toLowerCase(ch), main);
			letterCasePermutation2(ques, idx + 1, ans + Character.toUpperCase(ch), main);
		}

	}

}
