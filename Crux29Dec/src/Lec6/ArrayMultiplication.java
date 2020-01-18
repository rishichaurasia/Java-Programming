package Lec6;

public class ArrayMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] arr2 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		int[][] mul = multiply(arr1, arr2);
		display(mul);
	}

	public static int[][] multiply(int[][] arr1, int[][] arr2) {
		int[][] mul = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < mul.length; i++) {
			for (int j = 0; j < mul[i].length; j++) {
				int sum = 0;
				for (int j2 = 0; j2 < arr1[i].length; j2++) {
					sum += arr1[i][j2] * arr2[j2][j];
				}
				mul[i][j] = sum;
			}
		}

		return mul;
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
