package Lec1;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a = 2;
		int factors_cnt = 0;
		while(a <= n) {
			if (n%a == 0) {
				factors_cnt += 1;
			}
			a++;
		}
		if(factors_cnt == 1) {
			System.out.println("Prime");
		} else {
			System.out.println("Not Prime");
		}

	}

}
