package June_Cookoff;

import java.util.Scanner;

public class Cache_Hits {

	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int T = scn.nextInt();
		while(T-- > 0) {
			int N = scn.nextInt();
			int B = scn.nextInt();
			int M = scn.nextInt();
			
			int count = 0;
			int cache = -1;
			while(M-- > 0) {
				int m = scn.nextInt();
				int rem = m/B;
				if(rem != cache) {
					count++;
					cache = rem;
				}
			}
			System.out.println(count);
		}

	}

}
