package Array;

public class MinSubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {8, -8, 9, -9, 10, -11, 12};
		int minSum = minSubArraySum(arr);
		System.out.println(minSum);
	}
	
	public static int minSubArraySum(int[] arr) {
		int min_ending_here = arr[0];
		int min_so_far = arr[0];
		for(int i = 1; i<arr.length; i++) {
			min_ending_here = Math.min(arr[i], min_ending_here + arr[i]);
			min_so_far = Math.min(min_so_far, min_ending_here);
		}
		return min_so_far;
	}

}
