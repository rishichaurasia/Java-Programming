package June_Challenge_2020;

import java.util.Scanner;

public class Chef_and_String {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while(t-- > 0){
		    String students = scn.next();
		    System.out.println(getMaxPairs(students));
		}

	}
	
	public static int getMaxPairs(String students) {
		int res = 0;
		for(int i = 0; i<students.length()-1; i++) {
			if(students.charAt(i) != students.charAt(i+1)) {
				res++; i++;
			}
		}
		return res;
	}

}
