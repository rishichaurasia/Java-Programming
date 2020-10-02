package Leetcode_August_Challenge;

import java.util.LinkedList;
import java.util.List;

public class Design_Hashset {

	public static void main(String[] args) {
		
		Design_Hashset obj = new Design_Hashset();
		MyHashSet hashSet = obj.new MyHashSet();
		hashSet.add(1);         
		hashSet.add(2);         
		System.out.println(hashSet.contains(1));    // returns true
		System.out.println(hashSet.contains(3));    // returns false (not found)
		hashSet.add(2);          
		System.out.println(hashSet.contains(2));    // returns true
		hashSet.remove(2);          
		System.out.println(hashSet.contains(2));

	}
	
	class MyHashSet {

	    List<Integer>[] buckets;
	    int size;
	    static final int INITIAL_CAPACITY = 16;
	    static final float LOAD_FACTOR = 0.75f;
	    
	    /** Initialize your data structure here. */
	    public MyHashSet() {
	        size = 0;
	        buckets = new LinkedList[INITIAL_CAPACITY];
	    }
	    
	    public void add(int key) {
	        int hashcode = hashcode(key);
	        
	        List<Integer> bucket;
	        if(buckets[hashcode] == null)
	            bucket = new LinkedList<>();
	        else
	            bucket = buckets[hashcode];
	        
	        if(!bucket.contains(key)){
	            bucket.add(key);
	            buckets[hashcode] = bucket;
	            size++;
	            
	            if(size > buckets.length*LOAD_FACTOR)
	                rehash();
	        }
	        
	    }
	    
	    public void remove(int key) {
	        int hashcode = hashcode(key);
	        
	        List<Integer> bucket = buckets[hashcode];
	        
	        if(bucket == null)
	            return;
	        
	        bucket.remove((Integer) key);
	        size--;
	    }
	    
	    /** Returns true if this set contains the specified element */
	    public boolean contains(int key) {
	        int hashcode = hashcode(key);
	        
	        List<Integer> bucket = buckets[hashcode];
	        
	        if(bucket == null)
	            return false;
	        else
	            return bucket.contains(key);
	    }
	    
	    public int hashcode(int key){
	        return key%buckets.length;
	    }
	    
	    public void rehash(){
	        
	        List<Integer>[] temp = buckets;
	        buckets = new LinkedList[temp.length * 2];
	        for(List<Integer> bucket: temp){
	            if(bucket != null && !bucket.isEmpty()){
	                
	                for(int key: bucket)
	                    add(key);
	                
	            }
	                
	        }
	        
	    }
	}

}
