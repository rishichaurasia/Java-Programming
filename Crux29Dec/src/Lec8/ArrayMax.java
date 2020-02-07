package Lec8;

public class ArrayMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 80, 30, 40, 30, 90 };
		System.out.println(maximumArray1(arr, 0));

	}
	
	public static int maximumArray1(int[] arr, int i) {
		if(i == arr.length)
			return Integer.MIN_VALUE;
		return Math.max(arr[i],maximumArray1(arr, i+1));
	}
	
	public static int maximumArray2(int[] arr, int idx) {

		if (idx == arr.length - 1) {
			return arr[idx];
		}

		int maxTillNow = maximumArray2(arr, idx + 1);

		if (arr[idx] > maxTillNow) {
			return arr[idx];
		} else {
			return maxTillNow;
		}

	}

}
