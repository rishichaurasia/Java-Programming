package October_long_challenge;

import java.util.*;

public class Covid_run {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();

		while (tc > 0) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int x = scn.nextInt();
			int y = scn.nextInt();

			HashSet<Integer> set = new HashSet<>();
			String ans = "";
			while (true) {
				if (x == y) {
					ans = "YES";
					break;
				} else if (set.contains(x)) {
					ans = "NO";
					break;
				}
				set.add(x);
				x = (x + k) % n;
			}
			System.out.println(ans);
			tc--;
		}
	}
}
