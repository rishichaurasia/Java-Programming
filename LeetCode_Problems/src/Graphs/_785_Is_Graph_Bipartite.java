package Graphs;

import java.util.Arrays;
import java.util.Stack;

public class _785_Is_Graph_Bipartite {
	// TC: O(N+E) | SC: O(N)
	class Solution {
		public boolean isBipartite(int[][] graph) {
			int[] visited = new int[graph.length];
			for (int i = 0; i < graph.length; i++) {
				if (visited[i] == 0 && !dfs(graph, i, visited, 1))
					return false;
			}
			return true;
		}

		public boolean dfs(int[][] graph, int vtx, int[] visited, int color) {

			visited[vtx] = color;

			for (int nbr : graph[vtx]) {
				if (visited[nbr] == 0 && !dfs(graph, nbr, visited, 3 - color)) {
					return false;
				} else if (visited[nbr] == color) {
					return false;
				}
			}

			return true;

		}
	}

	class Solution2 {
	    public boolean isBipartite(int[][] graph) {
	        int n = graph.length;
	        int[] color = new int[n];
	        Arrays.fill(color, -1);

	        for (int start = 0; start < n; ++start) {
	            if (color[start] == -1) {
	                Stack<Integer> stack = new Stack();
	                stack.push(start);
	                color[start] = 0;

	                while (!stack.empty()) {
	                    Integer node = stack.pop();
	                    for (int nei: graph[node]) {
	                        if (color[nei] == -1) {
	                            stack.push(nei);
	                            color[nei] = color[node] ^ 1;
	                        } else if (color[nei] == color[node]) {
	                            return false;
	                        }
	                    }
	                }
	            }
	        }

	        return true;
	    }
	}

}