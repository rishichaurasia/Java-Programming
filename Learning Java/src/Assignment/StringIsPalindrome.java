package Assignment;

import java.util.Scanner;

public class StringIsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Take as input S, a string. Write a function that returns true if the string
		 * is a palindrome and false otherwise. Print the value returned.
		 * 
		 * Input Format String
		 * 
		 * Constraints String length between 1 to 1000 characters
		 * 
		 * Output Format Boolean
		 * 
		 * Sample Input abba Sample Output true Explanation A string is said to be
		 * palindrome if reverse of the string is same as string. For example, “abba” is
		 * palindrome as it's reverse is "abba", but “abbc” is not palindrome as it's
		 * reverse is "cbba".
		 */

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(isPalindrome(str));

	}

	public static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) != str.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

}
