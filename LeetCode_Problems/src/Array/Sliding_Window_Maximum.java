package Array;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class Sliding_Window_Maximum {

	public static void main(String[] args) {
		
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] res = maxSlidingWindow1(nums, k);
		
		IntStream.of(res).forEach(x -> System.out.print(x + " "));

	}
	
	//O(nlogk) Time
	public static int[] maxSlidingWindow(int[] nums, int k) {
        
		Queue<Integer> pq = new PriorityQueue<Integer>((x,y) -> y-x);
		int[] result = new int[nums.length - k + 1];
		for(int i = 0; i<k; i++)
			pq.add(nums[i]);
		result[0] = pq.peek();
		
		for(int i = k; i<nums.length; i++) {
			pq.add(nums[i]);
			pq.remove(nums[i-k]);
			result[i-k+1] = pq.peek();
		}
		
		return result;
		
    }
	
	
	// O(n)
	public static int[] maxSlidingWindow1(int[] nums, int k) {
        
		Deque<Integer> dq = new LinkedList<Integer>();
		int[] result = new int[nums.length - k + 1];
		
		for(int i = 0; i<k; i++) {
			
			while(!dq.isEmpty() && nums[dq.peekLast()] <=  nums[i])
				dq.removeLast();
			dq.addLast(i);
		}
		
		result[0] = nums[dq.peekFirst()];
		
		for(int i = k; i<nums.length; i++) {
			while(!dq.isEmpty() && dq.peekFirst() <= i-k)
				dq.removeFirst();
			while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
				dq.removeLast();
			dq.addLast (i);
			result[i-k+1] = nums[dq.peekFirst()];
		}
		
		return result;
		
    }

}
