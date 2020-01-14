package Assignment;

import java.util.Scanner;

public class Assignment030 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Given a list of numbers, stop processing input after the cumulative sum of all
//		the input becomes negative.
//
//		Input Format
//		A list of integers to be processed
//
//		Constraints
//		All numbers input are integers between -1000 and 1000.
//
//		Output Format
//		Print all the numbers before the cumulative sum become negative.
//
//		Sample Input
//		1
//		2
//		88
//		-100
//		49
//		Sample Output
//		1
//		2
//		88
		
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		while(true) {
			int n = scn.nextInt();
			if(sum+n>=0)
				System.out.println(n);
			else
				break;
			sum+=n;
		}
		

	}

}
