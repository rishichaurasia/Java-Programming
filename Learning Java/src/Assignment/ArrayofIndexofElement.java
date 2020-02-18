package Assignment;

public class ArrayofIndexofElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 100, 5, 60, 30, 15, 30, 30 };
		int[] res = allIndexofElement(arr, 0, 30, 0);
		for (int val: res) {
			System.out.print(val + " ");
		}

	}
	
	public static int[] allIndexofElement(int[] arr, int idx, int ele, int count ) {
		if(idx == arr.length) {
			int[] br = new int[count];
			return br;
		}
		int[] rr = null;
		if(arr[idx] == ele) {
			rr = allIndexofElement(arr, idx+1, ele, count+1);
			rr[count] = idx;
		}else {
			rr = allIndexofElement(arr, idx+1, ele, count);
		}
		return rr;
		
	}

}
