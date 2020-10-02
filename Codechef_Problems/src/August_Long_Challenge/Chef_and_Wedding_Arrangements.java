package August_Long_Challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Chef_and_Wedding_Arrangements {

	static Scanner scn = new Scanner(System.in);

	static StringBuilder result = new StringBuilder();

	public static void main(String[] args) throws java.lang.Exception {
		int t = scn.nextInt();
		scn.nextLine();
		while (t-- > 0) {
			solve();
		}
		System.out.println(result);
	}
	
//	static class Pair{
//		HashMap<String, Integer> map = new HashMap<>();
//		int cost = 0;
//	}
//
//	private static void solve() {
//		String[] input = scn.nextLine().split(" ");
//		int n = Integer.parseInt(input[0]);
//		int k = Integer.parseInt(input[1]);
//		
//		String[] guests = scn.nextLine().split(" ");
//		
//		Stack<Pair> stack = new Stack<>();
//		for(int i = 0; i<n; i++) {
//			Pair pair = new Pair();
//			pair.map.put(guests[i], 1);
//			pair.cost = k;
//			stack.push(pair);
//		}
//		
//		int ineff = 0;
//		
//		while(!stack.isEmpty()) {
//			if(stack.size()>=3) {
//				Pair p1 = stack.pop();
//				Pair p2 = stack.pop();
//				Pair p3 = stack.pop();
//				int p1p2 = getConflicts(p1, p2);
//				int p2p3 = getConflicts(p2, p3);
//				
//				if(p1p2+p3.cost <= p2.cost+p2p3) {
//					if(p1p2 < p2.cost) {
//						merge(p1,p2);
//						p1.cost += p1p2;
//						stack.push(p3);
//						stack.push(p1);
//					}else {
//						ineff += p1.cost;
//						stack.push(p3);
//						stack.push(p2);
//					}
//				}else {
//					if(p2p3 < p3.cost) {
//						merge(p2,p3);
//						p2.cost += p2p3;
//						stack.push(p2);
//						stack.push(p1);
//					}else {
//						ineff += p1.cost + p2.cost;
//						stack.push(p3);
//						stack.push(p2);
//					}
//				}
//			}else if(stack.size() >= 2) {
//				Pair p1 = stack.pop();
//				Pair p2 = stack.pop();
//				int p1p2 = getConflicts(p1, p2);
//				
//				if(p1p2 < p2.cost) {
////					merge(p1,p2);
//					p1.cost += p1p2;
//					ineff += p1.cost;
//				}else {
//					ineff += p1.cost + p2.cost;
//				}
//			}else {
//				ineff += stack.pop().cost;
//			}
//		}
//		
//		result.append(ineff).append("\n");
//		
//	}
//	
//	private static void merge(Pair p1, Pair p2) {
//		
//		for(String guest: p2.map.keySet()) {
//			p1.map.put(guest, p1.map.getOrDefault(guest, 0) + p2.map.get(guest));
//		}
//		
//	}
//
//	private static int getConflicts(Pair p1, Pair p2) {
//		int conflicts = 0;
//		for(String guest: p2.map.keySet()) {
//			if(p1.map.containsKey(guest)) {
//				conflicts += p1.map.get(guest) == 1? p2.map.get(guest) + 1 : p2.map.get(guest);
//			}
//		}
//		return conflicts;
//	}

	private static void solve() {
		
		String[] input = scn.nextLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
		String[] guests = scn.nextLine().split(" ");
		cache = new HashMap<>();
		int ans = getMinIneff(guests, 0, new HashMap<>(), 0, k);
		
		result.append(ans + "\n");

	}
	
	static HashMap<Integer, HashMap<Integer, Integer>> cache;
	
	private static int getMinIneff(String[] guests, int idx, Map<String, Integer> map, int mapSize, int k) {
		if(idx == guests.length)
			return k;
		
		
		if(cache.containsKey(idx)) {
			int rv = cache.get(idx).getOrDefault(mapSize, -1);
			if(rv != -1)
				return rv;
		}
		
		int ans = Integer.MAX_VALUE;
		int c = map.getOrDefault(guests[idx], 0);
		if(c == 0) {
			map.put(guests[idx], 1);
			ans = getMinIneff(guests, idx+1, map, mapSize+1, k);
		}else if(c == 1) {
			map.put(guests[idx], 2);
			int ans1 = getMinIneff(guests, idx+1, map, mapSize+1, k) + 2;
			map = new HashMap<>();
			map.put(guests[idx], 1);
			int ans2 = getMinIneff(guests, idx+1, map, 1, k) + k;
			
			ans = Math.min(ans1, ans2);
		}else {
			map.put(guests[idx], c+1);
			int ans1 = getMinIneff(guests, idx+1, map, mapSize+1, k) + 1;
			map = new HashMap<>();
			map.put(guests[idx], 1);
			int ans2 = getMinIneff(guests, idx+1, map, 1, k) + k;
			
			ans = Math.min(ans1, ans2);
		}
		System.out.println(map);
		cache.putIfAbsent(idx, new HashMap<>());
		cache.get(idx).put(mapSize, ans);
		
		return ans;
	}
	
	

//	public static void solve() {
//
//		String[] input = scn.nextLine().split(" ");
//		int n = Integer.parseInt(input[0]);
//		int k = Integer.parseInt(input[1]);
//		
//		String[] guests = scn.nextLine().split(" ");
//		
//		Map<String, Integer> map = new HashMap<>();
//		int ineff = k;
//		int sameFam = 0;
//		for(int i = 0; i<n; i++) {
//			int c = map.getOrDefault(guests[i], 0);
//			if(c == 0)
//				map.put(guests[i], 1);
//			else if(c == 1) {
//				if(2 <= k) {
//					sameFam += 2;
//					map.put(guests[i], c+1);
//				}else {
//					ineff += sameFam + k;
//					sameFam = 0;
//					map = new HashMap<>();
//					map.put(guests[i], 1);
//				}
//			}else if(c > 1) {
//				if(1 <= k) {
//					sameFam += 1;
//					map.put(guests[i], c+1);
//				}else {
//					ineff += sameFam + k;
//					sameFam = 0;
//					map = new HashMap<>();
//					map.put(guests[i], 1);
//				}
//			}
//		}
//		
//		result.append(ans + "\n");
//	}

}
