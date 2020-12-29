package Searching_and_Sorting;

import java.io.*;
import java.util.*;

public class Movie_Festival_II {

	public static void main(String[] args) {

		FastReader s = new FastReader();
		int n = s.nextInt();
		int k = s.nextInt();
		int[][] intervals = new int[n][2];
		for(int i = 0; i<n; i++) {
			intervals[i][0] = s.nextInt();
			intervals[i][1] = s.nextInt();
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[1], o2[1]);
			}
		});
		int ans = 0;
		TreeSet<Integer> set = new TreeSet<>();
		for(int[] interval: intervals) {
			Integer end = set.floor(interval[0]);
			if(end != null) {
				set.remove(end);
				set.add(interval[1]);
				ans++;
			}else if(set.size() < k) {
				set.add(interval[1]);
				ans++;
			}
		}
		
		System.out.println(ans);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
