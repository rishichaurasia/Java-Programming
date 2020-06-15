package June_Challenge_2020;

import java.util.Scanner;

public class Covid_Sampling {
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		int T = scn.nextInt();
		while(T-- > 0) {
			int N = scn.nextInt();
			int P = scn.nextInt();
			int[][] arr = new int[N][N];
			askQuery(1, 1, N, N, arr);
			System.out.println(2);
			printArray(arr);
			int output = scn.nextInt();
			if(output == -1)
				break;
		}

	}

	private static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	private static int askQuery(int r1, int c1, int r2, int c2, int[][] arr) {
		if(r1 > r2 || c1 > c2)
			return 0;
		System.out.println(1 + " " + r1 + " " + c1 + " " + r2 + " " + c2);
		int res = scn.nextInt();
		if(res == 0)
			return 0;
		if(r1 == r2 && c1 == c2 && res == 1) {
			arr[r1-1][c1-1] = 1;
			return 1;
		}
		int r = (r1+r2)/2;
		int c = (c1+c2)/2;
		int count = 0;
		count += askQuery(r1, c1, r, c, arr);
		if(count < res) {
			count += askQuery(r1, c+1, r, c2, arr);
			if(count < res) {
				count += askQuery(r+1, c1, r2, c, arr);
				if(count < res)
					count += askQuery(r+1, c+1, r2, c2, arr);
			}
		}
		return res;
	}
	
	

}
