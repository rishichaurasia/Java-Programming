package DUCS_Assignment;

import java.util.HashSet;
import java.util.Scanner;

public class DuplicateCharacters {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter String to check for duplicate characters : ");
		String str = scn.next();
		printDuplicates(str);
	}
	
	public static void printDuplicates(String str) {
		HashSet<Character> duplicates = new HashSet<>();
		char[] charArray = str.toCharArray();
		for(int i = 0; i<charArray.length-1; i++) {
			for(int j = i+1; j<charArray.length; j++) {
				if(charArray[i] == charArray[j]) {
					duplicates.add(charArray[i]);
					break;
				}
			}
		}
		if(duplicates.isEmpty())
			System.out.println("No duplicate characters!");
		else
			System.out.println("Duplicate character : " + duplicates);
	}

}
