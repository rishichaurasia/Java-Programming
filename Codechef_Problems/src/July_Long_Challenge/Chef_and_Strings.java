package July_Long_Challenge;

import java.util.Scanner;

public class Chef_and_Strings {

	static Scanner scn = new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
		int t = scn.nextInt();
		while(t-- > 0){
		    int n = scn.nextInt();
		    int total = 0;
		    int curr = scn.nextInt(), next = 0;
		    for(int i = 2; i<=n; ++i){
		        next = scn.nextInt();
		        int skip = Math.abs(next - curr);
		        if(skip != 0)
		            total += skip-1;
		        curr = next;
		    }
		    System.out.println(total);
		}
	}

}
