package LeetCode_July_Challenge.Week_1;

public class Arranging_coins {

//	O(logn) Time | O(1) space
	public int arrangeCoins(int n) {
		long left = 1;
		long right = n;
		while (left <= right) {
			long mid = (left + right) / 2;
			long currSum = mid * (mid + 1) / 2;
			if (currSum < n)
				left = mid + 1;
			else if (currSum > n)
				right = mid - 1;
			else
				return (int) mid;
		}
		return (int) left - 1;
	}

//	O(1) Time | O(1) space
	public int arrangeCoins1(int n) {
		return (int) (Math.sqrt(2 * (long) n + 0.25) - 0.5);
	}

//	O(1) Time | O(1) space
	public int arrangeCoins2(int n) {
		return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
	}

}
