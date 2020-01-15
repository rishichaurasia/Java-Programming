package Assignment;

import java.util.Scanner;

public class Assignment036 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Print "lowercase" if user enters a character between 'a-z' , Print "UPPERCASE" is character lies between 'A-Z' and print "Invalid" for all other characters like $,.^# etc.
//
//		Input Format
//		Single Character .
//
//		Constraints
//		-
//
//		Output Format
//		lowercase UPPERCASE Invalid
//
//		Sample Input
//		$
//		Sample Output
//		Invalid
		
		Scanner scn = new Scanner(System.in);
		char a = scn.next().charAt(0);
		checkCase(a);

	}
	public static void checkCase(char a) {
		if(a>='a' && a<='z')
			System.out.println("lowercase");
		else if(a>='A' && a<='Z')
			System.out.println("UPPERCASE");
		else
			System.out.println("Invalid");
	}

}
