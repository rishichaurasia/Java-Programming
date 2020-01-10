package Function;

import java.util.Scanner;

public class Decimal2Anybase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int base = scn.nextInt();
		scn.close();
		int answer = decimalToAnybase(n, base);
		System.out.println(answer);
	}
	
	public static int decimalToAnybase(int n , int base) {
		
		int ans = 0;
		for(int pow = 0 ; n>0; n/=base, pow++) {
			int rem = n%base;
			ans = ans + rem * (int) Math.pow(10, pow);
		}
		return ans;
	}

}
