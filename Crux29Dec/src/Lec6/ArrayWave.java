package Lec6;

public class ArrayWave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 10, 20, 30, 40, 50 }, { 60, 70, 80, 90, 100 }, { 110, 120, 130, 140, 150 },
				{ 160, 170, 180, 190, 200 } };
		printArrayWave(arr);
	}

	public static void printArrayWave(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			for (int row = 0; row < arr.length; row++) {
				if (col % 2 == 0)
					System.out.print(arr[row][col] + " ");
				else
					System.out.print(arr[arr.length - 1 - row][col] + " ");
			}
		}
	}

}
