package Lec3;

import java.util.Scanner;

public class Rotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int r_count = scn.nextInt();
		
		int m = n, nod = 0;
		while(m>0) {
			nod++;
			m/=10;
		}
		r_count = r_count%nod;
		if(r_count<0)
			r_count += nod;
		int rem = n%(int) Math.pow(10, r_count);
		int part = n/(int) Math.pow(10, r_count);
		int ans = rem*(int)Math.pow(10, nod - r_count) + part;
		System.out.println(ans);
		
	}

}
