package September_Long_Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class A_problem_on_sticks {

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
		
		String[] input = br.readLine().split(" ");
		
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = 0; i<n; i++)
			set.add(Integer.parseInt(input[i]));
		
		set.remove(0);
		
		res.append(set.size()).append("\n");
	}

}
