package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class RecursionSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
Take as input str, a string. We are concerned with all the possible subsequences of str. E.g.

a. Write a recursive function which returns the count of subsequences for a given string. Print the value returned.

b. Write a recursive function which prints all possible subsequences for a “abcd” has following subsequences “”, “d”, “c”, “cd”, “b”, “bd”, “bc”, “bcd”, “a”, “ad”, “ac”, “acd”, “ab”, “abd”, “abc”, “abcd”.given string (void is the return type for function).
Note: Use cin for input

Input Format
Enter a string

Constraints
None

Output Format
Display the total no. of subsequences and also print all the subsequences in a space separated manner

Sample Input
abcd
Sample Output
 d c cd b bd bc bcd a ad ac acd ab abd abc abcd 
16
 */
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		ArrayList<String> answer = recur_Subsequence(str);
		for(String val: answer) {
			System.out.print(val+" ");
		}
		
	}
	
	public static ArrayList<String> recur_Subsequence(String str){
		if(str.length()==0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = recur_Subsequence(ros);
		ArrayList<String> mr = new ArrayList<>();
		for(String val: rr) {
			mr.add(val);
		}
		for(String val: rr) {
			mr.add(ch+val);
		}
		return mr;
	}

}
