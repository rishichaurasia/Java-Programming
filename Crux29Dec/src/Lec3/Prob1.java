package Lec3;

import java.util.Scanner;

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		char n = scn.next().charAt(0);
		if(n>='a' && n<='z') {
			System.out.println("Lowercase");
		}else if(n>='A' && n<='Z'){
			System.out.println("Uppercase");
		}else {
			System.out.println("Invalid");
		}
	}

}
