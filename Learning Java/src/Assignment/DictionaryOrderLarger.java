package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class DictionaryOrderLarger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String str_sorted = sortString(str);
		System.out.println(str_sorted);
//		dictionaryOrderLarger(str);

	}
	
	public static String sortString(String str) {
		char[] ch_arr = new char[str.length()];
		for(int i = 0; i<str.length(); i++) {
			ch_arr[i] = str.charAt(i);
		}
		Arrays.sort(ch_arr);
		return new String(ch_arr);
	}
	
	public static void dictionaryOrderLarger(String str, String str_sort, String ans){
		
		
		for(int i = 0; i<str_sort.length(); i++) {
			char ch = str_sort.charAt(i);
//			if(ch>=str.charAt(0))
		}
	}

}
