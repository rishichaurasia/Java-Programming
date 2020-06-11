package Array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/

class Solution {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> seen = new HashMap<>();
		for (int curr = 0; curr < nums.length; curr++) {
			int currMatch = target - nums[curr];
			if (seen.containsKey(currMatch))
				return new int[] { seen.get(currMatch), curr };
			else
				seen.put(nums[curr], curr);
		}
		return new int[0];
	}
}
