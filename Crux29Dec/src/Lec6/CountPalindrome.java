package Lec6;

import java.util.Scanner;

public class CountPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		countPalindrome(str);

	}

	public static void countPalindrome(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			String temp = "";
			for (int j = i; j < str.length(); j++) {
				temp += str.charAt(j);
				if (checkPalindrome(temp))
					count++;

			}
		}
		System.out.println(count);
	}

	public static boolean checkPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
