package LeetCode_June_Challenge.Week_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Insert_Delete_GetRandom_O1 {
	class RandomizedSet {
	    
	    private ArrayList<Integer> list;
	    private Map<Integer, Integer> map;
	    private Random rand;

	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        list = new ArrayList<>();
	        map = new HashMap<>();
	        rand = new Random();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(map.containsKey(val))
	            return false;
	        list.add(val);
	        map.put(val, list.size()-1);
	        return true;
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(map.containsKey(val)) {
	            int index = map.remove(val);
	            int lastElement = list.get(list.size() - 1);
	            if(lastElement != val) {
	                list.set(index, lastElement);
	                map.put(lastElement, index);
	            }
	            list.remove(list.size() - 1);
	            return true;
	        }
	        return false;
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        int rn = rand.nextInt(list.size());
	        return list.get(rn);
	    }
	}
}
