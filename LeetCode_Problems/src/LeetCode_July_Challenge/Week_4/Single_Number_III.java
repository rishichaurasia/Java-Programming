package LeetCode_July_Challenge.Week_4;

import java.util.HashSet;
import java.util.Set;

public class Single_Number_III {

	public static void main(String[] args) {
		

	}

	// O(n) Time | O(n) space
	public static int[] singleNumber(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for(int num: nums){
            if(seen.contains(num))
                seen.remove(num);
            else
                seen.add(num);
        }
        int i = 0;
        int[] result = new int[2];
        for(int num: seen)
            result[i++] = num;
        return result;
    }
	
	// O(n) Time | O(1) space
	public static int[] singleNumber1(int[] nums) {
		
		int bitmask = 0;
		
		for(int num: nums)
			bitmask ^= num;
		
		// Now bitmask contains both nos.
		// Get the rightmost 1-bit difference between x & y
		int d = bitmask & -bitmask;
		
		int x = 0;
		
		// bitmask which will contain only x
		for(int num: nums) {
			
			if((num & d) == 0)
				x ^= num;
			
		}
		
		return new int[] {x, bitmask^x};
		
	}

}
