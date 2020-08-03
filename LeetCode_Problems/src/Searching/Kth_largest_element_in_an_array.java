package Searching;

public class Kth_largest_element_in_an_array {

	public static void main(String[] args) {
		
		int[] nums = {3,2,3,1,2,4,5,5,6};
		int k = 4;
		System.out.println(findKthLargest(nums, k));
	}
	
	public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, k);
    }
    
    public static int quickSelect(int[] nums, int left, int right, int k){
        
        int si = left;
        int ei = right-1;
        int mid = (left+right)/2;
        int pivot = nums[mid];
        swap(nums, mid, right);
        
        while(si<=ei){
            while(si<=ei && nums[si] <= pivot)
                si++;
            
            while(si<=ei && nums[ei] > pivot)
                ei--;
            
            if(si < ei){
                swap(nums, si, ei);
                si++;
                ei--;
            }
        }
        
        swap(nums, right, si);
        
        int kthLargestIndex = nums.length - k;
            
        if(si == kthLargestIndex)
            return pivot;
        else if(si < kthLargestIndex)
            return quickSelect(nums, si+1, right, k);
        else
            return quickSelect(nums, left, si-1, k);
    }
    
    public static void swap(int[] nums, int i, int k){
        int temp = nums[i];
        nums[i] = nums[k];
        nums[k] = temp;
    }

}
