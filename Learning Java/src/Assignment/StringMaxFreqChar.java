package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class StringMaxFreqChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Take as input S, a string. Write a function that returns the character with
		 * maximum frequency. Print the value returned.
		 * 
		 * Input Format String
		 * 
		 * Constraints A string of length between 1 to 1000.
		 * 
		 * Output Format Character
		 * 
		 * Sample Input aaabacb Sample Output a Explanation For the given input string,
		 * a appear 4 times. Hence, it is the most frequent character.
		 */

		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		maxFreqChar(str);

	}

	public static void maxFreqChar(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		char mfc = arr[0];
		int max_count = 1;
		for (int i = 1; i < arr.length; i++) {
			int count = 1;
			while (i < arr.length && arr[i] == arr[i - 1]) {
				count++;
				i++;
			}
			if (count > max_count) {
				mfc = arr[i - 1];
				max_count = count;
			}
		}
		System.out.println(mfc);
	}
	
	public static char maxFreq(String str){
        char[] charray = new char[26]; // To store freq of each character
        for(int i = 0;i < str.length();i++){  
            charray[str.charAt(i) - 'a']++; //Updating freq each time
        }
        int max = 0;
        char ch = 'a';
        for(int i = 0;i < 26;i++){
            if(max <= charray[i]){ //Choosing max Freq Character
                max = charray[i];
                ch = (char)(i + 'a');
            }
        }
        return ch; // return character
    }

}
