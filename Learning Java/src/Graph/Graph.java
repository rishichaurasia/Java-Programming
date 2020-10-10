package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph {
	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();
	}

	private HashMap<String, Vertex> vtces;

	public Graph() {
		vtces = new HashMap<>();
	}

	public int numVertex() {
		return vtces.size();
	}

	public boolean containsVertex(String vname) {
		return vtces.containsKey(vname);
	}

	public void addVertex(String vname) {
		Vertex vertex = new Vertex();
		vtces.put(vname, vertex);
	}

	public void removeVertex(String vname) {
		for (String nbr : vtces.get(vname).nbrs.keySet()) {
			vtces.get(nbr).nbrs.remove(vname);
		}
		vtces.remove(vname);
	}

	public int numEdges() {
		int count = 0;
		for (Vertex vtx : vtces.values())
			count += vtx.nbrs.size();
		return count / 2;
	}

	public boolean containsEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
			return false;
		return true;
	}

	public void addEdge(String vname1, String vname2, int cost) {
		if (!vtces.containsKey(vname1))
			this.addVertex(vname1);
		if (!vtces.containsKey(vname2))
			this.addVertex(vname2);
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1.nbrs.containsKey(vname2))
			return;
		vtx1.nbrs.put(vname2, cost);
//		vtx2.nbrs.put(vname1, cost); // not required if the graph is directed
	}

	public void removeEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
			return;
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}

	public void display() {
		for (String key : vtces.keySet()) {
			Vertex vtx = vtces.get(key);
			System.out.println(key + " : " + vtx.nbrs);
		}
		System.out.println("-----------------------------");
	}

	public boolean hasPath(String vname1, String vname2) {
		return hasPath(vname1, vname2, new HashSet<String>());
	}

	private boolean hasPath(String vname1, String vname2, Set visited) {
		visited.add(vname1);
		if (this.containsEdge(vname1, vname2))
			return true;
		Vertex vtx = vtces.get(vname1);
		for (String nbr : vtx.nbrs.keySet()) {
			if (!visited.contains(nbr) && hasPath(nbr, vname2, visited))
				return true;
		}
		return false;
	}

	private class Pair {
		String vname;
		String psf;
	}

//	O(2e + v) ~ O(e+v) Time
	public boolean bfs(String src, String dst) {
		LinkedList<Pair> queue = new LinkedList<>();
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		queue.addLast(sp);
		Set<String> processed = new HashSet();
		while (!queue.isEmpty()) {
			Pair rp = queue.removeFirst();

			if (processed.contains(rp.vname))
				continue;

			processed.add(rp.vname);

			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

				if (!processed.contains(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					queue.addLast(np);
				}

			}
		}
		return false;
	}

//	O(2*e + v) = O(e+v) Time
	public boolean dfs(String src, String dst) {
		LinkedList<Pair> stack = new LinkedList<>();
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		stack.addFirst(sp);
		Set<String> processed = new HashSet();
		while (!stack.isEmpty()) {
			Pair rp = stack.removeFirst();

			if (processed.contains(rp.vname))
				continue;

			processed.add(rp.vname);

			if (containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}

			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

				if (!processed.contains(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					stack.addFirst(np);
				}

			}
		}
		return false;
	}

//	O(2*e + v) = O(e+v) Time
	public void bft() {
		LinkedList<Pair> queue = new LinkedList<>();
		Set<String> processed = new HashSet<>();
		for (String vname : vtces.keySet()) {

			if (processed.contains(vname))
				continue;

			Pair sp = new Pair();
			sp.vname = vname;
			sp.psf = vname;

			queue.addLast(sp);

			while (!queue.isEmpty()) {
				Pair rp = queue.removeFirst();

				if (processed.contains(rp.vname))
					continue;

				processed.add(rp.vname);

				System.out.println(rp.vname + " via " + rp.psf);

				for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

					if (!processed.contains(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}

				}
			}
		}
	}

//	O(2*e + v) = O(e+v) Time
	public void dft() {
		LinkedList<Pair> stack = new LinkedList<>();
		Set<String> processed = new HashSet();

		for (String vname : vtces.keySet()) {

			if (processed.contains(vname))
				continue;

			Pair sp = new Pair();
			sp.vname = vname;
			sp.psf = vname;

			stack.addFirst(sp);

			while (!stack.isEmpty()) {
				Pair rp = stack.removeFirst();

				if (processed.contains(rp.vname))
					continue;

				processed.add(rp.vname);

				System.out.println(rp.vname + " via " + rp.psf);

				for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

					if (!processed.contains(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						stack.addFirst(np);
					}

				}
			}
		}
	}

//	O(2*e + v) = O(e+v) Time
	public boolean isCyclic() {
		LinkedList<String> queue = new LinkedList<>();
		Set<String> processed = new HashSet<>();
		for (String vname : vtces.keySet()) {

			if (processed.contains(vname))
				continue;

			queue.addLast(vname);

			while (!queue.isEmpty()) {
				String rv = queue.removeFirst();

				if (processed.contains(rv))
					return true;

				processed.add(rv);

				for (String nbr : vtces.get(rv).nbrs.keySet()) {

					if (!processed.contains(nbr)) {
						queue.addLast(nbr);
					}

				}
			}
		}
		return false;
	}

//	O(2*e + 2*v) = O(e+v) Time
	public boolean isConnected() {
		LinkedList<String> queue = new LinkedList<>();
		Set<String> processed = new HashSet<>();
		int flag = 0;
		for (String vname : vtces.keySet()) {

			if (processed.contains(vname))
				continue;
			flag++;
			if (flag > 1)
				return false;

			queue.addLast(vname);

			while (!queue.isEmpty()) {
				String rv = queue.removeFirst();

				if (processed.contains(rv))
					continue;

				processed.add(rv);

				for (String nbr : vtces.get(rv).nbrs.keySet()) {

					if (!processed.contains(nbr)) {
						queue.addLast(nbr);
					}

				}
			}
		}
		return true;
	}

//	O(e+v) Time
	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

	// get connected components
	// O(e+v) Time
	public List<List<String>> getCC() {
		List<List<String>> ans = new ArrayList<>();

		LinkedList<String> queue = new LinkedList<>();
		Set<String> processed = new HashSet<>();
		for (String vname : vtces.keySet()) {

			if (processed.contains(vname))
				continue;

			List<String> subAns = new ArrayList<String>();

			queue.addLast(vname);

			while (!queue.isEmpty()) {
				String rv = queue.removeFirst();

				if (processed.contains(rv))
					continue;

				processed.add(rv);

				subAns.add(rv);

				for (String nbr : vtces.get(rv).nbrs.keySet()) {

					if (!processed.contains(nbr)) {
						queue.addLast(nbr);
					}

				}
			}
			ans.add(subAns);
		}
		return ans;
	}

	private class PrimsPair implements Comparable<PrimsPair> {
		String vname;
		String acqname; // Acquiring vertex name
		int cost;

		public PrimsPair(String key) {
			vname = key;
			acqname = null;
			cost = Integer.MAX_VALUE;

		}

		@Override
		public int compareTo(PrimsPair o) {
			return o.cost - this.cost;
		}
	}

	// O(vlogv + vlogv + 2elogv) = O(elogv) Time
	public Graph prims() {

		Graph mst = new Graph();
		HashMap<String, PrimsPair> map = new HashMap<>();

		HeapGeneric<PrimsPair> heap = new HeapGeneric<>();

		// make a pair and put in heap and map
		for (String key : vtces.keySet()) {
			PrimsPair np = new PrimsPair(key);
			heap.add(np);
			map.put(key, np);
		}

		// till the heap is not empty keep on removing the pairs
		while (!heap.isEmpty()) {

			// remove a pair
			PrimsPair rp = heap.remove();
			map.remove(rp.vname);

			// add to mst
			if (rp.acqname == null) {
				mst.addVertex(rp.vname);
			} else {
				mst.addVertex(rp.vname);
				;
				mst.addEdge(rp.vname, rp.acqname, rp.cost);
			}

			// nbrs
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

				// work for nbrs which are in heap
				if (map.containsKey(nbr)) {
					int oc = map.get(nbr).cost; // old cost
					int nc = vtces.get(rp.vname).nbrs.get(nbr); // new cost

					// update the pair only when nc<oc
					if (nc < oc) {
						PrimsPair gp = map.get(nbr);
						gp.acqname = rp.vname;
						gp.cost = nc;

						heap.updatePriority(gp);

					}
				}
			}

		}

		return mst;

	}

	private class DijkstraPair implements Comparable<DijkstraPair> {
		String vname;
		String psf; // Acquiring vertex name
		int totCost;

		public DijkstraPair(String key) {
			vname = key;
			psf = "";
			totCost = Integer.MAX_VALUE;

		}

		@Override
		public int compareTo(DijkstraPair o) {
			return o.totCost - this.totCost;
		}
	}
	
//	Only works when all edges are of positive weight
//	works for both directed and undirected graph
//	O(elogv) Time
	public HashMap<String, Integer> dijkstra(String src) {

		HashMap<String, DijkstraPair> map = new HashMap<>();
		HashMap<String, Integer> ans = new HashMap<>();

		HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();

		// make a pair and put in heap and map
		for (String key : vtces.keySet()) {
			DijkstraPair np = new DijkstraPair(key);
			if (key.equals(src)) {
				np.psf = key;
				np.totCost = 0;
			}
			heap.add(np);
			map.put(key, np);
		}

		// till the heap is not empty keep on removing the pairs
		while (!heap.isEmpty()) {

			// remove a pair
			DijkstraPair rp = heap.remove();
			map.remove(rp.vname);

			// add to ans
			ans.put(rp.vname, rp.totCost);

			// nbrs
			for (String nbr : vtces.get(rp.vname).nbrs.keySet()) {

				// work for nbrs which are in heap
				if (map.containsKey(nbr)) {
					int oc = map.get(nbr).totCost; // old cost
					int nc = vtces.get(rp.vname).nbrs.get(nbr) + rp.totCost; // new cost

					// update the pair only when nc<oc
					if (nc < oc) {
						DijkstraPair gp = map.get(nbr);
						gp.psf = rp.psf + gp.vname;
						gp.totCost = nc;

						heap.updatePriority(gp);

					}
				}
			}

		}

		return ans;

	}

	public class DisjointSet {

		private HashMap<String, Node> map = new HashMap<>();

		private class Node {
			String data;
			Node parent;
			int rank;
		}

		public void create(String value) {
			Node nn = new Node();
			nn.data = value;
			nn.parent = nn;
			nn.rank = 0;
			map.put(value, nn);
		}

		// Union by rank
		public boolean union(String value1, String value2) {
			// Find representative nodes
			Node re1 = find(map.get(value1));
			Node re2 = find(map.get(value2));

			// If both the nodes have same parent do nothing.
			// This means both bolong to the same set
			if (re1 == re2)
				return false;

			if (re1.rank == re2.rank) {
				re2.parent = re1;
				re1.rank++;
			} else if (re1.rank > re2.rank)
				re2.parent = re1;
			else
				re1.parent = re2;
			return true;
		}

		public String find(String value) {
			return find(map.get(value)).data;
		}

		// Find Parent
		private Node find(Node node) {
			if (node == node.parent)
				return node;
			Node rr = find(node.parent);
			node.parent = rr; // path compression
			return rr;
		}
	}

	private class EdgePair implements Comparable<EdgePair> {
		String v1;
		String v2;
		int cost;

		@Override
		public int compareTo(EdgePair o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return v1 + "-" + v2 + ":" + cost;
		}
	}

	public ArrayList<EdgePair> getAllEdges() {
		ArrayList<EdgePair> edges = new ArrayList<>();

		for (String vname : vtces.keySet()) {

			Vertex vtx = vtces.get(vname);

			for (String nbr : vtx.nbrs.keySet()) {
				EdgePair ep = new EdgePair();
				ep.v1 = vname;
				ep.v2 = nbr;
				ep.cost = vtx.nbrs.get(nbr);
				edges.add(ep);
			}

		}

		return edges;
	}

//	O(2e + eloge + v + e) = O(eloge) = O(elog(v^2)) = O(2elogv) = O(elogv) Time
	public void kruskal(String src) {

		ArrayList<EdgePair> edges = getAllEdges();

		// sort the edges in increasing order of cost
		Collections.sort(edges);

		DisjointSet set = new DisjointSet();

		// create vertices no. of disjoint sets
		for (String vname : vtces.keySet()) {
			set.create(vname);
		}

		Graph graph = new Graph();

		// traverse over the edges
		for (EdgePair edge : edges) {
			if (set.union(edge.v1, edge.v2))
				graph.addEdge(edge.v1, edge.v2, edge.cost);
		}

		graph.display();

	}

	// works on directed graph when no negative cycle is present
	// works on undirected graph when all edges are of positive weight
	// O(e + v + e*v) = O(ev) Time 
	public HashMap<String, Integer> bellmanFord(String src) throws Exception{
		ArrayList<EdgePair> edges = getAllEdges();
		HashMap<String, Integer> map = new HashMap<>();

		// Fill map with infinity
		for (String vname : vtces.keySet())
			map.put(vname, 100000);

		// Make the cost of source to 0
		map.put(src, 0);

		int V = vtces.size();
		
		// Traverse on edges v-1 times
		// Reax every edge v-1 times
		for (int v = 1; v <= V; ++v) {

			// loop on edges
			for (EdgePair edge : edges) {
				int oc = map.get(edge.v2); // old cost
				int nc = map.get(edge.v1) + edge.cost; // new cost

				if (nc < oc) {
					if(v < V)
						map.put(edge.v2, nc);
					else
						throw new Exception("Negative Weight cycle present!");
				}
			}

		}

		return map;

	}
}
