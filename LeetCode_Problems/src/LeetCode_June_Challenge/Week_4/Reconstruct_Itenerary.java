package LeetCode_June_Challenge.Week_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Reconstruct_Itenerary {

	public static void main(String[] args) {
		List<List<String>> tickets = new ArrayList<>();
		tickets.add(Arrays.asList("JFK","SFO"));
		tickets.add(Arrays.asList("JFK","ATL"));
		tickets.add(Arrays.asList("SFO","ATL"));
		tickets.add(Arrays.asList("ATL","JFK"));
		tickets.add(Arrays.asList("ATL","SFO"));
		System.out.println(findItinerary(tickets));

	}
	
	private static void dfs(Map<String, PriorityQueue<String>> adj, LinkedList<String> result, String s){
        PriorityQueue<String> pq = adj.get(s);
        while(pq != null && !pq.isEmpty()){
            String v = pq.poll();
            dfs(adj, result, v);
        }
        result.addFirst(s);
    }
    public static List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap();
        for(List<String> t: tickets){
            adj.putIfAbsent(t.get(0), new PriorityQueue<>());
            adj.get(t.get(0)).add(t.get(1));
        }
        
        LinkedList<String> result = new LinkedList();
        dfs(adj, result, "JFK");
        return result;
    }

}
