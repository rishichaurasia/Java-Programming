package SearchingAndSorting;

import java.util.Random;
import java.util.stream.IntStream;

public class Randomized_Qsort {
	
	static final Random rand = new Random();

	public static void main(String[] args) {
		
		int[] arr = new int[] {2,7,3,6,3,8,6,2,4,1};
		randomizedQsort(arr, 0, arr.length-1);
		IntStream.of(arr).forEach(x -> System.out.print(x + " "));

	}

	private static void randomizedQsort(int[] arr, int p, int r) {
		if(p<r) {
			int q = partition(arr, p, r);
			randomizedQsort(arr, p, q-1);
			randomizedQsort(arr, q+1, r);
		}
	}

	private static int partition(int[] arr, int p, int r) {
		int i = p + rand.nextInt(r-p+1);
		int x = arr[i];
		arr[i] = arr[r];
		arr[r] = x;
		for(int j = p; j<r; j++) {
			if(arr[j] <= x) {
				int temp = arr[j];
				arr[j] = arr[p];
				arr[p] = temp;
				p++;
			}
		}
		arr[r] = arr[p];
		arr[p] = x;
		return p;
	}


}
