package Assignment;

public class ElementLastIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,5,7,3,5,7,4};
		int last_i = elementLastIndex(arr, 0, 7);
		System.out.println(last_i);

	}
	
	public static int elementLastIndex(int[] arr, int index, int ele) {
		if(index == arr.length)
			return -1;
		if(arr[arr.length-index-1] == ele) {
			return arr.length-index-1;
		}
		return elementLastIndex(arr, index+1, ele);
		
	}
	
	public static int elementLastIndex2(int[] arr, int index, int ele) {
		if(index == arr.length)
			return -1;
		int rr =  elementLastIndex(arr, index+1, ele);
		if(arr[index] == ele && rr==-1) {
			return index;
		}
		return rr;
		
	}

}
