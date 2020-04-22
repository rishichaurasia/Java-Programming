package DUCS_Assignment;

import java.util.Scanner;

public class CheckPerfectSquare {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Number : ");
		int n = scn.nextInt();
		if(checkPrefectSquare(n))
			System.out.println(n + " is a perfect square!");
		else
			System.out.println(n + " is not a perfect square!");

	}

	private static boolean checkPrefectSquare(int n) {
		double sqrt = Math.sqrt(n);
		return (sqrt - Math.floor(sqrt)) == 0;
	}
	
}
