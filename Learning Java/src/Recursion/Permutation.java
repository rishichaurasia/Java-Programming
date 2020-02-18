package Recursion;

import java.util.ArrayList;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(permutation("abc"));

	}
	
	public static ArrayList<String> permutation(String str){
		if(str.length()==0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = permutation(ros);
		ArrayList<String> mr = new ArrayList<>();
		for(String val: rr) {
			for(int i = 0; i<=val.length(); i++) {
				mr.add(val.substring(0,i)+ch+val.substring(i));
			}
		}
		return mr;
	}

}
