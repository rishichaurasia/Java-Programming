package Array;

public class Move_Zeroes {
	public void moveZeroes(int[] nums) {
		int i = 0;
		while (i < nums.length && nums[i] != 0)
			i++;
		for (int j = i + 1; j < nums.length; j++) {
			if (nums[j] != 0) {
				nums[i] = nums[j];
				nums[j] = 0;
				i++;
			}
		}
	}
}
