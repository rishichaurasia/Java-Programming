package SearchingAndSorting;

import java.util.Scanner;

public class SPOJ_EKO {
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] h = new int[n];
		int maxH = 0;
		for(int i = 0; i<n; i++){
			h[i] = scn.nextInt();
			maxH = Math.max(maxH, h[i]);
		}
		System.out.println(solve(h, n, m, maxH));
	}
	
	public static int solve(int[] h, int N, int M, int maxH){
		int i = 0, j = maxH;
		int ans = 0;
		while(i<=j){
			int mid = i + (j-i)/2;
			boolean check = isSufficient(h, N, M, mid);
			if(check){
				ans = mid;
				i = mid+1;
			}else
				j = mid-1;
		}
		return ans;
	}
	
	public static boolean isSufficient(int[] h, int N, int M, int setH){
		int m = 0;
		for(int i = 0; i<N; i++){
			if(h[i] > setH)
				m += h[i]-setH;
			if(m >= M)
				return true;
		}
		return false;
		
	}
}
