package Assignment;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaUnderHistogram {

	/*
	 * Find the largest rectangular area possible in a given histogram where the
	 * largest rectangle can be made of a number of contiguous bars.
	 * 
	 * 
	 * Input Format First line contains a single integer N, denoting the number of
	 * bars in th histogram. Next line contains N integers, ith of which, denotes
	 * the height of ith bar in the histogram.
	 * 
	 * Constraints 1<=N<=10^6 Height of each bar in histogram <= 10^9
	 * 
	 * Output Format Output a single integer denoting the area of the required
	 * rectangle.
	 * 
	 * Sample Input 
	 * 5 
	 * 1 2 3 4 5 
	 * 
	 * Sample Output 
	 * 9
	 */

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(largestArea(arr));
		
	}
	
	public static long largestArea(int[] arr) {
		
		Stack<Integer> stack = new Stack<>();
		long maxArea = 0;
		long area = 0;
		int i = 0;
		while(i<arr.length) {
			
			if(stack.isEmpty() || arr[stack.peek()]<=arr[i]) {
				stack.push(i++);
			}else {
				int top = stack.pop();
				if(stack.isEmpty())
					area = (long)arr[top] * i;
				else
					area= (long)arr[top] * (i - stack.peek() - 1);
				maxArea = Math.max(area, maxArea);
			}
			
		}
		while(!stack.isEmpty()) {
			int top = stack.pop();
			if(stack.isEmpty())
				area = (long)i*arr[top];
			else
				area= (long)arr[top] * (i - stack.peek() - 1);
			maxArea = Math.max(area, maxArea);
		}
		return maxArea;
		
	}

}
