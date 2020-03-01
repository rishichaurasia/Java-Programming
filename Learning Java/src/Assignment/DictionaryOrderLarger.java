package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class DictionaryOrderLarger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String str_sorted = sortString(str);
		dictionaryOrderLarger(str, str_sorted, "");

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
		if(str_sort.length()==0) {
			if(isLarger(str, ans))
				System.out.println(ans);
			return;
		}
		
		for(int i = 0; i<str_sort.length(); i++) {
			char ch = str_sort.charAt(i);
			String roq = str_sort.substring(0, i) + str_sort.substring(i+1);
			dictionaryOrderLarger(str, roq, ans+ch);
		}
	}
	
	public static boolean isLarger(String str, String ans) {
		for(int i = 0; i<str.length(); i++) {
			if(ans.charAt(i) < str.charAt(i))
				return false;
			if(ans.charAt(i) > str.charAt(i))
				return true;
		}
		return false;
	}
	

}
