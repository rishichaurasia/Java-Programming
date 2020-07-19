package Dynamic_Programming;

// https://www.spoj.com/problems/MIXTURES/

import java.util.Arrays;

public class Mixtures {

	public static void main(String[] args) {
		int[] arr = { 40, 60, 20 };
		System.out.println(mixRS(arr, 0, arr.length - 1));
		
		int[][] strg = new int[arr.length][arr.length];
		for(int i = 0; i<arr.length; i++) {
			Arrays.fill(strg[i], -1);
		}
		System.out.println(mixTD(arr, 0, arr.length-1, strg));
		
		System.out.println(mixBU(arr));
	}

	public static int mixRS(int[] arr, int si, int ei) {
		if (si == ei) {
			return 0;
		}
		int minSmoke = Integer.MAX_VALUE;

		for (int i = si; i < ei; ++i) {
			int smoke1 = mixRS(arr, si, i);
			int smoke2 = mixRS(arr, i + 1, ei);

			int smoke = color(arr, si, i) * color(arr, i + 1, ei);

			if (smoke < minSmoke) {
				minSmoke = smoke + smoke1 + smoke2;
			}
		}
		return minSmoke;
	}

	public static int color(int[] arr, int si, int ei) {
		int sum = 0;
		for (int i = si; i <= ei; ++i) {
			sum += arr[i];
		}
		return sum % 100;
	}
	
	public static int mixTD(int[] arr, int si, int ei, int[][] strg) {
		if (si == ei) {
			return 0;
		}
		
		if(strg[si][ei] != -1) {
			return strg[si][ei];
		}
		
		int minSmoke = Integer.MAX_VALUE;

		for (int i = si; i < ei; ++i) {
			int smoke1 = mixRS(arr, si, i);
			int smoke2 = mixRS(arr, i + 1, ei);

			int smoke = color(arr, si, i) * color(arr, i + 1, ei);

			if (smoke < minSmoke) {
				minSmoke = smoke + smoke1 + smoke2;
			}
		}
		strg[si][ei] = minSmoke;
		return minSmoke;
	}
	
	public static int mixBU(int[] arr) {
		int n = arr.length;
		int[][] strg = new int[n][n];
		
		for(int slide = 1; slide<n; ++slide) {
			for(int si = 0; si+slide<n; ++si) {
				int ei = si+slide;
				
				int minSmoke = Integer.MAX_VALUE;
				
				for (int i = si; i < ei; ++i) {
					int smoke1 = strg[si][i];
					int smoke2 = strg[i+1][ei];

					int smoke3 = color(arr, si, i) * color(arr, i + 1, ei);
					
					int totalSmoke = smoke1 + smoke2 + smoke3;
					
					if(totalSmoke < minSmoke)
						minSmoke = totalSmoke;
				}
				
				strg[si][ei] = minSmoke;
			}
		}
		return strg[0][n-1];
	}


}
