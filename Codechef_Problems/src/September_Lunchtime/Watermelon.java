package September_Lunchtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Watermelon {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			solve();
		}
		
		System.out.println(res);
		
	}

	private static void solve() throws Exception {
		
		int N = Integer.parseInt(br.readLine());
		String[] A = br.readLine().split(" ");
		
		int sum = 0;
		
		for(int i = 0; i<N; i++) {
			sum += Integer.parseInt(A[i]);
		}
		
		res.append(sum >= 0 ? "YES\n" : "NO\n");
		
	}

}
