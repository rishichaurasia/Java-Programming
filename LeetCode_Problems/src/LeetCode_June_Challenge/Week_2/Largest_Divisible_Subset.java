package LeetCode_June_Challenge.Week_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Divisible_Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length<=1)
            return list;
        Arrays.sort(nums);
        int[] helper = new int[nums.length];
        Arrays.fill(helper, 1);
        int max = 1;
        for(int i = 1; i<helper.length; i++) {
        	for(int j = 0; j<i; j++) {
        		if(nums[i]%nums[j] == 0 && helper[j]+1 > helper[i]) {
        			helper[i] = helper[j] + 1;
        			if(helper[i] > max)
        				max = helper[i];
        		}
        	}
        }
        
        int prev = -1;
        for(int i = helper.length-1; i>=0; i--) {
        	if(helper[i] == max && (prev%nums[i] == 0 || prev == -1)) {
        		list.add(nums[i]);
        		max--;
        		prev = nums[i];
        	}
        }
        return list;
    }
	
	// DP
	public List<Integer> largestDivisibleSubset1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return list;
        int n = nums.length;
        Arrays.sort(nums);
        int[] helper = new int[n];
        int[] next = new int[n];
        int max = 0;
        int start = -1;
        for(int i = n-1; i>=0; --i) {
        	for(int j = i+1;j<n; ++j) {
        		if(helper[i] < helper[j] && nums[j] % nums[i] == 0) {
        			helper[i] = helper[j];
        			next[i] = j;
        		}
        	}
        	++helper[i];
        	if(helper[i] > max) {
        		max = helper[i];
        		start = i;
        	}
        		
        }
        
        while(max-- > 0) {
        	list.add(nums[start]);
        	start = next[start];
        }
        return list;
    }
	
	// Recursion
	class Solution {
	    List<Integer> answer;
	    public List<Integer> largestDivisibleSubset(int[] nums) {
	        if(nums==null || nums.length==0)
	            return new ArrayList<Integer>();
	 
	        Arrays.sort(nums);
	 
	        int[] max = new int[1];
	        List<Integer> result = new ArrayList<Integer>();
	        helper(nums, 0, result, max);
	        return answer;
	    }
	 
	    public void helper(int[] nums, int start, List<Integer> result, int[] max){
	        if(result.size()>max[0]){
	            max[0]=result.size();
	            answer=new ArrayList<Integer>(result);
	        }
	 
	        if(start==nums.length)
	            return;
	 
	        for(int i=start; i<nums.length; i++){
	            if(result.size()==0){
	                result.add(nums[i]);
	                helper(nums, i+1, result, max);
	                result.remove(result.size()-1);
	 
	            }else{
	 
	                int top = result.get(result.size()-1);
	                if(nums[i]%top==0){
	                    result.add(nums[i]);
	                    helper(nums, i+1, result, max);
	                    result.remove(result.size()-1);
	                }
	            }
	        }
	    }
	}

}
