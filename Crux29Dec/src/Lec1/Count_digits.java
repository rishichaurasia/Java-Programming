package Lec1;

import java.util.Scanner;

public class Count_digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int x = scn.nextInt();
		int cnt = 0;
		if(n==0) {
			cnt =1;
		}
		while(n>0) {
			if(n%10 == x) {
				cnt++;
			}
			n/=10;
		}
		System.out.println(cnt);
	}

}
