package Pattern;

import java.util.Scanner;

public class Pattern18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 1, nst = 1, nsp = n / 2; i <= n; i++) {
			for (int j = 1; j <= nsp; j++)
				System.out.print(" ");
			for (int j = 1; j <= nst; j++)
				System.out.print("*");
			if (i <= n / 2) {
				nst += 2;
				nsp--;
			} else {
				nst -= 2;
				nsp++;
			}
			System.out.println();

		}

	}

}
