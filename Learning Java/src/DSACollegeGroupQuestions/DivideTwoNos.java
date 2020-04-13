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
//		int[] res = divide(m, n);
//		System.out.println("Quotient = " + res[0] + "\nRemainder = " + res[1]);
//		long s1 = System.currentTimeMillis();
//		System.out.println(divideBW(m, n));
//		long e1 = System.currentTimeMillis();
//		System.out.println(e1-s1);
		long s2 = System.currentTimeMillis();
		System.out.println(divideBW1(m, n));
		long e2 = System.currentTimeMillis();
		System.out.println(e2-s2);
	}
	
	public static int[] divide(int dividend, int divisor) throws Exception {
		if(divisor == 0)
			throw new Exception("ZeroDivisionError");
		int[] quotRem = {0, 0};
		if(dividend == 0)
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
	
//	public static int divideBW(int dividend, int divisor) throws Exception {
//		if(divisor == 0)
//			throw new Exception("ZeroDivisionError");
//		int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
//		int dvd = Math.abs(dividend);
//		int dvs = Math.abs(divisor);
//		int q = 0;
//		for(int i = 31 ; i>=0; i--) {
//			int temp = dvs << i;
//			if (dvd >= temp && temp >= dvs)  
//		    {    
//		        dvd -= temp;
//				q += (1 << i);  
//		    } 
//		}
//		return sign * q;
//	}
	
	public static int divideBW1(int dividend, int divisor) throws Exception {
		if(divisor == 0)
			throw new Exception("ZeroDivisionError");
		int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
		int dvd = Math.abs(dividend);
		int dvs = Math.abs(divisor);
		int q = 0;
		while(dvd >= dvs) {
			int r = 0;
			int tdvs = dvs;
			while(dvd >= (tdvs << 1)) {
				tdvs = tdvs << 1;
				r++;
			}
			q += (1 << r);
			dvd -= tdvs;
		}
		return sign * q;
	}

}
