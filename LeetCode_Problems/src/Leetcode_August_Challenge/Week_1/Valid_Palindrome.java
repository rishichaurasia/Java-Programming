package Leetcode_August_Challenge;

public class Valid_Palindrome {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));

	}

	public static boolean isPalindrome(String s) {

		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (!Character.isLetterOrDigit(s.charAt(start))) {
				start++;
			} else if (!Character.isLetterOrDigit(s.charAt(end))) {
				end--;
			} else if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
				return false;
			} else {
				start++;
				end--;
			}
		}
		return true;
	}

}
