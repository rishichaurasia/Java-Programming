package September_Long_Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Divide_Candies {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int K;
	
	public static void main(String[] args) throws Exception {
		
		K = Integer.parseInt(br.readLine());
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			solve(i+1);
		}
				
	}

	private static void solve(int N) throws Exception{
		
		char[] carr = new char[N];
		carr[N-1] = '1';
		
		long diff = power(N, K);
		
		for(int i = N-1; i>=1; i--) {
			if(diff > 0) {
				carr[i-1] = '0';
				diff -= power(i, K);
			}else {
				carr[i-1] = '1';
				diff += power(i, K);
			}
		}
		
		System.out.println(Math.abs(diff));
		System.out.println(new String(carr));
	}
	
	static long power(long x, int y)  
    { 
        if (y == 0) 
            return 1; 
          
        long p = power(x, y / 2); 
        p = (p * p); 
      
        if (y % 2 == 0) 
            return p; 
        else
            return (x * p); 
    }

}
