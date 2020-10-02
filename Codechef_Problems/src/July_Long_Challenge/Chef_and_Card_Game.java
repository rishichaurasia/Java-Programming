package July_Long_Challenge;

import java.util.Scanner;

public class Chef_and_Card_Game {

	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		int t = scn.nextInt();
		while(t-- > 0) {
			int n = scn.nextInt();
			int pointA = 0;
			int pointB = 0;
			while(n-- > 0) {
				int a = digitSum(scn.nextInt());
				int b = digitSum(scn.nextInt());
				if(a > b)
					++pointA;
				else if(b > a)
					++pointB;
				else {
					++pointA;
					++pointB;
				}
			}
			if(pointA > pointB)
				System.out.println(0 + " " + pointA);
			else if(pointB > pointA)
				System.out.println(1 + " " + pointB);
			else
				System.out.println(2 + " " + pointB);
		}

	}
	
	public static int digitSum(int n) {
		int sum = 0;
		while(n>0) {
			sum += n%10;
			n/=10;
		}
		return sum;
	}
}
