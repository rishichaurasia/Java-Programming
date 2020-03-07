package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class DictionaryOrderSmaller {
	
/*
 * Take as input str, a string. Write a recursive function which returns all the words possible by rearranging the characters of this string which are in dictionary order smaller than the given string. The output strings must be lexicographically sorted.

Input Format
Single line input containing a string

Constraints
Length of string <= 25

Output Format
Display all the words which are in dictionary order smaller than the string entered in a new line each. The output strings must be sorted.

Sample Input
cab
Sample Output
abc
acb
bac
bca
Explanation
The possible permutations of string "cab" are "abc" , "acb" ,"bac" , "bca" , "cab" and "cba" . Only four of them are lexicographically less than "cab". We print them in lexicographical order.
 */

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		
		printLargerWords(new String(arr), str, "");
		
	}
	
	public static void printLargerWords(String sorted_str, String str, String ans) {
		if(sorted_str.length()==0) {
			if(ans.compareTo(str) < 0)
				System.out.println(ans);
			return;
		}
		for(int i = 0; i<sorted_str.length(); i++) {
			String roq = sorted_str.substring(0,i) + sorted_str.substring(i+1);
			char ch = sorted_str.charAt(i);
			printLargerWords(roq, str, ans + ch);
		}
		
	}

}
