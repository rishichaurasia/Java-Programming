package September_Long_Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chefina_and_swap {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			solve();
		}
		
		System.out.println(res);
		
	}

	private static void solve() throws Exception {
		
		int n = Integer.parseInt(br.readLine());
		
		if((((n+1)/2) & 1) == 1) {
			res.append(0).append("\n");
			return;
		}
		
		long sumMul2 = (1L * n * (n+1))/2;
		
		long sqrt = (long)Math.sqrt(sumMul2);
		
		if(sqrt*(sqrt+1) > sumMul2)
			sqrt--;
		
		long result = n-sqrt;
		
		if(sqrt*(sqrt+1) == sumMul2) {
			result += (sqrt*(sqrt-1))/2 + (result*(result-1))/2;
		}
		
		res.append(result).append("\n");
		
	}
	
}
