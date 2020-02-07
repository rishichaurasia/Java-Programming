package Lec10;

import java.util.ArrayList;

public class MazePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mazePath(0,0,2,2));

	}

	public static ArrayList<String> mazePath(int cr, int cc, int er, int ec){
		if(cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if(cr>er || cc>ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rrh = mazePath(cr, cc+1, er, ec);
		for(String val: rrh) {
			mr.add("H" + val);
		}
		ArrayList<String> rrv = mazePath(cr+1, cc, er, ec);
		for(String val: rrv) {
			mr.add("V" + val);
		}
		
		return mr;
	}
}
