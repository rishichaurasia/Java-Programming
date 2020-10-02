package August_Long_Challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Chefina_and_Strange_Tree {
	
	static class Graph{
		HashMap<Integer,HashSet<Integer>> vtces = new HashMap<>();
		public void addVtx(Integer v1, Integer v2) {
			vtces.putIfAbsent(v1, new HashSet<>());
			vtces.putIfAbsent(v2, new HashSet<>());
			vtces.get(v1).add(v2);
			vtces.get(v2).add(v1);
		}
		
		public void removeVtx(Integer v) {
			for(int vtx: vtces.get(v)) {
				vtces.get(vtx).remove(v);
			}
			vtces.remove(v);
		}
		
	}

	static Scanner scn = new Scanner(System.in);

	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws java.lang.Exception {
		int t = scn.nextInt();
		while (t-- > 0) {
			solve();
		}
		System.out.println(result);
	}
	
	

	public static void solve() {

		int n = scn.nextInt();
		
		Graph graph = new Graph();
		
		for(int i = 1; i<n; i++) {
			graph.addVtx(scn.nextInt(), scn.nextInt());
		}
		
//		System.out.println(graph.vtces);
		
		int[] p = new int[n+1], a = new int[n+1], b = new int[n+1], d = new int[n+1];
		
		for(int i = 1; i<=n; i++)
			p[i] = scn.nextInt();
		for(int i = 1; i<=n; i++)
			a[i] = scn.nextInt();
		for(int i = 1; i<=n; i++)
			b[i] = scn.nextInt();
		
		int day = 1;
		
		for(int i = 1; i<=n; i++) {
			
			int city = p[i];
			
			if(!graph.vtces.containsKey(city)) {
				if(a[city] >= b[city])
					d[city] = day;
				else
					d[city] = -1;
				
				day++;
				continue;
			}
			
			HashSet<Integer> seen = new HashSet<>();
			
			Queue<Integer> q = new LinkedList<>();
			q.add(city);
			
			while(!q.isEmpty()) {
				
				int v = q.poll();
				seen.add(v);
				
				if(b[v] != 0) {
					b[v] = Math.max(0, b[v]-a[city]);
					if(b[v] == 0)
						d[v] = day;
				}
				
				for(int nbrs: graph.vtces.get(v)) {
					if(!seen.contains(nbrs)) {
						q.add(nbrs);
					}
				}
				
			}
			
			if(b[city] != 0)
				d[city] = -1;
			
			day++;
			
			graph.removeVtx(city);
//			System.out.println(graph.vtces);
			
		}
		
		for(int i = 1; i<=n; i++)
			result.append(d[i] + " ");
		
		result.append("\n");
	}

}
