package Lec10;

import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutations("abc"));

	}
	
	public static ArrayList<String> getPermutations(String str){
		if(str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = getPermutations(ros);
		ArrayList<String> mr = new ArrayList<>();
		for(String val: rr) {
			for(int i = 0; i<=val.length(); i++) {
				String temp = val.substring(0,i) + ch + val.substring(i);
				mr.add(temp);
			}
		}
		return mr;
	}

}
