package Backtracking;

import java.util.ArrayList;

// https://leetcode.com/problems/gray-code/

import java.util.List;

public class Gray_Code {
	
	public static void main(String[] args) {
		System.out.println(grayCode(3));
	}
	
	public static List<Integer> grayCode(int n) {
        if(n == 0) {
        	List<Integer> br = new ArrayList<>();
        	br.add(0);
        	return br;
        }
		List<Integer> rr = grayCode(n-1);
        List<Integer> mr = new ArrayList<>(rr);
        int add = (int)Math.pow(2, n-1);
        for(int i = rr.size()-1; i>=0; i--) {
        	mr.add(rr.get(i)+add);
        }
        return mr;
    }

}
