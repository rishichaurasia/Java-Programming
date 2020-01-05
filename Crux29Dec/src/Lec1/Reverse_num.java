package Lec1;

import java.util.Scanner;

public class Reverse_num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = 1234;
		int rev=0;
		while(n>0) {
			rev = rev*10 + n%10;
			n /= 10;
		}
		System.out.println(rev);

	}

}
