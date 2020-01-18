package Lec6;

public class ArraySpiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		printArraySpiral(arr);
	}

	public static void printArraySpiral(int[][] arr) {

		int minRow = 0;
		int maxRow = arr.length - 1;
		int minCol = 0;
		int maxCol = arr[0].length - 1;
		int total = arr.length * arr[0].length;
		int count = 0;
		while (count < total) {
			for (int r = minRow; r <= maxRow && count < total; r++, count++)
				System.out.print(arr[r][minCol] + " ");
			minCol++;
			for (int c = minCol; c <= maxCol && count < total; c++, count++)
				System.out.print(arr[maxRow][c] + " ");
			maxRow--;
			for (int r = maxRow; r >= minRow && count < total; r--, count++)
				System.out.print(arr[r][maxCol] + " ");
			maxCol--;
			for (int c = maxCol; c >= minCol && count < total; c--, count++)
				System.out.print(arr[minRow][c] + " ");
			minRow++;
		}
	}

}
