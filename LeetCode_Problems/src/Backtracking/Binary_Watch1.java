package Backtracking;

import java.util.ArrayList;

// https://leetcode.com/problems/binary-watch/

import java.util.List;

public class Binary_Watch1 {

	public static void main(String[] args) {
		int num = 1;
		System.out.println(readBinaryWatch(num));
//		System.out.println(readBinaryWatch1(num));

	}
	
	public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
		int[] led = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32};
        readBinaryWatch(num, led, 0, 0, 0, list);
        return list;
    }

	private static void readBinaryWatch(int num, int[] led, int idx, int hr, int min, List list) {
		if(hr > 11 || min > 59)
			return;
		if(num == 0) {
			list.add(String.format("%d:%02d", hr, min));
		}
		for(int i = idx; i<led.length; i++) {
			if(i < 4 ) {
				readBinaryWatch(num-1, led, i+1, hr+led[i], min, list);
			}else {
				readBinaryWatch(num-1, led, i+1, hr, min+led[i], list);
			}
		}
		
	}
	
	public static List<String> readBinaryWatch1(int num) {
        List<String> ans = new ArrayList<String>();
        for(int i = 0; i<12; i++){
            for(int j = 0; j<60; j++){
                if(Integer.bitCount(i) + Integer.bitCount(j) == num){
                    ans.add(String.format("%d:%02d",i,j));
                }
            }
        }
        return ans;
    }

}
