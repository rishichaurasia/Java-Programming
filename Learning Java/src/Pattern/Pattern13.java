package Pattern;

import java.util.Scanner;

public class Pattern13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		for (int i = 1, nst = 1; i < 2 * n; i++) {
			for (int j = 1; j <= nst; j++)
				System.out.print("*");
			System.out.println();
			if (i < 5)
				nst++;
			else
				nst--;
		}
	}

}
