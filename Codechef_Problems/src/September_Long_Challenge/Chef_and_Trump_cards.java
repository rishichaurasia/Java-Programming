package September_Long_Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chef_and_Trump_cards {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		computeFact();
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			solve();
		}
		
		System.out.println(res);
		
	}
	
	static int mod = (int)1e9 + 7;
	
	static long modInverse(long a, int m){ 
		return power(a, m - 2, m);
    } 
    
    static long power(long x, int y, int m)  
    { 
        if (y == 0) 
            return 1; 
          
        long p = power(x, y / 2, m) % m; 
        p = (p * p) % m; 
      
        if (y % 2 == 0) 
            return p; 
        else
            return (x * p) % m; 
    }
    
    static long[] fact = new long[500001];
    
    private static void computeFact() {
		fact[0] = 1;
		fact[1] = 1;
		for(int i = 2; i<fact.length; i++) {
			fact[i] = (fact[i-1]*i)%mod;
		}
		
	}

	private static void solve() throws Exception{
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		
		input = br.readLine().split(" ");
		
		int max = 0;
		int maxFreq = 0;
		
		for(String st: input) {
			int card = Integer.parseInt(st);
			if(card > max) {
				max = card;
				maxFreq = 1;
			}else if(card == max)
				maxFreq++;
		}
		
		long ans;
		
		if((maxFreq & 1) == 1) {
			ans = powerOf2(n);
		}else {
			ans = powerOf2(n-maxFreq);
			
			long comb = fact[maxFreq];
			
			long modInv = modInverse(fact[maxFreq/2], mod);
			comb *= modInv;
			comb %= mod;
			comb *= modInv;
			comb %= mod;
			
			long mul = ((powerOf2(maxFreq) - comb)%mod + mod) % mod;
			
			ans *= mul;
			ans %= mod;
		}
		
		res.append(ans).append("\n");
		
	}
	
	public static long powerOf2(int n) {
		long ways = 1;
		for(int i = 1; i<=n; i++) {
			ways *= 2;
			ways %= mod;
		}
		return ways;
	}
	
}
