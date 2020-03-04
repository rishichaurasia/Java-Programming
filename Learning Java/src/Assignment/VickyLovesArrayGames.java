package Assignment;

import java.util.Scanner;

public class VickyLovesArrayGames {

	/*
	 * Vivek loves to play with array . One day Vivek just came up with a new array
	 * game which was introduced to him by his friend Ujjwal. The rules of the game
	 * are as follows:
	 * 
	 * Initially, there is an array, A , containing 'N' integers.
	 * 
	 * In each move, Vivek must divide the array into two non-empty contiguous parts
	 * such that the sum of the elements in the left part is equal to the sum of the
	 * elements in the right part. If Vivek can make such a move, he gets '1' point;
	 * otherwise, the game ends.
	 * 
	 * After each successful move, Vivek have to discards either the left part or
	 * the right part and continues playing by using the remaining partition as
	 * array 'A'.
	 * 
	 * Vivek loves this game and wants your help getting the best score possible.
	 * Given 'A', can you find and print the maximum number of points he can score?
	 * 
	 * Input Format First line of input contains an integer T denoting number of
	 * test cases. Each further Test case contains first line an integer 'N' , the
	 * size of array 'A'. After that 'N' space separated integers denoting the
	 * elements of array.
	 * 
	 * Constraints 1 <= T <= 10 1 <= N <= 17000 0 <= A[i] <= 10^9
	 * 
	 * Output Format For each test case, print Vivek's maximum possible score on a
	 * new line.
	 * 
	 * Sample Input 
	 * 3
	 * 3
	 * 3 3 3
	 * 4
	 * 2 2 2 2
	 * 7
	 * 4 1 0 1 1 0 1 
	 * 
	 * Sample Output 
	 * 0
	 * 2
	 * 3
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-->0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			System.out.println(arraySplits(arr, 0, arr.length-1));
		}
		

	}
	
	public static int maxPoint(int[] arr, int lo, int high) {
		if(lo >= high)
			return 0;
		int left = lo;
		int right = high;
		int lsum = 0;
		int rsum = 0;
		while(left<=right) {
			int x = arr[left];
			int y = arr[right];
			if(lsum<=rsum) {
				lsum+=arr[left++];
			}else {
				rsum+=arr[right--];
			}
		}
		if(lsum != rsum)
			return 0;
		int c1 = maxPoint(arr, lo, right);
		int c2 = maxPoint(arr, left, high);
		return Math.max(c1,c2)+1;
	}
	
	public static int arraySplits(int[] arr, int lo, int hi) {
		int i;
		for(i=lo; i<hi; i++) {
			if(sumOfArray(arr, lo, i) == sumOfArray(arr, i+1, hi)) {
				int c1 = arraySplits(arr, lo, i);
				int c2 = arraySplits(arr, i+1, hi);
				return Math.max(c1, c2) + 1;
			}
		}
		return 0;
		
	}
	
	public static int sumOfArray(int[] arr, int lo, int hi) {
		int sum = 0;
		for(int i = lo; i<=hi; i++) {
			sum+=arr[i];
		}
		return sum;
	}

}
