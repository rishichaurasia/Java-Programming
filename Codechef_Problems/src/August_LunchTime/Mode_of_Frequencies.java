package August_LunchTime;

import java.util.HashMap;
import java.util.Scanner;

public class Mode_of_Frequencies {

	static Scanner scn = new Scanner(System.in);
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		int t = scn.nextInt();
		
		while(t-- > 0) {
			solve();
		}
		
		System.out.println(sb);

	}

	private static void solve() {
		
		int n = scn.nextInt();
		int[] arr = new int[11];
		for(int i = 1; i<=n; i++) {
			arr[scn.nextInt()]++;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 1; i<=10; i++) {
			if(arr[i] > 0) {
				map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			}
		}
		int maxFreq = 0;
		int mode = 0;
		for(int key: map.keySet()) {
			int value = map.get(key);
			if(value > maxFreq) {
				maxFreq = value;
				mode = key;
			}else if(value == maxFreq) {
				mode = Math.min(mode, key);
			}
		}
		sb.append(mode).append("\n");
	}

}
