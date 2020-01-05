package Lec2;

import java.util.Scanner;

public class pattern7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for(int row =1; row<=n; row++) {
			for(int i = 1; i<=n; i++) {
				if(row == 1 || row==n || i==1 || i==n) {
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
