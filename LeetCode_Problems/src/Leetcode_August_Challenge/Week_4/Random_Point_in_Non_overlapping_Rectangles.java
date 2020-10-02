package Leetcode_August_Challenge.Week_4;

import java.util.Arrays;
import java.util.Random;

public class Random_Point_in_Non_overlapping_Rectangles {

	public static void main(String[] args) {
		

	}
	
	class Solution {
	    int[][] rects;
	    int[] cf;
	    int num_points;
	    Random rand;
	    public Solution(int[][] rects) {
	        this.rects = rects;
	        this.cf = new int[rects.length];
	        num_points = 0;
	        for(int i = 0; i<rects.length; i++){
	            num_points += (rects[i][2]-rects[i][0]+1)*(rects[i][3]-rects[i][1]+1);
	            cf[i] = num_points;
	        }
	        rand = new Random();
	    }
	    
	    public int[] pick() {
	        int r = rand.nextInt()%num_points;
	        int rect = Arrays.binarySearch(cf, r);
	        int point = rect == 0 ? r : r-cf[rect-1];
	        int div = (rects[rect][2]-rects[rect][0]+1);
	        int x = rects[rect][0] + point % div;
	        int y = rects[rect][1] + point / div;
	        y = point%div == 0 ? y-1:y;
	        return new int[] {x, y};
	    }
	}

}
