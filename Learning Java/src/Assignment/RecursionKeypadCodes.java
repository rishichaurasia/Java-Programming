package Assignment;

import java.util.Scanner;

public class RecursionKeypadCodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
Take as input str, a string. str represents keys pressed on a nokia phone keypad. We are concerned with all possible words that can be written with the pressed keys.

Assume the following alphabets on the keys: 1 -> abc , 2 -> def , 3 -> ghi , 4 -> jkl , 5 -> mno , 6 -> pqrs , 7 -> tuv , 8 -> wx , 9 -> yz

E.g. “12” can produce following words “ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf”

a. Write a recursive function which returns the count of words for a given keypad string. Print the value returned.

b.Write a recursive function which prints all possible words for a given keypad string (void is the return type for function).

Input Format
Enter a number

Constraints
None

Output Format
Display the total no. of words and display all the words in a space separated manner

Sample Input
12
Sample Output
ad ae af bd be bf cd ce cf
9
 */
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		printCodes(str, "");
		System.out.println();
		System.out.println(count);
		

	}
	
	static int count = 0;
	
	public static void printCodes(String ques, String ans) {
		
		if(ques.length()==0) {
			System.out.print(ans+" ");
			count++;
			return;
		}
		char ch = ques.charAt(0);
		String str = getCodes(ch);
		for(int i = 0; i<str.length(); i++) {
			String roq = ques.substring(1);
			printCodes(roq, ans+str.charAt(i));
		}
		
		
	}
	
	public static String getCodes(char ch) {
		switch(ch) {
		case '1':
			return "abc";
		case '2':
			return "def";
		case '3':
			return "ghi";
		case '4':
			return "jkl";
		case '5': 
			return "mno";
		case '6': 
			return "pqrs";
		case '7':
			return "tuv";
		case '8':
			return "wx";
		case '9':
			return "yz";
		}
		return "";
	}

}
