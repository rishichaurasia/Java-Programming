package Dynamic_Programming;

import java.util.Scanner;

public class Minimum_Jumps {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int t = scn.nextInt();
		
		while(t-- > 0) {
			int n = scn.nextInt();
			int[] steps = new int[n];
			for(int i = 0; i<n; ++i)
				steps[i] = scn.nextInt();
//			System.out.println(minJumpsTD(steps, 0, new int[n]));
			
			System.out.println(minJumpsBU(steps));
		}

	}
	
	public static int minJumpsRS(int[] steps, int idx) {
		
		if(idx == steps.length-1)
			return 0;
		
		int ans = Integer.MAX_VALUE;
		
		for(int i = idx+1; i<steps.length && i<=idx+steps[idx]; ++i) {
			
			ans = Math.min(ans, minJumpsRS(steps, i));
			
		}
		
		return ans == Integer.MAX_VALUE ? ans : ans+1;
		
	}
	
	public static int minJumpsTD(int[] steps, int idx, int[] strg) {
		
		if(idx == steps.length-1)
			return 0;
		
		if(strg[idx] != 0)
			return strg[idx];
		
		int ans = Integer.MAX_VALUE;
		
		for(int i = idx+1; i<steps.length && i<=idx+steps[idx]; ++i) {
			
			ans = Math.min(ans, minJumpsTD(steps, i, strg));
			
		}
		
		strg[idx] = (ans == Integer.MAX_VALUE) ? ans : ans+1;
		
		return strg[idx];
		
	}
	
	public static int minJumpsBU(int[] steps) {
		int[] strg = new int[steps.length];
		
		for(int i = strg.length-2; i>=0; --i) {
			
			int ans = Integer.MAX_VALUE;
			
			for(int j = i+1; j<steps.length && j<=i+steps[i]; ++j) {
				
				ans = Math.min(ans, strg[j]);
				
			}
			
			strg[i] = (ans == Integer.MAX_VALUE) ? ans : ans+1;
			
		}
		
		return strg[0];
	}

}
