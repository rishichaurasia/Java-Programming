package Lec11;

import java.util.Scanner;

public class PalindromePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn = new Scanner(System.in);
//		String str = scn.next();
		palindromicPartition("nitin","");
	}
	
	public static void palindromicPartition(String ques, String ans) {
		if(isPalindrome(ans)) {
			System.out.print(ans + " ");
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		palindromicPartition(roq, ans+ch);
		
		
	}
	
	public static boolean isPalindrome(String s) {
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
