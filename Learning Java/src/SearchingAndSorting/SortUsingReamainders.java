package SearchingAndSorting;

public class SortUsingReamainders {

	public static void main(String[] args) {

		int[] arr = { 1, 5, 7, 8, 6, 9, 3, 2, 5, 4 };
		int divisor = 5;
		int[] merge = mergeSort(arr, 0, arr.length - 1, divisor);
		for (int val : merge)
			System.out.print(val + " ");

	}

	public static int[] merge2sortedArray(int[] one, int[] two, int dvs) {
		int[] res = new int[one.length + two.length];
		int i = 0; // Iterate over array one
		int j = 0; // iterate over array two
		int k = 0; // Iterate over array res
		while (i < one.length && j < two.length) {
			int remi = one[i] % dvs;
			int remj = two[j] % dvs;
			if(remi < remj)
				res[k++] = one[i++];
			else if(remi > remj)
				res[k++] = two[j++];
			else {
				if (one[i] < two[j])
					res[k++] = one[i++];
				else
					res[k++] = two[j++];
			}
		}
		while (i < one.length) {
			res[k++] = one[i++];
		}
		while (j < two.length) {
			res[k++] = two[j++];
		}
		return res;
	}

	public static int[] mergeSort(int[] arr, int low, int high, int dvs) {
		if (low == high) {
			int[] br = new int[1];
			br[0] = arr[low];
			return br;
		}
		int mid = (low + high) / 2;
		int[] fh = mergeSort(arr, low, mid, dvs);
		int[] sh = mergeSort(arr, mid + 1, high, dvs);
		return merge2sortedArray(fh, sh, dvs);
	}

}
