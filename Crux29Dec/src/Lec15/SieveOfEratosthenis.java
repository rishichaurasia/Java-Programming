package Lec15;

import java.util.Arrays;

public class SieveOfEratosthenis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		SOE(100);
		long stop = System.currentTimeMillis();
		System.out.println(stop - start);

	}
	
	public static void SOE(int n) {
		
		/*
		 complexity:-
		 n/2+n/3+n/5+n/7+n/11.....  sum of reciprocals of primes
		 = nlog(log n)
		 */
		
		boolean[] primes = new boolean[n+1];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;
		for(int table = 2; table*table<=n; table++) {
			if(primes[table]==true) {
				for(int mul = 2; mul*table<=n; mul++) {
					primes[table*mul] = false;
				}
			}
		}
		for (int i = 0; i < primes.length; i++) {
			if(primes[i])
				System.out.println(i);
		}
		
	}

}
