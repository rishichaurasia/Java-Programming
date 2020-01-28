package Assignment;

import java.util.Scanner;

public class StringToggleCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Take as input S, a string. Write a function that toggles the case of all
		 * characters in the string. Print the value returned.
		 * 
		 * Input Format String
		 * 
		 * Constraints Length of string should be between 1 to 1000.
		 * 
		 * Output Format String
		 * 
		 * Sample Input abC Sample Output ABc Explanation Toggle Case means to change
		 * UpperCase character to LowerCase character and vice-versa.
		 */

		Scanner scn = new Scanner(System.in);
		StringBuffer str = new StringBuffer(scn.next());
		toggleCase(str);
		System.out.println(str);
	}

	public static void toggleCase(StringBuffer str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 'a' && c <= 'z')
				c -= 32;
			else if (c >= 'A' && c <= 'Z')
				c += 32;
			str.setCharAt(i, c);
		}
	}

}
