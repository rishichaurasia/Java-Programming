package Lec1;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		int i = x;
		while(i>0) {
			int j=1;
			while(j<=5-i) {
				System.out.print(" ");
				j++;
			}
			j=1;
			while(j<2*i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i--;
		}
	}

}
