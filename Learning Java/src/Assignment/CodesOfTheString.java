package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class CodesOfTheString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
Take as input str, a string. Assume that value of a=1, b=2, c=3, d=4, …. z=26. Write a recursive function (return type Arraylist) to print all possible codes for the string. E.g. for “1123” possible codes are aabc, kbc, alc, aaw, kw.

Input Format
Enter a number

Constraints
None

Output Format
Display all the possible codes

Sample Input
1125
Sample Output
[aabe, aay, ale, kbe, ky]
 */

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(getCodes(str));
	}
	
	public static ArrayList<String> getCodes(String str){
		if(str.length()== 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		for(int i = 0; i<=1 && str.length()>i; i++) {
			String s = str.substring(0,i+1);
			String ros = str.substring(i+1);
			int n = Integer.parseInt(s);
			if(n<=26) {
				ArrayList<String> rr = getCodes(ros);
				char ch = (char)(n + 'a' -1);
				for(String val: rr) {
					mr.add(ch+val);
				}
			}
		}
		return mr;
		
	}

}
