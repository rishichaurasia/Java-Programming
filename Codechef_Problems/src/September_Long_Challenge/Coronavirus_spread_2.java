package September_Long_Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeSet;

public class Coronavirus_spread_2 {

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
		
		int[] leftMax = new int[n];
		int[] rightMin = new int[n];
		leftMax[0] = arr[0];
		rightMin[n-1] = arr[n-1];
		for(int i = 1; i<n; i++) {
			leftMax[i] = Math.max(arr[i], leftMax[i-1]);
		}
		
		for(int i = n-2; i>=0; i--) {
			rightMin[i] = Math.min(arr[i], rightMin[i+1]);
		}
		
		int best = n;
		int  worst = 1;
		
		for(int i = 0; i<n; i++) {
			int count = 1;
			for(int j = 0; j<n; j++) {
				if(j<i && arr[j] > rightMin[i])
					count++;
				if(j > i && arr[j] < leftMax[i])
					count++;
			}
			best = Math.min(best, count);
			worst = Math.max(worst, count);
		}
		
		res.append(best+" "+worst + "\n");
		
	}

}
