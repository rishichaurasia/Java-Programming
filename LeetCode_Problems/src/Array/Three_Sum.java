package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {

	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length<3)
            return list;
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length-1] < 0)
            return list;
        for(int left = 0; nums[left] <= 0 && left<nums.length-2; left++){
            if(left > 0 && nums[left] == nums[left-1])
                continue;
            int complement = -nums[left];
            int mid = left+1,
                right = nums.length-1;
            while(mid<right){
                if(mid > left+1 && nums[mid] == nums[mid-1]){
                    mid++;
                    continue;
                }
                int sum = nums[mid] + nums[right];
                if(sum < complement)
                    mid++;
                else if(sum > complement)
                    right--;
                else{
                    list.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                    mid++;
                    right--;
                }
            }
        }
        return list;
    }
	
}
