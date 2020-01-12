package Lec5;

import java.util.Scanner;

public class PrintTossOutcomes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		printTossOutcomes(n);
	}
	
	public static void printTossOutcomes(int n) {
		int limit =(int) Math.pow(2, n);
		for(int i = 0; i<limit; i++) {
			int temp = i;
			for(int j = 0; j<n; j++) {
				int rem = temp%2;
				if(rem == 1)
					System.out.print("T");
				else
					System.out.print("H");
				temp/=2;
			}
			System.out.println();
		}
	}

}
