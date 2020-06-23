package Array;

public class Shortest_Unsorted_Continuous_Array {
	
	// O(n) time | O(1) space
	public int findUnsortedSubarray(int[] nums) {
        
        int start=-1;
        int end=-2;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<nums.length;i++){
            
            max=Math.max(max,nums[i]);
            if(nums[i]<max){
                end=i;
            }
        }
        
        for(int i=nums.length-1;i>=0;i--){
            
            min=Math.min(min,nums[i]);
            if(nums[i]>min){
                start=i;
            }
        }
        
        return end-start+1;
    }
	
	// O(n) time | O(1) space
	public int findUnsortedSubarray1(int[] nums) {
        if(nums.length <= 1)
            return 0;
        int minOutOfOrder = Integer.MAX_VALUE;
        int maxOutOfOrder = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            int num = nums[i];
            if(isOutOfOrder(i, num, nums)){
                minOutOfOrder = Math.min(minOutOfOrder, nums[i]);
                maxOutOfOrder = Math.max(maxOutOfOrder, nums[i]);
            }
        }
        if(minOutOfOrder == Integer.MAX_VALUE) // sorted array
            return 0;
        int leftIdx = 0;
        while(nums[leftIdx] <= minOutOfOrder)
            leftIdx++;
        int rightIdx = nums.length-1;
        while(nums[rightIdx] >= maxOutOfOrder)
            rightIdx--;
        return rightIdx-leftIdx+1;
    }
    
    public boolean isOutOfOrder(int i, int num, int[] nums){
        if(i == 0)
            return num > nums[i+1];
        if(i == nums.length -1)
            return num < nums[i-1];
        else
            return num < nums[i-1] || num > nums[i+1];
    }
}
