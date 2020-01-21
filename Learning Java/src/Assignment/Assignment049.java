package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment049 {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Deepak has a limited amount of money that he can spend on his girlfriend. So he decides to buy two roses for her. Since roses are of varying sizes, their prices are different. Deepak wishes to completely spend that fixed amount of money on buying roses for her.
//		As he wishes to spend all the money, he should choose a pair of roses whose prices when summed up are equal to the money that he has.
//		Help Deepak choose such a pair of roses for his girlfriend.
//
//		NOTE: If there are multiple solutions print the solution that minimizes the difference between the prices i and j. After each test case, you must print a blank line.
//
//		Input Format
//		The first line indicates the number of test cases T.
//		Then, in the next line, the number of available roses, N is given.
//		The next line will have N integers, representing the price of each rose, a rose that costs less than 1000001.
//		Then there is another line with an integer M, representing how much money Deepak has.
//		There is a blank line after each test case.
//
//		Constraints
//		1≤ T ≤100
//		2 ≤ N ≤ 10000
//		Price[i]<1000001
//
//		Output Format
//		For each test case, you must print the message: ‘Deepak should buy roses whose prices are i and j.’, where i and j are the prices of the roses whose sum is equal do M and i ≤ j. You can consider that it is always possible to find a solution. If there are multiple solutions print the solution that minimizes the difference between the prices i and j.
//
//		Sample Input
//		2
//		2
//		40 40
//		80
//
//		5
//		10 2 6 8 4
//		10
//		Sample Output
//		Deepak should buy roses whose prices are 40 and 40.
//		Deepak should buy roses whose prices are 4 and 6.
//		Explanation
//		Find two such kinds of price of roses which has sum up to equal to Deepak's Money.

		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt();
			}
			int m = scn.nextInt();
			roseSelect(arr, m);
			t--;
		}

	}

	public static void roseSelect(int[] arr, int m) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length - 1;
		int i = 0, j = 0;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == m) {
				i = left;
				j = right;
				left++;
				right--;
			} else if (sum < m)
				left++;
			else
				right--;
		}

		System.out.println("Deepak should buy roses whose prices are " + arr[i] + " and  " + arr[j] + ".\n");

	}
}
