package June_Challenge_2020;

import java.util.Scanner;

public class Chef_and_Price_Control {

	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int t = scn.nextInt();
		while(t-- > 0){
		    loss();
		}

	}

	public static void loss(){
	    
		int n = scn.nextInt();
	    int k = scn.nextInt();
	    int sum = 0;
	    for(int i = 0; i<n; i++) {
	        int price = scn.nextInt();
	        sum += Math.max(0, price-k);
	    }
        System.out.println(sum);
	}
	
}
