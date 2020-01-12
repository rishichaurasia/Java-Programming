package Lec5;

public class ArraySubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30 };
		printArraySubsets(arr);
	}
	
	public static void printArraySubsets(int[] arr) {
		int limit =(int) Math.pow(2, arr.length);
		for(int n = 0; n<limit; n++) {
			int temp = n;
			for(int i = 0; i<arr.length; i++) {
				int rem = temp%2;
				if(rem == 1)
					System.out.print(arr[i] + " ");
				temp/=2;
			}
			System.out.println();
		}
	}

}
