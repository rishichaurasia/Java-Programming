package LeetCode_July_Challenge.Week_3;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Top_k_frequent_elements {

	public static void main(String[] args) {

		int[] nums = { 2, 3, 4, 3, 2, 4, 4, 3, 2, 2, 3, 4, 7, 7, 2, 32, 3, 4 };
		int k = 4;
		topKFrequent(nums, k);

	}

	public static void topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> map.get(x) - map.get(y));
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for(int key: map.keySet()) {
			pq.add(key);
			if(pq.size() > k)
				pq.poll();
		}
		
		int[] res = new int[k];
		for (int i = 0; i < k; ++i)
			res[i] = pq.poll();

		IntStream.of(res).forEach(x -> System.out.print(x + " "));

	}

}
