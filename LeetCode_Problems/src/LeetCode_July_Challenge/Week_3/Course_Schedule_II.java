package LeetCode_July_Challenge.Week_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.IntStream;

public class Course_Schedule_II {

	public static void main(String[] args) {

		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

		findOrder(numCourses, prerequisites);

	}

	static int idx;
	static int[] result;
	static int[] visited;
	static HashMap<Integer, HashSet<Integer>> graph;

	public static void findOrder(int numCourses, int[][] prerequisites) {

		graph = new HashMap<>();

		for (int i = 0; i < numCourses; ++i)
			graph.put(i, new HashSet<>());

		for (int[] prerequisite : prerequisites) {

			for (int i = prerequisite.length - 1; i > 0; --i) {
				graph.get(prerequisite[i]).add(prerequisite[i - 1]);
			}

		}

		idx = numCourses-1;
		result = new int[numCourses];
		visited = new int[numCourses];

		for (int i = 0; i < numCourses; ++i) {
			if (visited[i] != 2) {
				if (!topSort(i))
					return;
			}
		}

		IntStream.of(result).forEach(x -> System.out.print(x + " "));
	}

	private static boolean topSort(int vtx) {

		if (visited[vtx] == 2)
			return true;

		if (visited[vtx] == 1)
			return false;

		visited[vtx] = 1;

		for (int i : graph.get(vtx)) {
			if (!topSort(i))
				return false;
		}

		visited[vtx] = 2;

		result[idx--] = vtx;

		return true;
	}

}
