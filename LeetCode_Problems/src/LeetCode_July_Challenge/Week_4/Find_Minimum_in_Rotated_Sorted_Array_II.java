package LeetCode_July_Challenge.Week_4;

public class Find_Minimum_in_Rotated_Sorted_Array_II {

	public static void main(String[] args) {
		int[] nums = {2,2,2,0,1};
		System.out.println(findMin1(nums));
	}
	
	public static int findMin(int[] nums) {
        
        if(nums.length == 1 || nums[0] < nums[nums.length-1])
            return nums[0];
        
        for(int i = 1; i<nums.length; i++){
            if(nums[i] < nums[i-1])
                return nums[i];
        }
        return nums[0];
    }

	public static int findMin1(int[] nums) {
		int lo = 0;
		int n = nums.length;
		int hi = n - 1;
		int min = nums[lo];
		while (lo < hi) {
			while (lo < hi && lo < n - 2 && nums[lo] == nums[lo + 1]) {
				lo = lo + 1;
			}
			while (lo < hi && hi >= 1 && nums[hi] == nums[hi - 1]) {
				hi = hi - 1;
			}
			int mid = lo + (hi - lo) / 2;
			if (mid - 1 >= 0 && mid + 1 <= n - 1 && nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return nums[mid];
			}
			if (nums[mid] < nums[hi]) {
				hi = mid;
			} else {
				lo = mid + 1;
			}

		}
		return nums[lo];

	}

}
