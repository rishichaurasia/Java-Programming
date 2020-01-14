package Assignment;

import java.util.Scanner;

public class Assignment022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Take N as input. Print the sum of its odd placed digits and sum of its even 
//		placed digits.
//
//		Input Format
//		Constraints
//		0 < N <= 1000000000
//
//		Output Format
//		Sample Input
//		2635
//		Sample Output
//		11
//		5
//		Explanation
//		5 is present at 1st position, 3 is present at 2nd position, 6 is present 
//		at 3rd position and 2 is present at 4th position.
//
//		Sum of odd placed digits on first line. 5 and 6 are placed at odd position. 
//		Hence odd place sum is 5+6=11
//
//		Sum of even placed digits on second line. 3 and 2 are placed at even position. 
//		Hence even place sum is 3+2=5
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] sum = sumOddEvenPlaces(n);
		System.out.println(sum[1] + "\n" + sum[0]);
		
		
	}
	
	public static int[] sumOddEvenPlaces(int n) {
		int[] sum = new int[2];
		for(int i = 1; n>0; n/=10, i++) {
			int rem = n%10;
			if(i%2==0)
				sum[0]+=rem;
			else
				sum[1]+=rem;
		}
		return sum;
	}

}
