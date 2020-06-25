package LeetCode_June_Challenge.Week_2;

public class Search_Insert_Position {

	public int searchInsert(int[] nums, int target) {
	    
	    int left = 0;
        int right = nums.length -1;
        int mid;
        
        if(nums.length == 0 || nums[left] >= target) return left;
        if(nums[right] < target) return right+1;
        
        while(left < right){
            mid = left + (right -left)/2;
            
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1; 
            }
        }
        return left; 
	}
	
}
