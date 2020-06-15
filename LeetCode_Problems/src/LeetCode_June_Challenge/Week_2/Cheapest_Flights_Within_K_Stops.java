package LeetCode_June_Challenge.Week_2;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class Cheapest_Flights_Within_K_Stops {
	
    
	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		HashMap<Integer, HashMap<Integer, Integer>> vtces = new HashMap<>();
		for(int[] flight: flights) {
			if(!vtces.containsKey(flight[0]))
				vtces.put(flight[0], new HashMap<Integer, Integer>());
			vtces.get(flight[0]).put(flight[1], flight[2]);
		}
		Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
		pq.add(new int[] {0, src, K + 1});
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int price = top[0];
            int city = top[1];
            int stops = top[2];
            if (city == dst) return price;
            if (stops > 0) {
                HashMap<Integer, Integer> adj = vtces.getOrDefault(city, new HashMap<>());
                for (int a : adj.keySet()) {
                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
                }
            }
        }
        return -1;
    }
}
