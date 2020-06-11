package Arrays;

public class Move_Elements_to_End {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 5, 5, 3, 4, 6, 7, 5, 8, 9, 10, 11, 5, 5, 12 };
		int toMove = 5;
		sol1(arr, toMove);
		for (int num : arr)
			System.out.print(num + " ");
	}

	public static void sol1(int[] arr, int num) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			while (i < j && arr[j] == num)
				j--;
			if (arr[i] == num) {
				arr[i] = arr[j];
				arr[j] = num;
				j--;
			}
			i++;
		}
	}
}
