package DSACollegeGroupQuestions;

public class TernarySearch {

	public static void main(String[] args) {
		int[] arr = { 12, 23, 34, 45, 56, 67, 78, 89, 90, 99 };
		int res = ternarySearch(arr, 0, arr.length - 1, 34);
		System.out.println(res);
	}
	public static int ternarySearch(int[] arr, int left, int right, int num) {
		if(left > right)
			return -1;
		int diff = (right - left)/3;
		int mid1 = left + diff;
		int mid2 = left + 2*diff;
		if(num < arr[mid1])
			return ternarySearch(arr, left, mid1 - 1, num);
		else if(num == arr[mid1])
			return mid1;
		else if(num < arr[mid2])
			return ternarySearch(arr, mid1 + 1, mid2 - 1, num);
		else if(num == arr[mid2])
			return mid2;
		else if(num <= arr[right])
			return ternarySearch(arr, mid2 + 1, right, num);
		else
			return -1;
	}

}
