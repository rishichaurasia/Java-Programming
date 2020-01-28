package Assignment;

import java.util.Scanner;

public class MinNumberFromGivenSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Given an array of patterns containing only I’s and D’s. I for increasing and D for decreasing. Devise an algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can’t repeat.
//
//		Input Format
//		The First Line contains an Integer N, size of the array. Next Line contains N Strings separated by space.
//
//		Constraints
//		1 ≤ T ≤ 100 1 ≤ Length of String ≤ 8
//
//		Output Format
//		Print the minimum number for each String separated by a new Line.
//
//		Sample Input
//		4
//		D I DD II
//		Sample Output
//		21
//		12
//		321 
//		123
//		Explanation
//		For the Given sample case, For a Pattern of 'D' print a decreasing sequence which is 2 1.
		
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.next();
		}
		for (int i = 0; i < arr.length; i++) {
			minNumber2(arr[i]);
		}

	}

	public static void minNumber(String s) {
		String num = "";
		int curr_max = 0;
		int lastEntry = 0;
		int j;
		for (int i = 0; i < s.length(); i++) {
			int noOfnextD = 0;
			;
			switch (s.charAt(i)) {
			case 'I':
				j = i + 1;
				while (j < s.length() && s.charAt(j) == 'D') {
					noOfnextD++;
					j++;
				}
				if (i == 0)
					num += ++curr_max;
				curr_max += noOfnextD + 1;
				lastEntry = curr_max;
				num += lastEntry;
				for (int k = 0; k < noOfnextD; k++) {
					num += --lastEntry;
					i++;
				}
				break;
			case 'D':
				j = i + 1;
				noOfnextD = 0;
				while (j < s.length() && s.charAt(j) == 'D') {
					noOfnextD++;
					j++;
				}
				curr_max += noOfnextD + 1;
				if (i == 0) {
					num += ++curr_max;
				}
				lastEntry = curr_max;
				num+= --lastEntry;
				for (int k = 0; k < noOfnextD; k++) {
					num += --lastEntry;
					i++;
				}
				break;
			}

		}

		System.out.println(num);
	}

	public static void minNumber2(String s) {
		int[] res = new int[s.length()+1];
		int number = 1;
		for(int i = 0; i<=s.length(); i++) {
			if(i == s.length() || s.charAt(i) == 'I') {
				res[i] = number++;
				for(int j = i-1; j>=0 && s.charAt(j) == 'D'; j--)
					res[j] = number++;
			}
		}
		for(int val: res)
			System.out.print(val);
		System.out.println();
	}

}
