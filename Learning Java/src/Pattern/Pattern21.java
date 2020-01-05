package Pattern;

import java.util.Scanner;

public class Pattern21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 1, nsp = 2 * n - 3; i <= n; i++, nsp -= 2) {
			for (int j = 1; j <= i; j++)
				System.out.print("*");
			for (int j = 1; j <= nsp; j++)
				System.out.print(" ");
			int j = 1;
			if (i == n)
				j = 2;
			for (; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
	}

}
