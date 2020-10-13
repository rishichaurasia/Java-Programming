package Graph;

import java.util.*;

public class _SPOJ_Holi_Holiday_Accomodation {

	public static void main(String[] args) throws java.lang.Exception {
		Scanner scn = new Scanner(System.in);
		int t = Integer.parseInt(scn.nextLine());
		for (int it = 1; it <= t; it++) {
			
			int n = Integer.parseInt(scn.nextLine());
			Graph1 g = new Graph1(n);
			String[] in;
			for (int i = 0; i < n - 1; i++) {
				in = scn.nextLine().split(" ");
				g.addEdge(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]));
			}
			long ans = g.getMaxTravelDistance();
			System.out.println(String.format("Case #%d: %d", it, ans));
		}
	}
}

class Graph1 {
	int V;
	HashMap<Integer, Integer>[] vtces;

	Graph1(int V){
		this.V = V;
		vtces = new HashMap[V+1];
		for(int i = 1; i<=V; i++) {
			vtces[i] = new HashMap<>();
		}
	}
	
	public void addEdge(int v1, int v2, int w) {
		vtces[v1].put(v2, w);
		vtces[v2].put(v1, w);
	}

	long ans;

	public long getMaxTravelDistance() {
		boolean[] visited = new boolean[V+1];
		ans = 0;
		dfs(1, visited);
		return ans;
	}

	private long dfs(int v, boolean[] visited) {
		visited[v] = true;
		int count = 1;
		for (int nbr : vtces[v].keySet()) {
			if (!visited[nbr]) {
				long nx = dfs(nbr, visited);
				long ny = V - nx;
				ans += 2 * Math.min(nx, ny) * vtces[v].get(nbr);
				count += nx;
			}
		}

		return count;
	}
}