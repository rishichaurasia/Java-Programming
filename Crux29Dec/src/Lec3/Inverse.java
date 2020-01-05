package Lec3;

import java.util.Scanner;

public class Inverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int pos = 1;
		int ans = 0;
		while(n>0) {
			int rem = n%10;
			ans = ans + pos * (int) Math.pow(10, rem-1);
			
			pos++;
			n/=10;
		}
		System.out.println(ans);
	}

}
