package Assignment;

import java.util.Scanner;

public class StringRemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Take as input S, a string. Write a function that removes all consecutive
		 * duplicates. Print the value returned.
		 * 
		 * Input Format String
		 * 
		 * Constraints A string of length between 1 to 1000
		 * 
		 * Output Format String
		 * 
		 * Sample Input aabccba Sample Output abcba Explanation For the given example,
		 * "aabccba", Consecutive Occurrence of a is 2, b is 1, and c is 2.
		 * 
		 * After removing all of the consecutive occurences, the Final ans will be : -
		 * "abcba".
		 */

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		removeDuplicates(str);
	}

	public static void removeDuplicates(String str) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			ans += str.charAt(i);
			while (i < str.length() - 1 && str.charAt(i + 1) == str.charAt(i))
				i++;
		}
		System.out.println(ans);
	}

}
