package Lec10;

import java.util.ArrayList;

public class BoardPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		System.out.println(boardPath(0,10).size());
		long end = System.currentTimeMillis();
		System.out.println(end-start);

	}
	
	public static ArrayList<String> boardPath(int curr, int end){
		if(curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if(curr>end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> mr = new ArrayList<>();
		for(int dice = 1; dice<=6; dice++) {
			ArrayList<String> rr = boardPath(curr + dice, end);
			for(String val: rr) {
				mr.add(dice+val);
			}
		}
		return mr;
	}
	

}
