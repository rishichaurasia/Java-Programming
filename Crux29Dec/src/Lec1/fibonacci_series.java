package Lec1;

import java.util.Scanner;

public class fibonacci_series {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a = 0;
		int b = 1;
		int cnt = 0;
		int temp;
		while (cnt <= n) {
			System.out.println(a);
			temp = a;
			a = b;
			b = temp + b;
			cnt += 1;
		}

	}

}
