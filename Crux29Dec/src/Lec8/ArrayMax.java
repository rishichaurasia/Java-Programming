package Lec8;

public class ArrayMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 80, 30, 40, 30, 90 };
		System.out.println(max(arr, 0));

	}
	
	public static int max(int[] arr, int i) {
		if(i == arr.length)
			return Integer.MIN_VALUE;
		return Math.max(arr[i],max(arr, i+1));
	}

}
