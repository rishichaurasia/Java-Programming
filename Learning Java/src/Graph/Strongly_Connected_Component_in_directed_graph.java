package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Strongly_Connected_Component_in_directed_graph {

	static List<Integer>[] graph;
	static List<Integer>[] revGraph;

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int V = scn.nextInt();
		int E = scn.nextInt();
		graph = new List[V];
		revGraph = new List[V];
		for (int i = 0; i < V; i++) {
			graph[i] = new ArrayList<Integer>();
			revGraph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i<E; i++) {
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();
			graph[v1].add(v2);
			revGraph[v2].add(v1);
		}

		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfs(i, visited, stack);
			}
		}
		
		System.out.println(stack);

		visited = new boolean[V];
		int compNum = 1;

		while (!stack.isEmpty()) {
			int v = stack.pop();
			if (!visited[v]) {
				System.out.print(compNum++ + " -> ");
				dfs2(v, visited);
				System.out.println();
			}
		}

	}

	private static void dfs(int v, boolean[] visited, Stack<Integer> stack) {

		visited[v] = true;

		for (int nbr : graph[v]) {
			if (!visited[nbr])
				dfs(nbr, visited, stack);
		}

		stack.push(v);

	}

	private static void dfs2(int v, boolean[] visited) {

		visited[v] = true;
		System.out.print(v + " ");

		for (int nbr : revGraph[v]) {
			if (!visited[nbr])
				dfs2(nbr, visited);
		}

	}

}
