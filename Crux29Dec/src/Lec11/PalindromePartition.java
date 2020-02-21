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
		if(ques.length()==0) {
			System.out.println(ans + " ");
			return;
		}
		for(int i = 0; i<ques.length(); i++) {
			String s = ques.substring(0,i+1);
			String roq = ques.substring(i+1);
			if(isPalindrome(s))
				palindromicPartition(roq, ans + s + " ");
		}
		
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
