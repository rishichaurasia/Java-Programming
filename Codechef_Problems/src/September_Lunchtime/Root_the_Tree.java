package September_Lunchtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Root_the_Tree {

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
		
		String[] input;
		
		int[] inDegree = new int[N+1];
		
		for(int i = 1; i<N; i++) {
			input = br.readLine().split(" ");
			inDegree[Integer.parseInt(input[1])]++;
		}
		
		int cnt = 0;
		
		for(int i = 1; i<=N; i++) {
			if(inDegree[i] == 0)
				cnt++;
		}
		
		res.append(cnt-1).append("\n");
		
	}
	
}
