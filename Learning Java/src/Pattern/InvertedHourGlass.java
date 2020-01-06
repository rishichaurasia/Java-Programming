package Pattern;

import java.util.Scanner;

public class InvertedHourGlass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take N as input. For a value of N=5, we wish to draw the following pattern :
//
//            5                   5 
//            5 4               4 5 
//            5 4 3           3 4 5 
//            5 4 3 2       2 3 4 5 
//            5 4 3 2 1   1 2 3 4 5 
//            5 4 3 2 1 0 1 2 3 4 5 
//            5 4 3 2 1   1 2 3 4 5 
//            5 4 3 2       2 3 4 5 
//            5 4 3           3 4 5 
//            5 4               4 5 
//            5                   5 

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int val = n;
		for (int i = 1; i <= 2 * n + 1; i++) {
			int val1 = n;
			for (int j = 1; j <= 2 * n + 1; j++) {
				if (val1 >= val)
					System.out.print(val1 + " ");
				else
					System.out.print("  ");
				if (j <= n)
					val1--;
				else
					val1++;

			}
			if (i <= n)
				val--;
			else
				val++;
			System.out.println();
		}

	}

}
