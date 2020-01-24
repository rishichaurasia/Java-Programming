package Array;

public class MaxSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int maxSum = maxSubArraySum(arr);
		System.out.println(maxSum);
	}
	
	public static int maxSubArraySum(int[] arr) {
		int max_ending_here = arr[0];
		int max_so_far = arr[0];
		for(int i = 1; i<arr.length; i++) {
			max_ending_here = Math.max(arr[i], max_ending_here + arr[i]);
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		return max_so_far;
	}

}
