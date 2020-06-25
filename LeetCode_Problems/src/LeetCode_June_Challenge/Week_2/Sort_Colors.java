package LeetCode_June_Challenge.Week_2;

public class Sort_Colors {
	public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1)
            return;
        int red = 0;
        int blue = nums.length-1;
        int idx = 0;
        while(idx <= blue){
            if(nums[idx] == 0){
                nums[idx] = nums[red];
                nums[red] = 0;
                red++;
                idx++;
            }else if(nums[idx] == 2){
                nums[idx] = nums[blue];
                nums[blue] = 2;
                blue--;
            }else{
                idx++;
            }
        }
    }
}
