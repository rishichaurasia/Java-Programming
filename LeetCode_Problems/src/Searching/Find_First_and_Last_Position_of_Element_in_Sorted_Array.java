package Searching;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

	public static void main(String[] args) {
		
		int[] nums = {0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10};
		int target = 4;
		int[] result = searchRange1(nums, target);
		System.out.println(result[0] + ":" + result[1]);

	}
	
	public static int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        
        while(i <= j){
            int mid = (i+j)/2;
            if(nums[mid] < target)
                i = mid+1;
            else if(nums[mid] > target)
                j = mid-1;
            else
                return getRange(nums, mid, target);
            
        }
        
        return new int[] {-1, -1};
    }
    
    public static int[] getRange(int[] nums, int idx, int target){
        int i = idx;
        while(i>0 && nums[i-1] == target)
            i--;
        
        int j = idx;
        while(j<nums.length-1 && nums[j+1] == target)
            j++;
        
        return new int[] {i,j};
    }
    
    public static int[] searchRange1(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        
        while(i <= j){
            int mid = (i+j)/2;
            if(nums[mid] < target)
                i = mid+1;
            else if(nums[mid] > target)
                j = mid-1;
            else {
                int lidx = mid;
                int ridx = mid;
                if(mid != i && nums[mid-1] == target)
                	lidx = alteredBinarySearch(nums, i, mid-1, target, true);
                if(mid != j && nums[mid+1] == target)
                	ridx = alteredBinarySearch(nums, mid+1, j, target, false);
                
                return new int[] {lidx, ridx};
            }
            
        }
        
        return new int[] {-1, -1};
    }
    
    public static int alteredBinarySearch(int[] nums, int si, int ei, int target, boolean goLeft) {
    	
    	while(si <= ei) {
    		
    		int mid = (si+ei)/2;
    		if(nums[mid] < target)
				si = mid+1;
    		else if(nums[mid] > target)
    			ei = mid-1;
    		else {
    			
    			if(goLeft) {
    				if(mid != si && nums[mid-1] == target)
    					ei = mid-1;
    				else
    					return mid;
    			}else {
    				if(mid != ei && nums[mid+1] == target)
    					si = mid+1;
    				else
    					return mid;
    			}
    			
    		}
    	}
    	return -1;
    	
    }
    
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }

    public int[] searchRange3(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        // assert that `leftIdx` is within the array bounds and that `target`
        // is actually in `nums`.
        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

}
