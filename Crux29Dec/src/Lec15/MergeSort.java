package Lec15;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 7, 8, 6, 9, 3, 2, 5, 4 };
		int[] merge = mergeSort(arr, 0, arr.length - 1);
		for (int val : merge)
			System.out.println(val);

	}

	// Best : O(nlogn) Time | O(nlogn) Space
	// Average : O(nlogn) Time | O(nlogn) Space
	// Worst : O(nlogn) Time | O(nlogn) Space
	public static int[] mergeSort(int[] arr, int low, int high) {
		if (low == high) {
			int[] br = new int[1];
			br[0] = arr[low];
			return br;
		}
		int mid = (low + high) / 2;
		int[] fh = mergeSort(arr, low, mid);
		int[] sh = mergeSort(arr, mid + 1, high);
		return merge2sortedArray(fh, sh);
	}
	
	public static int[] merge2sortedArray(int[] one, int[] two) {
		int[] res = new int[one.length + two.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j])
				res[k++] = one[i++];
			else
				res[k++] = two[j++];
		}
		while (i < one.length) {
			res[k++] = one[i++];
		}
		while (j < two.length) {
			res[k++] = two[j++];
		}
		return res;
	}

}
