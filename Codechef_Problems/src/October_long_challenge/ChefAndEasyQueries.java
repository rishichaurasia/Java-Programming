package October_long_challenge;

import java.util.*;

public class ChefAndEasyQueries {
	public static void main(String[] args) throws java.lang.Exception {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();

		while (tc > 0) {

			int n = scn.nextInt();
			int k = scn.nextInt();

			long day = 1;

			long work = 0;

			for (int i = 0; i < n; i++) {
				work = work + scn.nextInt();

				if (work < k) {
					scn.nextLine();
					break;
				}

				work = work - k;
				day++;
			}

			if (work >= k) {
				day = day + work / k;
			}

			System.out.println(day);

			tc--;
		}
	}
}
