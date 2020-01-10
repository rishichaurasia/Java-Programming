package Function;

import java.util.Scanner;

public class Anybase2decimalconversion {
	
	public static void main(String[] args) {
	
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int base = scn.nextInt();
		scn.close();
		int answer = anybaseToDecimal(n, base);
		System.out.println(answer);
		
	}
	
	public static int anybaseToDecimal(int n, int base) {
		
		int ans = 0;
		for(int pow = 0 ; n>0; n/=10, pow++) {
			int rem = n%10;
			ans = ans + rem * (int) Math.pow(base, pow);
		}
		return ans;
	}
}
