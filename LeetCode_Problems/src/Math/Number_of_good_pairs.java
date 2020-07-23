package Math;

import java.util.HashMap;

public class Number_of_good_pairs {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,1,1,3};

	}
	
	// O(n)
	public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            int c = map.getOrDefault(num, 0);
            map.put(num, c+1);
        }
        // System.out.println(map);
        int res = 0;
        
        for(int num: map.keySet()){
            int c = map.get(num);
            if(c > 1){
                res += (c*(c-1))/2;
            }
        }
        return res;
    }

}
