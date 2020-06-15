package June_Challenge_2020;

import java.util.Scanner;

public class Tom_and_Jerry_Game {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0){
		    long TS = scn.nextLong();
		    System.out.println(getJSCount(TS));
		}

	}
	
	public static long getJSCount(long TS) {
		while((TS&1) == 0) {
			TS = TS >> 1;
		}
		return TS>>1;
	}

}