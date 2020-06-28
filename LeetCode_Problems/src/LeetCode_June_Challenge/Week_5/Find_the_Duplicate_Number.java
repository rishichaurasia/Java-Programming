package LeetCode_June_Challenge.Week_5;

import java.util.Arrays;

public class Find_the_Duplicate_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// O(nlgn) Time | O(1) Space
	public static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }

        return -1;
    }

}
