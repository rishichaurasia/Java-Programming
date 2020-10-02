package August_LunchTime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Alien_Invasion {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			solve();
		}
		
		System.out.println(res);
		
	}
	
	static int n, d;
	static int[] arr;

	private static void solve() throws Exception {
		
		String[] input = br.readLine().split(" ");
		
		n = Integer.parseInt(input[0]);
		d = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		
		arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(arr);
		
		double low = 0, high = 2e9, mid;
		
		while(high - low > 1e-6) {
			 mid = (low+high)/2;
			 if(work(mid))
				 low = mid;
			 else
				 high = mid;
		}
		
		res.append(String.format("%.7f", low)).append("\n");
		
	}

	private static boolean work(double mid) {
		
		double time = 0;
		for(int i = 0; i<n; i++) {
			
			if(time < arr[i])
				time = arr[i]+mid;
			else if(time <= arr[i]+d)
				time += mid;
			else
				return false;
			
		}
		return true;
		
	}
	
}
