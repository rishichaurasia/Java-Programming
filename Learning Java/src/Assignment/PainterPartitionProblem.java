package Assignment;

import java.util.Scanner;

public class PainterPartitionProblem {

	/*
	 * Given K painters to paint N boards where each painter takes 1 unit of time to
	 * paint 1 unit of boards i.e. if the length of a particular board is 5, it will
	 * take 5 units of time to paint the board. Compute the minimum amount of time
	 * to paint all the boards.
	 * 
	 * Note that:
	 * 
	 * Every painter can paint only contiguous segments of boards. A board can only
	 * be painted by 1 painter at maximum. Input Format First line contains K which
	 * is the number of painters. Second line contains N which indicates the number
	 * of boards. Third line contains N space separated integers representing the
	 * length of each board.
	 * 
	 * Constraints 1 <= K <= 10 1 <= N <= 10 1<= Length of each Board <= 10^8
	 * 
	 * Output Format Output the minimum time required to paint the board.
	 * 
	 * Sample Input 
	 * 2 
	 * 2 
	 * 1 10 
	 * Sample Output 
	 * 10
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn = new Scanner(System.in);
		int k = 4;
		int n = 100;
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		long s = System.currentTimeMillis();
		System.out.println(minTime(arr, 0, arr.length - 1, k));
//		System.out.println(partition(arr, n , k));
		long e = System.currentTimeMillis();
		System.out.println(e - s);

	}

	public static int minTime(int[] arr, int lo, int hi, int k) {
		if (lo > hi)
			return 0;
		int i = lo;
		if (k == 1)
			i = hi;
		int minimumTime = Integer.MAX_VALUE;
		int time = 0;
		for (; i <= hi; i++) {
			int arrSum = sumOfArray(arr, lo, i);
			time = Math.max(arrSum, minTime(arr, i + 1, hi, k - 1));
			minimumTime = Math.min(minimumTime, time);
		}
		return minimumTime;
	}

	public static int sumOfArray(int[] arr, int lo, int hi) {
		int sum = 0;
		for (int i = lo; i <= hi; i++) {
			sum += arr[i];
		}
		return sum;
	}

	static int getMax(int arr[], int n) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			if (arr[i] > max)
				max = arr[i];

		return max;
	}

	static int getSum(int arr[], int n) {
		int total = 0;
		for (int i = 0; i < n; i++)
			total += arr[i];
		return total;
	}

	static int numberOfPainters(int arr[], int n, int maxLen) {
		int total = 0, numPainters = 1;
		for (int i = 0; i < n; i++) {
			total += arr[i];
			if (total > maxLen) {
				// for next count
				total = arr[i];
				numPainters++;
			}
		}
		return numPainters;
	}

	static int partition(int arr[], int n, int k) {
		int lo = getMax(arr, n);
		int hi = getSum(arr, n);

		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int requiredPainters = numberOfPainters(arr, n, mid);

			if (requiredPainters <= k)
				hi = mid;

			else
				lo = mid + 1;
		}
		return lo;
	}

}
