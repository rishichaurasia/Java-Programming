package October_long_challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class D_Dimentional_MST {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int d = Integer.parseInt(in[1]);

		int[][] arr = new int[n][d];

		for (int i = 0; i < n; i++) {
			in = br.readLine().split(" ");
			for (int j = 0; j < d; j++)
				arr[i][j] = Integer.parseInt(in[j]);
		}

		ArrayList<EdgePair> edges = new ArrayList<>((n * (n - 1)) / 2);

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int w = 0;
				for (int k = 0; k < d; k++) {
					w += Math.abs(arr[i][k] - arr[j][k]);
				}
				EdgePair ep = new EdgePair();
				ep.v1 = i;
				ep.v2 = j;
				ep.cost = w;
				edges.add(ep);
			}
		}

		Collections.sort(edges);

		DisjointSet set = new DisjointSet();

		for (int i = 0; i < n; i++) {
			set.create(i);
		}

		int i = 0, ans = 0;
		for (EdgePair edge : edges) {
			if (set.union(edge.v1, edge.v2)) {
				ans += edge.cost;
				if (++i == n - 1)
					break;
			}
		}

		System.out.println(ans);

	}

	static class DisjointSet {

		private ArrayList<Node> l = new ArrayList<>();

		private class Node {
			int parent = -1;
			int rank = 0;
		}

		public void create(int value) {
			l.add(new Node());
		}

		public boolean union(int value1, int value2) {

			int p1 = find(value1);
			int p2 = find(value2);
			
			Node re1 = l.get(p1);
			Node re2 = l.get(p2);

			if (p1 == p2)
				return false;

			if (re1.rank == re2.rank) {
				re2.parent = p1;
				re1.rank++;
			} else if (re1.rank > re2.rank) {
				re2.parent = p1;
			} else {
				re1.parent = p2;
			}
			return true;
		}

		int find(int v) {
			if (l.get(v).parent == -1)
				return v;
			return l.get(v).parent = find(l.get(v).parent); // Path Compression
		}

	}

	private static class EdgePair implements Comparable<EdgePair> {
		int v1;
		int v2;
		int cost;

		@Override
		public int compareTo(EdgePair o) {
			return o.cost - this.cost;
		}

	}

}
