package Pattern;

import java.util.Scanner;

public class FibonacciPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a = 0, b = 1;
		for(int row = 1; row<=n; row++) {
			for(int col = 1; col<=row; col++) {
				System.out.print(a + "\t");
				int sum = a+b;
				a = b;
				b = sum;
			}
			System.out.println();
		}
	}

}
