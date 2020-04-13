package HashMap;

import java.util.ArrayList;

public class HashTable<K, V> {
	private class HTPair{
		K key;
		V value;
		HTPair(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		@Override
		public boolean equals(Object other) {
			HTPair op = (HTPair) other;
			return this.key.equals(op.key);
		}
		
		@Override
		public String toString() {
			return "{" + this.key + "-" + this.value + "}";
		}
		
	}
	
	public static final int DEFAULT_CAPACITY = 10;
	
	private LinkedList<HTPair>[] bucketArray;
	private int size;
	
	public HashTable() {
		this(DEFAULT_CAPACITY);
	}
	
	public HashTable(int capacity) {
		bucketArray = (LinkedList<HTPair>[]) new LinkedList[capacity];
	}
	
	public void put(K key, V value) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		HTPair pair = new HTPair(key, value);	
		if(bucket == null) {
			bucket = new LinkedList<>();
			bucket.addLast(pair);
			this.bucketArray[bi] = bucket;
			this.size++;
		}else {
			int findAt = bucket.find(pair);
			if(findAt == -1) {
				bucket.addLast(pair);
				this.size++;
			}else {
				bucket.getAt(findAt).value = value;
			}
		}
		
		double lambda = this.size * 1.0 / this.bucketArray.length;
		if(lambda > 2)
			this.rehash();
	}
	
	private void rehash() throws Exception{
		LinkedList<HTPair>[] oba = this.bucketArray;   // oba = old bucket array
		this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[2*oba.length];
		this.size = 0;
		for(LinkedList<HTPair> bucket : oba) {
			while(bucket != null && !bucket.isEmpty()) {
				HTPair pair = bucket.removeFirst();
				this.put(pair.key, pair.value);
			}
		}
	}
	
	private int hashFunction(K key) {
		int hc = Math.abs(key.hashCode());
		return hc % this.bucketArray.length;
	}
	
	public V get(K key) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		if(bucket == null)
			return null;
		HTPair ptf = new HTPair(key, null);
		int findAt = bucket.find(ptf);
		if(findAt != -1) {
			HTPair pair = bucket.getAt(findAt);
			return pair.value;
		}
		return null;
	}
	
	public V remove(K key) throws Exception {
		int bi = hashFunction(key);
		LinkedList<HTPair> bucket = this.bucketArray[bi];
		if(bucket == null)
			return null;
		HTPair ptf = new HTPair(key, null);
		int findAt = bucket.find(ptf);
		if(findAt != -1) {
			this.size--;
			return bucket.removeAt(findAt).value;
		}
		return null;
	}
	
	public void display() {
		System.out.println("-------------------------------");
		for(LinkedList<HTPair> bucket: this.bucketArray) {
			if(bucket != null)
				bucket.display();
			else
				System.out.println("NULL");
		}
		System.out.println("-------------------------------");
	}
}
