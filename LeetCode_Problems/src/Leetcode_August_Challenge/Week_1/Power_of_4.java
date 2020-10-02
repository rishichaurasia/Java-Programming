package Leetcode_August_Challenge;

public class Power_of_4 {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16));

	}

	// O(logn)
	public static boolean isPowerOfFour(int num) {
		if (num < 1)
			return false;
		int n = num, count = 0;

		while (n > 1) {
			n >>= 2;
			count += 2;
		}

		return n << count == num;
	}
	
	// O(1)
	public static boolean isPowerOfFour1(int num) {

		return (num & (num - 1)) == 0 && num % 3 == 1;

	}
	
	// O(1)
	public boolean isPowerOfFour2(int num) {

		return (num > 0) && (num & (num - 1)) == 0 && (num & 0xaaaaaaaa) == 0;

	}

}
