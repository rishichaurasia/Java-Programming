package Graph;

public class GraphClient {

	public static void main(String[] args) throws Exception {

		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
//		graph.addVertex("F");
//		graph.addVertex("G");
//		
//		graph.addEdge("A", "B", 2);
//		graph.addEdge("A", "D", 10);
//		graph.addEdge("B", "C", 3);
//		graph.addEdge("C", "D", 1);
//		graph.addEdge("D", "E", 8);
//		graph.addEdge("E", "F", 5);
//		graph.addEdge("E", "G", 6);
//		graph.addEdge("F", "G", 4);
		
		
		graph.addEdge("A", "B", 8);
		graph.addEdge("A", "C", 4);
		graph.addEdge("A", "D", 5);
		graph.addEdge("C", "D", -3);
		graph.addEdge("D", "E", 4);
		graph.addEdge("E", "B", 1);
		graph.addEdge("B", "E", 2);
		
		graph.display();
//		System.out.println(graph.numVertex());
//		System.out.println(graph.numEdges());
//		System.out.println(graph.containsEdge("A", "C"));
//		System.out.println(graph.containsEdge("E", "F"));
//		graph.removeEdge("A", "B");
//		graph.display();
//		
//		graph.removeVertex("F");
//		graph.display();
//		
//		graph.addVertex("F");
//		graph.display();
//		
//		graph.addEdge("A", "F", 10);
//		graph.display();
		
//		System.out.println(graph.dfs("A", "F"));
//		graph.removeEdge("A", "D");
//		System.out.println(graph.dfs("A", "F"));
		
//		graph.bft();
//		graph.dft();
		
//		System.out.println(graph.isCyclic());
		
//		System.out.println(graph.isConnected());
		
//		System.out.println(graph.getCC()); // get connected components
	
//		graph.prims().display();
		
//		System.out.println(graph.dijkstra("A"));
		
//		graph.kruskal("A");
		
		System.out.println(graph.bellmanFord("A"));
	}

}
