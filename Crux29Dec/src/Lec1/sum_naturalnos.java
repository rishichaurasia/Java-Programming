package Lec1;

import java.util.Scanner;

public class sum_naturalnos {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int sum = 0, i = 1;
		while(i<=n) {
			sum += i;
			i += 1;
		}
		System.out.println("Sum = " + sum);
	}

}
