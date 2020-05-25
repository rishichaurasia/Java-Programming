package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryWatch {

	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = scn.nextInt();
		List<String> res = readBinaryWatch(n);
		System.out.println(res);
		
	}
	
	public static List<String> readBinaryWatch(int num){
		
		List<String> res = new ArrayList<String>();
		for(int i = 0; i<=num; i++) {
			List<Integer> hrs = getHrs(i);
			List<String> mins = getMins(num - i);
			for(int hr: hrs) {
				for(String min: mins) {
					res.add(hr + ":" + min);
				}
			}
		}
		return res;
		
	}

	public static List<Integer> getHrs(int n){
		
		List<Integer> list = new ArrayList<Integer>();
		if(n == 0 ) {
			list.add(0);
			return list;
		}
		for(int i = 0; i<12; i++) {
			if(getSetBits(i) == n) {
				list.add(i);
			}
		}
		return list;
		
	}
	
	public static List<String> getMins(int n){
		List<String> list = new ArrayList<String>();
		if(n == 0 ) {
			list.add("00");
			return list;
		}
		for(int i = 0; i<60; i++) {
			if(getSetBits(i) == n) {
				if(i <10)
					list.add("0" + i);
				else
					list.add("" + i);
			}
		}
		return list;
	}
	
	public static int getSetBits(int n) {
		int c = 0;
		while(n != 0) {
			if((n & 1) == 1)
				c++;
			n = n >> 1;
		}
		return c;
	}
	
}
