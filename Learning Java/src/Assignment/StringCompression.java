package Assignment;

import java.util.Scanner;

public class StringCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Take as input S, a string. Write a function that does basic string
		 * compression. Print the value returned. E.g. for input “aaabbccds” print out
		 * a3b2c2ds.
		 * 
		 * Input Format A single String S.
		 * 
		 * Constraints A string of length between 1 to 1000
		 * 
		 * Output Format The compressed String.
		 * 
		 * Sample Input aaabbccds Sample Output a3b2c2ds Explanation In the given sample
		 * test case 'a' is repeated 3 times consecutively, 'b' is repeated twice, 'c'
		 * is repeated twice. But, 'd' and 's' occurred only once that's why we do not
		 * write their occurrence.
		 */

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		stringCompression(str);

	}

	public static void stringCompression(String str) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			ans += str.charAt(i);
			int count = 1;
			while (i < str.length() - 1 && str.charAt(i + 1) == str.charAt(i)) {
				count++;
				i++;
			}
			if (count > 1)
				ans += count;
		}
		System.out.println(ans);
	}

}
