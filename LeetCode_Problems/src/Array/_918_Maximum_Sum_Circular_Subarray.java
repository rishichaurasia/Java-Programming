package Array;

public class _918_Maximum_Sum_Circular_Subarray {
	public int maxSubarraySumCircular(int[] A) {

		int n = A.length;

		int currMax = 0;
		int maxSoFar = Integer.MIN_VALUE;

		int currMin = 0;
		int minSoFar = Integer.MAX_VALUE;

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += A[i];
			// Kadane on actual
			currMax = Math.max(currMax, 0) + A[i];
			if (currMax > maxSoFar)
				maxSoFar = currMax;

			// Kadane on Inverse
			currMin = Math.min(currMin, 0) + A[i];
			if (currMin < minSoFar)
				minSoFar = currMin;
		}

		return maxSoFar < 0 ? maxSoFar : Math.max(maxSoFar, sum - minSoFar);
	}
}
