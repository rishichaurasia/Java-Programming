package Assignment;

import java.util.Scanner;

public class RecursionASCIISS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
Take as input str, a string. We are concerned with all the possible ascii-subsequences of str. E.g. “ab” has following ascii-subsequences “”, “b”, “98”, “a”, “ab”, “a98”, “97”, “97b”, “9798”

a. Write a recursive function which returns the count of ascii-subsequences for a given string. Print the value returned.

b. Write a recursive function which prints all possible ascii-subsequences for a given string (void is the return type for function).

Input Format
Enter the string

Constraints
None

Output Format
Display the number of ASCII-subsequences and display all the ASCII- subsequences

Sample Input
ab
Sample Output
 b 98 a ab a98 97 97b 9798
9
 */
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		ascii_SS(str, "");
		System.out.println();
		System.out.println(ascii_SScount(str, ""));

	}
	
	public static void ascii_SS(String ques, String ans) {
		if(ques.length()==0) {
			System.out.print(ans+" ");
			return;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		ascii_SS(roq, ans);
		ascii_SS(roq, ans+ch);
		ascii_SS(roq, ans+(int)ch);
	}
	
	public static int ascii_SScount(String ques, String ans) {
		if(ques.length()==0) {
			return 1;
		}
		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		int val1 = ascii_SScount(roq, ans);
		int val2 = ascii_SScount(roq, ans+ch);
		int val3 = ascii_SScount(roq, ans+(int)ch);
		return val1+val2+val3;
	}

}
