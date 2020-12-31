package Array;

import java.util.Scanner;

public class Factorial_of_a_large_number {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		factorial(n);

	}

	private static void factorial(int n) {
		
		int[] res = new int[2000];
		int res_size = 1;
		res[0] = 1;
		
		for(int i = 1; i<= n; i++) {
			res_size = multiply(i, res, res_size);
		}
		
		for(int i = res_size-1; i>=0; i--) {
			System.out.print(res[i]);
		}
		
	}

	private static int multiply(int x, int[] res, int res_size) {
		int carry = 0;
		
		for(int i = 0; i<res_size; i++) {
			int prod = x*res[i] + carry;
			res[i] = prod%10;
			carry = prod/10;
		}
		
		while(carry != 0) {
			res[res_size++] = carry%10;
			carry /= 10;
		}
		
		return res_size;
	}

}
