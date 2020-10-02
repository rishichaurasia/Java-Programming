package August_Long_Challenge;

import java.util.Scanner;

public class Chef_and_Linear_Chess {

	static Scanner scn = new Scanner(System.in);

	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws java.lang.Exception {
		int t = scn.nextInt();
		scn.nextLine();
		while (t-- > 0) {
			solve();
		}
		System.out.println(result);
	}

	public static void solve() {

		String[] input = scn.nextLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		String[] p = scn.nextLine().split(" ");
		
		int ans = -1;
		
		for(String pi: p) {
			int ith = Integer.parseInt(pi);
			if(ith < k && k%ith == 0) {
				ans = Math.max(ans, ith);
			}
		}
		
		result.append(ans + "\n");
	}

}
