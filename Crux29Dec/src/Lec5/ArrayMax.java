package Lec5;

public class ArrayMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 12, 34, 23, 56, 24 };
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		System.out.println(max);
	}

}
