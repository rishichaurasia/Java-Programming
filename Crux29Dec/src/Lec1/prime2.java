package Lec1;

import java.util.Scanner;

public class prime2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		if(n==2) {
			System.out.println("Prime");
		}else if(n==1 || n%2==0) {
			System.out.println("Not Prime");
		}else {
			int div = 3,flag=1;
			while(div<=Math.sqrt(n)) {
				if(n%div==0) {
					System.out.println("Not Prime");
					flag = 2;
				}
				div += 2;
			}
			if(flag==1) {
				System.out.println("Prime");
			}
		}
	}

}
