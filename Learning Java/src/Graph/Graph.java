package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph {
	private class Vertex{
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
		for(String nbr: vtces.get(vname).nbrs.keySet()) {
			vtces.get(nbr).nbrs.remove(vname);
		}
		vtces.remove(vname);
	}
	
	public int numEdges() {
		int count = 0;
		for(Vertex vtx: vtces.values())
			count += vtx.nbrs.size();
		return count/2;
	}
	
	public boolean containsEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if(vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
			return false;
		return true;
	}
	
	public void addEdge(String vname1, String vname2, int cost) {
		if(!vtces.containsKey(vname1))
			this.addVertex(vname1);
		if(!vtces.containsKey(vname2))
			this.addVertex(vname2);
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if(vtx1.nbrs.containsKey(vname2))
			return;
		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);
	}
	
	public void removeEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if(vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2))
			return;
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);
	}
	
	public void display() {
		for(String key: vtces.keySet()) {
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
		if(this.containsEdge(vname1, vname2))
			return true;
		Vertex vtx = vtces.get(vname1);
		for(String nbr: vtx.nbrs.keySet()) {
			if(!visited.contains(nbr) && hasPath(nbr, vname2, visited))
				return true;
		}
		return false;
	}
	
	private class Pair{
		String vname;
		String psf;
	}
	
	public boolean bfs(String src, String dst) {
		LinkedList<Pair> queue = new LinkedList<>();
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		queue.addLast(sp);
		Set<String> processed = new HashSet();
		while(!queue.isEmpty()) {
			Pair rp = queue.removeFirst();
			
			if(processed.contains(rp.vname))
				continue;
			
			processed.add(rp.vname);
			
			if(containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}
			
			for(String nbr: vtces.get(rp.vname).nbrs.keySet()) {
				
				if(!processed.contains(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					queue.addLast(np);
				}
					
			}
		}
		return false;
	}
	
	public boolean dfs(String src, String dst) {
		LinkedList<Pair> stack = new LinkedList<>();
		Pair sp = new Pair();
		sp.vname = src;
		sp.psf = src;
		stack.addFirst(sp);
		Set<String> processed = new HashSet();
		while(!stack.isEmpty()) {
			Pair rp = stack.removeFirst();
			
			if(processed.contains(rp.vname))
				continue;
			
			processed.add(rp.vname);
			
			if(containsEdge(rp.vname, dst)) {
				System.out.println(rp.psf + dst);
				return true;
			}
			
			for(String nbr: vtces.get(rp.vname).nbrs.keySet()) {
				
				if(!processed.contains(nbr)) {
					Pair np = new Pair();
					np.vname = nbr;
					np.psf = rp.psf + nbr;
					stack.addFirst(np);
				}
					
			}
		}
		return false;
	}
	
	public void bft() {
		LinkedList<Pair> queue = new LinkedList<>();
		Set<String> processed = new HashSet<>();
		for(String vname: vtces.keySet()) {
			
			if(processed.contains(vname))
				continue;
			
			Pair sp = new Pair();
			sp.vname = vname;
			sp.psf = vname;
			
			queue.addLast(sp);
			
			while(!queue.isEmpty()) {
				Pair rp = queue.removeFirst();
				
				if(processed.contains(rp.vname))
					continue;
				
				processed.add(rp.vname);
				
				System.out.println(rp.vname + " via " + rp.psf);
				
				for(String nbr: vtces.get(rp.vname).nbrs.keySet()) {
					
					if(!processed.contains(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						queue.addLast(np);
					}
						
				}
			}
		}
	}
	
	public void dft() {
		LinkedList<Pair> stack = new LinkedList<>();
		Set<String> processed = new HashSet();
		
		for(String vname: vtces.keySet()) {
			
			if(processed.contains(vname))
				continue;
			
			Pair sp = new Pair();
			sp.vname = vname;
			sp.psf = vname;
			
			stack.addFirst(sp);
		
			while(!stack.isEmpty()) {
				Pair rp = stack.removeFirst();
				
				if(processed.contains(rp.vname))
					continue;
				
				processed.add(rp.vname);
				
				System.out.println(rp.vname + " via " + rp.psf);
				
				for(String nbr: vtces.get(rp.vname).nbrs.keySet()) {
					
					if(!processed.contains(nbr)) {
						Pair np = new Pair();
						np.vname = nbr;
						np.psf = rp.psf + nbr;
						stack.addFirst(np);
					}
						
				}
			}
		}
	}
	
	public boolean isCyclic() {
		LinkedList<String> queue = new LinkedList<>();
		Set<String> processed = new HashSet<>();
		for(String vname: vtces.keySet()) {
			
			if(processed.contains(vname))
				continue;
			
			queue.addLast(vname);
			
			while(!queue.isEmpty()) {
				String rv = queue.removeFirst();
				
				if(processed.contains(rv))
					return true;
				
				processed.add(rv);
				
				for(String nbr: vtces.get(rv).nbrs.keySet()) {
					
					if(!processed.contains(nbr)) {
						queue.addLast(nbr);
					}
						
				}
			}
		}
		return false;
	}
	
	public boolean isConnected() {
		LinkedList<String> queue = new LinkedList<>();
		Set<String> processed = new HashSet<>();
		int flag = 0;
		for(String vname: vtces.keySet()) {
			
			if(processed.contains(vname))
				continue;
			flag++;
			if(flag > 1)
				return false;
			
			queue.addLast(vname);
			
			while(!queue.isEmpty()) {
				String rv = queue.removeFirst();
				
				if(processed.contains(rv))
					continue;
				
				processed.add(rv);
				
				for(String nbr: vtces.get(rv).nbrs.keySet()) {
					
					if(!processed.contains(nbr)) {
						queue.addLast(nbr);
					}
						
				}
			}
		}
		return true;
	}
	
	public boolean isTree() {
		return !isCyclic() && isConnected();
	}
	
	// get connected components
	public List<List<String>> getCC() {
		List<List<String>> ans = new ArrayList<>();
		
		LinkedList<String> queue = new LinkedList<>();
		Set<String> processed = new HashSet<>();
		for(String vname: vtces.keySet()) {
			
			if(processed.contains(vname))
				continue;
			
			List<String> subAns = new ArrayList<String>();
			
			queue.addLast(vname);
			
			while(!queue.isEmpty()) {
				String rv = queue.removeFirst();
				
				if(processed.contains(rv))
					continue;
				
				processed.add(rv);
				
				subAns.add(rv);
				
				for(String nbr: vtces.get(rv).nbrs.keySet()) {
					
					if(!processed.contains(nbr)) {
						queue.addLast(nbr);
					}
						
				}
			}
			ans.add(subAns);
		}
		return ans;
	}
	
}
