package August_LunchTime;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Game_on_a_strip {

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
		
		scn.nextInt();
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int count = 0;
		for(int i = 1; i<n; i++) {
			int cell = scn.nextInt();
			if(cell == 0)
				count++;
			else {
				if(count > 0)
					pq.add(count);
				count = 0;
			}
		}
//		System.out.println(pq);
		int s = pq.size();
		if(s == 0) {
			sb.append("No");
		}else if(s == 1) {
			if(pq.poll()%2 == 1) {
				sb.append("Yes");
			}else
				sb.append("No");
		}else {
			int p1 = pq.poll();
			int p2 = pq.poll();
			if(p1 != p2 && p2 <= p1/2 ) {
				if(p1%2 == 1) {
					sb.append("Yes");
				}else
					sb.append("No");
			}else
				sb.append("No");
		}
		sb.append("\n");
	}

}
