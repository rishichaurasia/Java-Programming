package LeetCode_June_Challenge.Week_4;

import java.util.Arrays;

public class Single_number_II {

	public static void main(String[] args) {
		int[] nums = {2,2,3,2,3,4,3};
		System.out.println(singleNumber2(nums));
	}

	// O(nlogn)+n = O(nlogn) (logn <= 32)
	public static int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i += 3) {
			if (i >= nums.length - 2 || nums[i] != nums[i + 2])
				return nums[i];
		}
		return 0;
	}

	public static int singleNumber1(int[] nums) {
		int result = 0;

		for (int i = 0; i < 32; i++) {
			int count = 0; // count to nos. having ith bit 'set'
			int ith = 1 << i;

			for (int num : nums) {
				if ((num & ith) != 0)
					count++;
			}
			if(count % 3 == 1)
				result |= ith;
		}
		return result;
	}
	
	public static int singleNumber2(int[] nums) {
		int ones = 0;
		int twos = 0;
		for(int num: nums) {
			ones = (num^ones) & ~twos;
			twos = (num^twos) & ~ones;
		}
		return ones;
	}

}
