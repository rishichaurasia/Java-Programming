package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {

	public static void main(String[] args) {
		int[] nums = {1,-2,-5,-4,-3,3,3,5};
		System.out.println(fourSum(nums, 7));
	}
	
	// O(n^3) time | O(1) space
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 4)
            return list;
        Arrays.sort(nums);
        int left = 0;
        while(left<nums.length-3){
        	if(left > 0 && nums[left] == nums[left-1]) {
        		left++;
        		continue;
        	}
            int right = nums.length;
            while((--right)-left>=3){
            	if(right < nums.length-1 && nums[right] == nums[right+1]) {
            		continue;
            	}
                int cornerSum = nums[left] + nums[right];
                int midSum = target - cornerSum;
                int mid1 = left+1;
                int mid2 = right-1;
                while(mid1<mid2) {
                	if(mid1 > left+1 && nums[mid1] == nums[mid1-1]) {
                		mid1++;
                		continue;
                	}
                    int sum = nums[mid1]+nums[mid2];
                    if(sum < midSum)
                        mid1++;
                    else if(sum > midSum)
                        mid2--;
                    else{
                        list.add(Arrays.asList(nums[left], nums[mid1], nums[mid2], nums[right]));
                        mid1++;
                        mid2--;
                    }
                }
            }
            left++;
        }
        return list;
    }
	
	// Efficient
	public List<List<Integer>> fourSum1(int[] nums, int target) {
	    //for quadruplets, still use two pointers, 0,1, check(2,len-1), then 0,2,check(3,len-1),...
	    List<List<Integer>> list = new ArrayList<>();
	    if(nums == null || nums.length < 4) return list;
	    Arrays.sort(nums);
	    int len = nums.length;
	    
	    // anchor the first element
	    for(int i=0; i<=len-4; i++) {
	         // avoid duplicate
	        if(i != 0 && nums[i] == nums[i-1]) continue;  
	         // speed up, after sort, if smallest four items >target, then no need to go on
	        if(nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;   
	         // speed up,after sort, if current i plus three biggest < target, have to use bigger i.
	        if(nums[i] + nums[len-3] + nums[len-2] + nums[len-1] < target) continue;    
	        
	        // 3-sum
	        for(int j=i+1; j<=len-3; j++) {
	            // avoid duplicate
	            if(j != i+1 && nums[j] == nums[j-1]) continue;
	            // speed up
	            if(nums[i] + nums[j] + nums[i+1] + nums[j+2] > target) break;     
	            // speed up
	            if(nums[i] + nums[j] + nums[len-2] + nums[len-1] < target) continue;    
	            
	            // two pointer
	            int left = j+1, right = len-1, tmpTarget = target - nums[i] - nums[j];
	            while(left < right) {
	                if(nums[left] + nums[right] == tmpTarget) {
	                    //no difference use new ArrayList<> or Arrays.asList directly.
	                    //list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
	                    list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
	                    while(left < right && nums[left] == nums[left+1]) left++;       // avoid duplicate
	                    while(left < right && nums[right] == nums[right-1]) right--;    // avoid duplicate
	                    left++;
	                    right--;
	                } else if(nums[left] + nums[right] < tmpTarget) {
	                    left++;
	                } else {
	                    right--;
	                }
	            }
	        }
	    }
	    return list;
	}

}
