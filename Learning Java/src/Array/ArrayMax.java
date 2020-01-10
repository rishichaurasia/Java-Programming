package Array;

import java.util.Scanner;

public class ArrayMax {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = takeInput();
		displayArray(arr);
		int arr_max = arrayMax(arr);
		System.out.println("Max value in array is " + arr_max);
		
	}
	
	public static void displayArray(int[] arr) {
		for(int val: arr) {
			System.out.println(val);
		}
	}
	
	public static int[] takeInput() {
		System.out.println("Size?");
		int n = scn.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter Values");
		for(int i = 0; i<arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		return arr;
	}
	
	public static int arrayMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int val : arr) {
			if(val>max)
				max=val;
		}
		return max;
	}

}
