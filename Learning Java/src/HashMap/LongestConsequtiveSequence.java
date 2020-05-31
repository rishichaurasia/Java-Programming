package HashMap;

import java.util.HashMap;

public class LongestConsequtiveSequence {

	public static void main(String[] args) {
		
		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 , 7 };

		longestConsecutiveSeq(arr);
	}
	
	public static void longestConsecutiveSeq(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int val : arr) {

			if (map.containsKey(val - 1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}

		}

		int longestLength = Integer.MIN_VALUE;
		int seqStarting = 0;

		for (Integer key : map.keySet()) {

			if (map.get(key)) {

				int count = 0;

				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > longestLength) {
					longestLength = count;
					seqStarting = key;
				}

			}
		}

		for (int i = 0; i < longestLength; i++) {
			System.out.println(seqStarting + i);
		}

	}

}
