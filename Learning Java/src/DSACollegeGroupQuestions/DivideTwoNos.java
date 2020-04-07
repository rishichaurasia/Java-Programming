package DSACollegeGroupQuestions;

import java.text.Format;
import java.util.Scanner;

public class DivideTwoNos {

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter Dividend");
		int m = scn.nextInt();
		System.out.println("Enter Divisor");
		int n = scn.nextInt();
		int[] res = divide(m, n);
		System.out.println("Quotient = " + res[0] + "\nRemainder = " + res[1]);
		
	}
	
	public static int[] divide(int dividend, int divisor) throws Exception {
		if(divisor == 0)
			throw new Exception("ZeroDivisionError");
		int[] quotRem = {0, 0};
		if(divisor == 0)
			return quotRem;
		int sign = 1;
		if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
			sign = -1;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		while(dividend >= divisor) {
			dividend -= divisor;
			quotRem[0]++;
		}
		quotRem[0] *= sign;
		quotRem[1] = dividend;
		return quotRem;
	}

}
