package Graph;

import java.util.*;

public class Detecting_shortest_cycle_in_undirected_unweighted_graph {

	static final int N = 100200;
	@SuppressWarnings("unchecked")
	static Vector<Integer>[] gr = new Vector[N];

	// Function to add edge
	static void Add_edge(int x, int y) {
		gr[x].add(y);
		gr[y].add(x);
	}

	// Function to find the length of
	// the shortest cycle in the graph
	static int shortest_cycle(int n) {

		// To store length of the shortest cycle
		int ans = Integer.MAX_VALUE;

		// For all vertices
		for (int i = 0; i < n; i++) {

			// Make distance maximum
			int[] dist = new int[n];
			Arrays.fill(dist, (int) 1e9);

			// Distance of source to source is 0
			dist[i] = 0;
			Queue<Integer> q = new LinkedList<>();

			// Push the source element
			q.add(i);

			// Continue until queue is not empty
			while (!q.isEmpty()) {

				// Take the first element
				int x = q.poll();

				// Traverse for all it's childs
				for (int child : gr[x]) {
					// If it is not visited yet
					if (dist[child] == (int) (1e9)) {

						// Increase distance by 1
						dist[child] = 1 + dist[x];

						// Push into the queue
						q.add(child);
					} else if (dist[child] >= dist[x])
						ans = Math.min(ans, dist[x] + dist[child] + 1);
				}
			}
		}

		// If graph contains no cycle
		if (ans == Integer.MAX_VALUE)
			return -1;

		// If graph contains cycle
		else
			return ans;
	}

	// Driver Code
	public static void main(String[] args) {

		for (int i = 0; i < N; i++)
			gr[i] = new Vector<>();

		// Number of vertices
		int n = 7;

		// Add edges
		Add_edge(0, 6);
		Add_edge(0, 5);
		Add_edge(5, 1);
		Add_edge(1, 6);
		Add_edge(2, 6);
		Add_edge(2, 3);
		Add_edge(3, 4);
		Add_edge(4, 1);

		// Function call
		System.out.println(shortest_cycle(n));
	}
}
