package June_Challenge_2020;

import java.util.Scanner;

public class Even_Matrix {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0) {
			int N = scn.nextInt();
			printMatrix(N);
		}

	}
	
	public static void printMatrix(int N) {
		int currentCell = 1;
        StringBuilder output = new StringBuilder("");
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                output.append(currentCell).append(" ");
                if (i % 2 == 0)
                    currentCell--;
                else
                    currentCell++;
            }
            output.append("\n");
            if (i % 2 == 0)
                currentCell = currentCell + (N + 1);
            else
                currentCell = currentCell + (N - 1);
        }
        System.out.println(output);
	}

}
