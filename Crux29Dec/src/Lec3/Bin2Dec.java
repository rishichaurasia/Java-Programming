package Lec3;

import java.util.Scanner;

public class Bin2Dec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int multiplier = 1, ans=0;
		while(n!=0) {
			int rem = n%10;
			ans = ans + rem*multiplier;
			multiplier *= 2;
			n/=10;
		}
		System.out.println(ans);
	}
}
