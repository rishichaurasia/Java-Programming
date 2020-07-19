package Dynamic_Programming;

import java.util.Scanner;

public class Count_number_of_binary_strings {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int t = scn.nextInt();
		
		while(t-- > 0) {
			int n = scn.nextInt();
			
			System.out.println(countBinaryStringsRS(n, 0));
		}

	}
	
	// O(2^n) Time
	public static long countBinaryStringsRS(int n, int lastDigit) {
		
		if(n == 1) {
			if(lastDigit == 0)
				return 2;
			return 1;
		}
		
		long ans;
		
		if(lastDigit == 0) {
			ans = countBinaryStringsRS(n-1, 0) + countBinaryStringsRS(n-1, 1);
		}else
			ans = countBinaryStringsRS(n-1, 0);
		
		return ans;
	}	
	
	public static long countBinaryStringsDP(int n) {
		
		long[][] strg = new long[2][n];
		
		strg[0][0] = strg[1][0] = 1L;
		
		for(int i = 1; i<n; ++i) {
			strg[0][i] = strg[0][i-1] + strg[1][i-1];
			strg[1][i] = strg[0][i-1];
		}
		
		return strg[0][n-1] + strg[1][n-1];
		
	}
	
	public static long countBinaryStrings1(int n) {
		
		long ending0 = 1;
		long ending1 = 1;
		
		for(int i = 1; i<n; ++i) {
			long temp = ending0;
			ending0 += ending1;
			ending1 = temp;
		}
		
		return ending0 + ending1;
		
	}

}
