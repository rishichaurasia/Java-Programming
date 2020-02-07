package Lec10;

import java.util.ArrayList;

public class CoinToss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(coinToss(3));
	}
	
	public static ArrayList<String> coinToss(int n){
		if(n==0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = coinToss(n-1);
		for(String val: rr) {
			mr.add(val+"H");
			mr.add(val+"T"); 
		}
		return mr;
	}

}
