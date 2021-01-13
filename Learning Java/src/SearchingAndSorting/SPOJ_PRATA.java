package SearchingAndSorting;

import java.util.Scanner;

public class SPOJ_PRATA {
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0){
			int P = scn.nextInt();
			int C = scn.nextInt();
			int[] R = new int[C];
			for(int i = 0; i<C; i++)
				R[i] = scn.nextInt();
			System.out.println(minTime(R, P, C));
		}
	}
	
	public static long minTime(int[] R, int P, int C)
	{
		long start = 0, end = (int)1e9;
		long ans = 0;
		while(start <= end){
			long mid = start + (end-start)/2;
			boolean feasible = isFeasible(R, P, C, mid);
			if(feasible){
				ans = mid;
				end = mid-1;
			}else
				start = mid+1;
		}
		return ans;
	}
	
	public static boolean isFeasible(int[] R, int P, int C, long time)
	{
		long p = 0;
		for(int i = 0; i<C; i++){
			p += getPratas(R[i], time);
			if(p >= P)
				return true;
		}
		return false;
	}
	
	public static long getPratas(int r, long time){
		long i = 0, j = time;
		long ans = 0;
		while(i<=j){
			long mid = i + (j-i)/2;
			if(r*mid*(mid+1) <= time*2){
				ans = mid;
				i = mid+1;
			}else
				j = mid-1;
		}
		return ans;
	}
}
