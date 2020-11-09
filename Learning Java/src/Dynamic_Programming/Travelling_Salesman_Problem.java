package Dynamic_Programming;

public class Travelling_Salesman_Problem {

	static int n = 4;

	static int[][] dist = { { 0, 20, 42, 25 }, { 20, 0, 30, 34 }, { 42, 30, 0, 10 }, { 25, 34, 10, 0 } };

	static int VISITED_ALL = (1 << n) - 1;

	static int tsp(int mask, int pos) {
		if (mask == VISITED_ALL) {
			return dist[pos][0];
		}
		int ans = Integer.MAX_VALUE;
		for (int city = 0; city < n; city++) {
			if ((mask & (1 << city)) == 0) {
				int newAns = dist[pos][city] + tsp(mask|(1<<city),city);
				ans = Math.min(ans, newAns);
			}
		}
		return ans;
	}
	
	static int[][] dp = new int[1<<n][n];
	
	static int tspDPTD(int mask, int pos) {
		if (mask == VISITED_ALL) {
			return dist[pos][0];
		}
		
		if(dp[mask][pos] != 0)
			return dp[mask][pos];
		
		int ans = Integer.MAX_VALUE;
		for (int city = 0; city < n; city++) {
			if ((mask & (1 << city)) == 0) {
				int newAns = dist[pos][city] + tsp(mask|(1<<city),city);
				ans = Math.min(ans, newAns);
			}
		}
		 
		return dp[mask][pos] = ans;
	}

	public static void main(String[] args) {
		
		System.out.println(tsp(1,0));
		
		System.out.println(tspDPTD(1,0));
	}

}
