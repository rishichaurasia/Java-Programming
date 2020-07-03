package LeetCode_June_Challenge.Week_4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Find_the_Duplicate_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// O(nlgn) Time | O(1) Space
	public static int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				return nums[i];
			}
		}

		return -1;
	}

	// O(n) Time | O(1) space
	public int findDuplicate1(int[] nums) {
		Set<Integer> seen = new HashSet<Integer>();
		for (int num : nums) {
			if (seen.contains(num)) {
				return num;
			}
			seen.add(num);
		}

		return -1;
	}

	// O(n) Time | O(1) space | Mutable Array
	public static int findDuplicate2(int[] nums) {

		for (int i = 0; i < nums.length; ++i) {
			if (nums[Math.abs(nums[i])] >= 0)
				nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i])];
			else
				return Math.abs(nums[i]);
		}
		return 0;
	}

	// O(n) Time | O(1) space | Immutable Array
	public static int findDuplicate3(int[] nums) {
		// Find the intersection point of the two runners.
		int tortoise = nums[0];
		int hare = nums[0];
		do {
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (tortoise != hare);

		// Find the "entrance" to the cycle.
		tortoise = nums[0];
		while (tortoise != hare) {
			tortoise = nums[tortoise];
			hare = nums[hare];
		}

		return hare;
	}

}
