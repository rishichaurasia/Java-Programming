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
		recur_Subsequence(str, "");
		System.out.println();
		System.out.println(count_SS(str,""));
		
	}
	
	public static void recur_Subsequence(String ques, String ans){
		if(ques.length()==0) {
			System.out.print(ans + " ");
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		recur_Subsequence(roq, ans);
		recur_Subsequence(roq, ans+ch);
	}
	public static int count_SS(String ques, String ans){
	     if(ques.length() == 0){

	        return 1;
	    }

	    char ch = ques.charAt(0);
	    String ros = ques.substring(1);
	    int val1 = count_SS(ros, ans);
	    int val2 = count_SS(ros, ans + ch);
	    return val1 + val2;
	}


}
