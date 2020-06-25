package LeetCode_June_Challenge.Week_1;

import java.util.Random;

public class Random_Pick_with_weight {
	class Solution {

	    private int[] accSum;
	    private int total;
	    private Random rand;
	    
	    public Solution(int[] w) {
	        accSum = new int[w.length];
	        rand = new Random();

	        for (int i = 0; i< w.length; i++) {
	            total += w[i];
	            accSum[i] = total; 
	        }
	    }
	    
	    public int pickIndex() {
	        int r = rand.nextInt(total) + 1;
	        int start = 0, end = accSum.length - 1;

	        while (start <= end) {
	            int mid = start + (end - start) / 2;
	            if (accSum[mid] == r) {
	                return mid;
	            } else if (accSum[mid] > r) {
	                end = mid - 1;
	            } else {
	                start = mid + 1;
	            }
	        }
	        return start;
	    }
	}
}
