package Array;

public class Rotate_Array {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;  // To the right
		rotate(nums, k);
		for(int num: nums)
			System.out.print(num + " ");

	}
	
	// Reversal Algorithm
	public static void rotate(int[] nums, int k) {
        k%=nums.length;
     // Reverse first n-k elements
        reverse(nums,0,nums.length-1);
     // Reverse remaining k elements
        reverse(nums,0,k-1);
     // Reverse whole array
        reverse(nums,k,nums.length-1);
    }
    public static void reverse(int[] nums, int s, int e){
        while(s < e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }

}
