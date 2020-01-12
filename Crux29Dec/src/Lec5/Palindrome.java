package Lec5;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int[] arr = { 12, 34, 23, 34, 12 };
		System.out.println(checkPalindrome(arr));
	}
	
	public static boolean checkPalindrome(int[] arr) {
		for(int i = 0; i<=arr.length/2; i++) {
			if(arr[i] != arr[arr.length-i-1])
				return false;
		}
		return true;
	}

}
