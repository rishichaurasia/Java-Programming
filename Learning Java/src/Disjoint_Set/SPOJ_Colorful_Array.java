package Disjoint_Set;

import java.util.Scanner;

public class SPOJ_Colorful_Array {

	public static void main(String[] args) throws java.lang.Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int q = scn.nextInt();

		int[][] queries = new int[q][3];
		for(int i = 0; i<q; i++) {
			queries[i][0] = scn.nextInt();
			queries[i][1] = scn.nextInt();
			queries[i][2] = scn.nextInt();
		}

		int[] arr = new int[n];

		int[] parent = new int[n+1];
		for (int i = 0; i <= n; i++)
			parent[i] = i;

		for (int i = q - 1; i >= 0; i--) {
			int l = queries[i][0] - 1;
			int r = queries[i][1] - 1;
			int c = queries[i][2];

			int index = getParent(parent, l);
			
			while (index <= r) {
				arr[index] = c;
				index = parent[index] = getParent(parent,index+1);
			}
			
			parent[l] = index;

		}

		StringBuilder sb = new StringBuilder();

		for (int num : arr)
			sb.append(num).append("\n");

		System.out.println(sb);

	}

	private static int getParent(int[] parent, int i) {
		if (parent[i] == i)
			return i;
		return parent[i] = getParent(parent, parent[i]);
	}

}
