package July_Long_Challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
//import java.util.stream.IntStream;

public class Chefina_and_Strings {

	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		int t = scn.nextInt();
//		System.out.println(Integer.MAX_VALUE);
		while(t-- > 0) {
			System.out.println(countSwaps());
			
		}

	}
	
	public static long countSwaps() {
		int n = scn.nextInt();
		HashMap<Integer,Integer> map1 = new HashMap<>();
		HashMap<Integer,Integer> map2 = new HashMap<>();
		long min = Integer.MAX_VALUE;
		for(int i = 0; i<n; ++i) {
			int num = scn.nextInt();
			int c = map1.getOrDefault(num, 0);
			map1.put(num, c+1);
			if(num < min)
				min = num;
		}
//		System.out.println(map1);
		for(int i = 0; i<n; ++i) {
			int num = scn.nextInt();
			int c = map1.getOrDefault(num, 0);
			if(c == 0) {
				int c1 = map2.getOrDefault(num, 0);
				map2.put(num, c1+1);
			}else if(c == 1)
				map1.remove(num);
			else
				map1.put(num, c-1);
			if(num < min)
				min = num;
		}
		int[] ar1 = new int[map1.size()];
		int i = 0;
		for(int key: map1.keySet()) {
			ar1[i++] = key;
		}
		int[] ar2 = new int[map2.size()];
		i = 0;
		for(int key: map2.keySet()) {
			ar2[i++] = key;
		}
//		System.out.println(map1);
//		System.out.println(map2);
		Arrays.sort(ar1);
		Arrays.sort(ar2);
//		IntStream.of(ar1).forEach(x -> System.out.println(x));
//		IntStream.of(ar2).forEach(x -> System.out.println(x));
		i = 0; 
		int j = ar2.length-1;
		long minCost = 0;
		min = 2*min;
		while(i < ar1.length && j>=0) {
			int c1 = map1.get(ar1[i]);
			int c2 = map2.get(ar2[j]);
			if((c1&1) == 1 || (c2&1) == 1)
				return -1;
			long unitCost = Math.min(Math.min(ar1[i], ar2[j]), min);
			if(c1 < c2) {
				minCost += unitCost * c1/2;
				map1.remove(ar1[i]);
				map2.put(ar2[j], c2-c1);
				++i;
			}else if(c2 < c1) {
				minCost += unitCost * c2/2;
				map2.remove(ar2[j]);
				map1.put(ar1[i], c1-c2);
				--j;
			}else {
				minCost += unitCost * c2/2;
				map2.remove(ar2[j]);
				map1.remove(ar1[i]);
				--j; ++i;
			}
		}
		return minCost;

	}

}
