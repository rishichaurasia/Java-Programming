package BitManipulation;

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
		int n = 1;
		for(int i = 1; i<=N; i++) {
			if((i&1) == 1) {
				for(int j = 1; j<=N; j++)
					System.out.print(n++ + " ");
			}else {
				for(int j = n+N-1; j>=n; j--)
					System.out.print(j+" ");
				n+=N;
			}
			System.out.println();
		}
	}

}
