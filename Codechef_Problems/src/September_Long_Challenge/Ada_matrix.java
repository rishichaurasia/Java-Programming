package September_Long_Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Ada_matrix {

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
		
		int[] arr = new int[n];
		
		String[] input = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		for(int i = 1; i<n; i++)
			br.readLine();
		
		
		boolean flag;
		if(arr[1] == 2)
			flag = true;
		else
			flag = false;
		
		int count = 0;
		
		for(int i = 1; i<n; i++) {
			if((arr[i] == i+1) != flag) {
				count++;
				flag = !flag;
			}
		}
		
		if(arr[n-1] != n)
			count++;
		
		res.append(count).append("\n");
		
	}

}
