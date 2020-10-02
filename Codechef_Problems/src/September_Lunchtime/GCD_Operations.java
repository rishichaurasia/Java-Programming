package September_Lunchtime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GCD_Operations {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			res.append(solve()).append("\n");
		}
		
		System.out.println(res);
		
	}

	private static String solve() throws Exception {
		
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		
		for(int i = 0; i<N; i++) {
			int bi = Integer.parseInt(input[i]);
			if((i+1) % bi != 0)
				return "NO";
		}
		
		return "YES";
		
	}

}
