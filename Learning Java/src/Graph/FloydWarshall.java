package Graph;

public class FloydWarshall {

	// Shortest path from every vertex to every vertex
	// O(V^3) Time | O(V^2) space
	// Dijkstra and Bellman Ford take O(V^4) Time
	public static void main(String[] args) {
		int V = 4;
		
		int[][] graph = {{0,3,10000,7},{8,0,2,10000},{5,10000,0,1},{2,10000,10000,0}};

		int[][] dist = graph.clone();
		
		for(int k = 0; k<V; ++k) {
			for(int i = 0; i<V; ++i) {
				for(int j = 0; j<V; ++j) {
					int oc = dist[i][j];
					int nc = dist[i][k] + dist[k][j];
					
					if(nc < oc)
						dist[i][j] = nc;
				}
			}
		}
		
		
		for(int[] row: dist) {
			for(int col: row)
				System.out.print(col + "\t");
			System.out.println();
		}
	}

}
