package Assignment;

import java.util.Scanner;

public class TowerofHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		towerOfHanoi(n, "T1", "T2", "T3");
		System.out.println(count);

	}
	
	static int count = 0;
	
	public static void towerOfHanoi(int n, String source, String destination, String auxillary) {
		// T1 - source
		// T2 - destination
		// T3 - auxillary
		if(n==0)
			return;
		count++;
		towerOfHanoi(n-1, source, auxillary, destination);
		System.out.println("Move "+ n + "th disc from " + source + " to " + destination);
		towerOfHanoi(n-1, auxillary, destination, source);
	}

}

