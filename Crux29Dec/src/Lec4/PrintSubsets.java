package Lec4;

import java.util.Scanner;

public class PrintSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		printSubsets(n);
	}
	
	public static void printSubsets(int n) {
		int digits = countDigits(n);
		for(int i = 0; i<Math.pow(2, digits); i++) {
			int bin = dec2bin(i);
			if(bin == 0) {
				System.out.println((char)981);
				continue;
			}
			int set = 0;
			for(int n1 = n, j = 0; bin>0; bin/=10, n1/=10) {
				int rem = bin%10;
				if(rem == 1) {
					int rem1 = n1%10;
					set += rem1*Math.pow(10, j);
					j++;
				}
			}
			System.out.println(set);
		}
	}
	
	public static int dec2bin(int n) {
		int ans = 0;
		for(int i = 0; n>0; n/=2, i++) {
			int rem = n%2;
			ans += rem*Math.pow(10, i);
		}
		return ans;
	}
	
	public static int countDigits(int n) {
		int i = 0;
		for (; n > 0; n /= 10) {
			i++;
		}
		return i;
	}

}
