package Dynamic_Programming;

import java.util.Arrays;
import java.util.Scanner;

public class K_ordered_LCS {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int N = scn.nextInt();
		int M = scn.nextInt();
		int k = scn.nextInt();

		int[] arr1 = new int[N];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = scn.nextInt();
		}
		
		int[] arr2 = new int[M];
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = scn.nextInt();
		}

		System.out.println(kOrderedLCS_RS(arr1, arr2, 0, 0, k));
		
		int[][][] strg = new int[arr1.length][arr2.length][k+1];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(strg[i][j], -1);
			}
		}
		System.out.println(kOrderedLCS_TD(arr1, arr2, 0, 0, k, strg));
		
		System.out.println(kOrderedLCS_BU(arr1, arr2, k));

	}
	
	public static int kOrderedLCS_RS(int[] arr1, int[] arr2, int idx1, int idx2, int k) {
		
		if(idx1 == arr1.length || idx2 == arr2.length)
			return 0;
		
		int ans = 0;
		
		if(arr1[idx1] == arr2[idx2])
			ans = 1 + kOrderedLCS_RS(arr1, arr2, idx1+1, idx2+1, k);
		else {
			int ans1 = kOrderedLCS_RS(arr1, arr2, idx1+1, idx2, k);
			int ans2 = kOrderedLCS_RS(arr1, arr2, idx1, idx2+1, k);
			int ans3 = 0;
			if(k>0)
				ans3 = 1 + kOrderedLCS_RS(arr1, arr2, idx1+1, idx2+1, k-1);
			
			ans = Math.max(ans1, Math.max(ans2, ans3));
		}
		
		return ans;
	}
	
	public static int kOrderedLCS_TD(int[] arr1, int[] arr2, int idx1, int idx2, int k,int[][][] strg) {
		
		if(idx1 == arr1.length || idx2 == arr2.length)
			return 0;
		
		if(strg[idx1][idx2][k] != -1)
			return strg[idx1][idx2][k];
		
		int ans = 0;
		
		if(arr1[idx1] == arr2[idx2])
			ans = 1 + kOrderedLCS_TD(arr1, arr2, idx1+1, idx2+1, k,strg);
		else {
			int ans1 = kOrderedLCS_TD(arr1, arr2, idx1+1, idx2, k, strg);
			int ans2 = kOrderedLCS_TD(arr1, arr2, idx1, idx2+1, k, strg);
			int ans3 = 0;
			if(k>0)
				ans3 = 1 + kOrderedLCS_TD(arr1, arr2, idx1+1, idx2+1, k-1, strg);
			
			ans = Math.max(ans1, Math.max(ans2, ans3));
		}
		
		strg[idx1][idx2][k] = ans;
		
		return ans;
	}
	
	public static int kOrderedLCS_BU(int[] arr1, int[] arr2, int K) {
		int N = arr1.length;
		int M = arr2.length;
		int[][][] strg = new int[K+1][N+1][M+1];
		
		for(int k = 0; k<=K; ++k) {
			
			for(int idx1 = N-1; idx1>=0; --idx1) {
				
				for(int idx2 = M-1; idx2>=0; --idx2) {
					
					int ans = 0;
					
					if(arr1[idx1] == arr2[idx2])
						ans = 1 + strg[k][idx1+1][idx2+1];
					else {
						int ans1 = strg[k][idx1+1][idx2];
						int ans2 = strg[k][idx1][idx2+1];
						int ans3 = 0;
						if(k>0)
							ans3 = 1 + strg[k-1][idx1+1][idx2+1];
						
						ans = Math.max(ans1, Math.max(ans2, ans3));
					}
					
					strg[k][idx1][idx2] = ans;
					
				}
				
			}
			
		}
		
		return strg[K][0][0];
		
	}

}
