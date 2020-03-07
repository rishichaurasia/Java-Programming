package Assignment;

import java.util.Scanner;

public class MaxIntegerWithAtmostKSwaps {
	
	/*
	 * Given a positive integer, find maximum integer possible by doing at-most K swap operations on its digits.

Input Format
Two positive integers N and K where N denotes the number on which swaps are supposed to be performed and K denotes the maximum swaps available.

Constraints
0 <= N <= 10^12 0 <= K <= 10

Output Format
Single Maximum integer possible by doing at-most K swap operations on digits of N

Sample Input
254 1
Sample Output
524
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String n = scn.next();
		int k = scn.nextInt();
//		char[] charr = n.toCharArray();
//		String max = maxNumWithKswaps(charr, k, n);
//		System.out.println(max);
		String max = maxNum(n, k, n);
		System.out.println(max);
		
	}
	
	public static String maxNumWithKswaps(char[] charr, int k, String max) {
		
		if(k==0) {
			return max;
		}
		
		for(int i = 0; i<charr.length-1; i++) {
			for(int j = i+1; j<charr.length; j++) {
				if(charr[i]<charr[j]) {
					swap(charr, i, j);
					String str = String.valueOf(charr);
					if(str.compareTo(max) > 0)
						max = str;
					max = maxNumWithKswaps(charr, k-1, max);
					swap(charr, i, j);
				}
			}
		}
		return max;
		
	}
	
	public static void swap(char[] charr, int i, int j) {
		char temp = charr[i];
		charr[i] = charr[j];
		charr[j] = temp;
	}
	
	public static String maxNum(String str, int k, String max) {
		if(k==0)
			return max;
		for(int i = 0; i < str.length()-1; i++) {
			for(int j = i+1; j<str.length(); j++) {
				if(str.charAt(i)<str.charAt(j)) {
					str = swap(str, i, j);
					if(str.compareTo(max)>0) {
						max = str;
					}
					max = maxNum(str, k-1, max);
					str = swap(str, i, j);
				}
			}
		}
		return max;
	}
		
	public static String swap(String str, int i, int j) {
		return str.substring(0, i) + str.charAt(j) + str.substring(i+1, j) + str.charAt(i) + str.substring(j+1);
	}
	
	/*
	 public static String BiggestNum(char[] arr, int k) {

        long max = Integer.valueOf(new String(arr));
        if (k == 0)
            return max + "";

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] > arr[i]) {
                    //Swap Original Elements
                    swap(arr, i, j);

                    //Store the ans from recursive call
                    long rec = Integer.valueOf(BiggestNum(arr, k - 1));

                    //Update the max number
                    max = Math.max(max, rec);

                    //Undo the Swap
                    swap(arr, i, j);
                }
            }
        }

        return max + "";

    }

    public static void swap(char[] arr, int ith, int jth) {

        char temp = arr[ith];
        arr[ith] = arr[jth];
        arr[jth] = temp;
    }

	 */

}
