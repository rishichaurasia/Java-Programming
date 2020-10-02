package Leetcode_August_Challenge.Week_4;

public class Minimum_cost_for_Tickets {

	public static void main(String[] args) {
		

	}
	
//	BU DP
	public static int mincostTickets(int[] days, int[] costs) {
		return mincostTickets(days, 0, costs, new int[days.length]);
	}

	public static int mincostTickets(int[] days, int idx, int[] costs, int[] strg) {
		
		if(idx == days.length)
			return 0;
		
		if(strg[idx]  != 0)
			return strg[idx];
		
		int ans1 = mincostTickets(days, idx+1, costs, strg) + costs[0];
		
		int i = idx;
		for(; i<days.length; i++) {
			if(days[i] >= days[idx]+7)
				break;
		}
		
		int ans2 = mincostTickets(days, i, costs, strg) + costs[1];
		
		for( ; i<days.length; i++) {
			if(days[i] >= days[idx] + 30)
				break;
		}
		
		int ans3 = mincostTickets(days, i, costs, strg) + costs[2];
		
		int ans = Math.min(ans1, Math.min(ans2, ans3));
		
		strg[idx] = ans;
		
		return ans;
		
	}
	
//	TD DP
	public static int mincostTickets1(int[] days, int[] costs) {
		
		int n = days.length;
		int[] dp = new int[n+1];
		
		for(int i = n-1; i>=0; i--) {
			int ans1 = dp[i+1] + costs[0];
			
			int j = i;
			for(; j<days.length; j++) {
				if(days[j] >= days[i]+7)
					break;
			}
			
			int ans2 = dp[j] + costs[1];
			
			for( ; j<days.length; j++) {
				if(days[j] >= days[i] + 30)
					break;
			}
			
			int ans3 = dp[j] + costs[2];
			
			int ans = Math.min(ans1, Math.min(ans2, ans3));
			
			dp[i] = ans;
		}
		
		return dp[0];
	}

}
