package Lec4;

import java.util.Scanner;

public class printTosses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int i = 0; i<=Math.pow(2, n)-1; i++) {
			int bin = dec2bin(i);
			printTosses(bin, n);
		}
		
	}
	
	public static void printTosses(int bin, int n) {
		String toss = "";
		for(int i = 1; i<=n; i++, bin/=10) {
			int rem = bin%10;
			if(rem==0)
				toss = "H" + toss;
			else
				toss = "T" + toss;
		}
		System.out.println(toss);
	}
	
	public static int dec2bin(int n) {
		int ans = 0;
		for(int i = 0; n>0; n/=2, i++) {
			int rem = n%2;
			ans += rem*Math.pow(10, i);
		}
		return ans;
	}

}
