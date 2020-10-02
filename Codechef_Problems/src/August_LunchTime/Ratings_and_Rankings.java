package August_LunchTime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Ratings_and_Rankings {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static StringBuilder res = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			solve();
		}
		
		System.out.println(res);
		
	}

	private static void solve() throws Exception {
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[][] ratings = new int[n][m+1];
		
		input = br.readLine().split(" ");
		
		for(int i = 0; i<n; i++) {
			ratings[i][0] = Integer.parseInt(input[i]);
		}
		
		for(int i = 0; i<n; i++) {
			input = br.readLine().split(" ");
			for(int j = 1; j<=m; j++) {
				ratings[i][j] = ratings[i][j-1] + Integer.parseInt(input[j-1]);
			}
		}
		
		int[] maxRatings = new int[n];
		
		for(int i = 0; i<n; i++) {
			int max = Integer.MIN_VALUE;
			for(int j = 1; j<m+1; j++) {
				if(max < ratings[i][j]) {
					max = ratings[i][j];
					maxRatings[i] = j;
				}
			}
		}
		
		int[] maxRankings = new int[n];
		int[] maxRankMonth = new int[n];
		Arrays.fill(maxRankings, Integer.MAX_VALUE);
		
		for(int i = 1; i<m+1; i++) {
			ArrayList<Integer> list = new ArrayList<>(n);
			for(int j = 0; j<n; j++) {
				list.add(ratings[j][i]);
			}
			Collections.sort(list, Collections.reverseOrder());
			
			HashMap<Integer,Integer> ranks = new HashMap<>();
			int rank = 1;
			for(int item: list) {
				if(!ranks.containsKey(item))
					ranks.put(item, rank);
				rank++;
			}
			for(int j =0; j<n; j++) {
				if(ranks.get(ratings[j][i]) < maxRankings[j]) {
					maxRankings[j] = ranks.get(ratings[j][i]);
					maxRankMonth[j] = i;
				}
			}
		}
		
		int count = 0;
		
		for(int i = 0; i<n; i++) {
			if(maxRatings[i] != maxRankMonth[i]) count++;
		}
		
		res.append(count).append("\n");
	}

}
