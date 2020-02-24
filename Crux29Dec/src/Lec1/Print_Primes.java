package Lec1;

import java.util.Scanner;

public class Print_Primes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long start = System.currentTimeMillis();
        if(n>=2){
            System.out.println(2);
        }
        int j=3;
        while(j<=n){
            int i=3,flag=1;
            while(i<=Math.sqrt(j)){
                if(j%i==0){
                    flag = 2;
                    break;
                }
                i+=2;
            }
            if(flag==1){
                System.out.println(j);
            }
            j+=2;
        }
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);

	}

}
