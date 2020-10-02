package August_LunchTime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Counting_Graphs {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static StringBuilder res = new StringBuilder();

	public static void main(String[] args) throws Exception {

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			solve();
		}

		System.out.println(res);

	}

	static final long mod = (long) 1e9 + 7;

	private static void solve() throws Exception {

		String[] input = br.readLine().split(" ");

		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");

		int[] arr = new int[n];

		arr[0]++;

		for (int i = 0; i < n - 1; i++) {
			int pos = Integer.parseInt(input[i]);
			arr[pos]++;
		}

		boolean flag = true;
		long ans = 1;

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] == 0 && arr[i] > 0) {
				flag = false;
				break;
			}

			if (arr[i] > 0) {
				ans *= BE(arr[i - 1], arr[i], mod);
				ans %= mod;
			}

		}

		if (!flag) {
			res.append(0).append("\n");
			return;
		}

		long node_pairs = 0;

		for (int i = 1; i < n - 1; i++) {
			long count = arr[i];
			node_pairs += ((count * (count - 1)) / 2);
		}

		if (m - (n - 1) > 0) {
			m -= (n - 1);
			if (m > node_pairs) {
				ans = 0;
			} else {
				long ways = 0, num = 1, den = 1;
				for (long i = node_pairs - (long) m + 1; i <= node_pairs; i++) {
					num *= i;
					num %= mod;
				}
				for (int i = 1; i <= m; i++) {
					den *= i;
					den %= mod;
				}
				ways = num * BE(den, mod - 2, mod);
				ways %= mod;
				ans = (ans * ways) % mod;
			}
		}
		
		res.append(ans).append("\n");
		
		
	}

	public static long BE(long a, long b, long mod) {
		long res = 1;
		while (b > 0) {
			if (b % 2 == 1)
				res = (res * a) % mod;
			a = (a * a) % mod;
			b = b / 2;
		}
		return res;
	}

}
