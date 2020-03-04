package DUCS_Assignment;

import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		printPattern(n);
	}
	
	public static void printPattern(int n) {
		for(int i = 1; i<=2*n-1; i++) {
			for(int j = 1; j<=2*n-1; j++) {
				if(i == j || i+j==2*n) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
