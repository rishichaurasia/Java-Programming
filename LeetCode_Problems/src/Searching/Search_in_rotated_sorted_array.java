package Searching;

public class Search_in_rotated_sorted_array {

	public static void main(String[] args) {
		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		System.out.println(search(nums, 0));
		System.out.println(search(nums, 3));

	}
	
	public static int search(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            
            if(nums[mid] == target){
                return mid;
            }else if(nums[i] <= nums[mid]){
                if(target >= nums[i] && target < nums[mid])
                    j = mid-1;
                else
                    i = mid+1;
            }else{
                if(target > nums[mid] && target <= nums[j])
                    i = mid+1;
                else
                    j = mid-1;
                    
            }
        }
        return -1;
    }

}
