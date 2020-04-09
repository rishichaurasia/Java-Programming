package BitManipulation;

/*
 * Each number is occuring twice except one number in an array.
 * Find that number. 
 */

public class FindNum {

	public static void main(String[] args) {
		int[] arr = { 2, 1, 1, 3, 4, 4, 2};
		System.out.println(findNum(arr));
		System.out.println(isEven(4));
		System.out.println(extrackBit(9, 2));
		System.out.println(setBit(5, 2));
		System.out.println(resetBit(7, 2));
		System.out.println(rightmostSetBit(52));
		System.out.println(increment(9));
		System.out.println(checkIfPowerOf2(8));
	}
	
	public static int findNum(int[] arr) {
		/*
		 * Each number is occuring twice except one number in an array.
		 * Find that number. 
		 */
		// Return the number which is occuring odd number of times.
		int num = arr[0];
		for(int i = 1; i<arr.length; i++)
			num = num ^ arr[i];
		return num;
	}
	
	public static boolean isEven(int n) {
		// To check if even
		return (n & 1) == 0;
	}
	
	public static int extrackBit(int n, int ith) {
		// To extract ith bit from left.
		int m = 1 << (ith-1);  // This is called bitmasking. m is called mask.
		n = n & m;
		return (n == 0 ? 0 : 1);
	}
	
	public static int setBit(int n, int i) {
		// To set(1) the ith bit of a number.
		int mask = 1 << (i - 1);
		return n | mask;
	}
	
	public static int resetBit(int n, int i) {  
		// To reset(0) the ith bit of a number.
				int mask = ~(1 << (i - 1)); // mask = 100
				return n & mask;   // 0010101 & 1111011 = 10001
	}
	
	public static int rightmostSetBit(int n) {
		int mask = 1;
		int i = 1;
		while((n & mask) == 0) {
			mask = mask << 1;
			i++;
		}
		return i;
	}
	
	public static int increment(int n) {
		int mask = 1;
		while((n & mask) != 0) {
			n = n ^ mask;
			mask = mask << 1;
		}
		n = n ^ mask;
		return n;
	}
	
	public static boolean checkIfPowerOf2(int n) {
		if(n == 0)
			return false; 
		return (n & (n-1)) == 0;
	}

}
