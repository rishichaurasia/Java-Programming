package Array;

public class ArrayBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 12, 23, 34, 45, 48, 54, 63, 69, 77 };
		System.out.println(binarySearch(arr, 54));
	}
	
	public static int binarySearch(int[] arr, int item) {
		int lo = 0;
		int hi = arr.length - 1;
		while(lo <= hi) {
			int mid = (lo+hi)/2;
			if(arr[mid]<item)
				lo = mid+1;
			else if(arr[mid]>item)
				hi = mid-1;
			else
				return mid;
		}
		return -1;
	}

}
