package Heap;

import java.util.ArrayList;

public class Heap {
	
	ArrayList<Integer> data = new ArrayList<>();
	
	public void add(int item) {
		// O(logn (base 2) )
		data.add(item);
		upheapify(data.size() - 1);
	}
	
	public void upheapify(int ci) {
		int pi = (ci-1)/2;
		if(data.get(pi) > data.get(ci)) {
			swap(pi, ci);
			upheapify(pi);
		}
	}
	
	public void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);
		
		data.set(i, jth);
		data.set(j, ith);
	}
	
	public void display() {
		System.out.println(this.data);
	}
	
	public int size() {
		return this.data.size();
	}
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public int remove() {
		swap(0, data.size() - 1);
		int rv =  data.remove(data.size() - 1);
		downheapify(0); 
		return rv;
	}
	
	public void downheapify(int pi) {
		 int lci = 2*pi + 1;
		 int rci = 2*pi + 2;
		 int mini = pi;
		 if(lci < this.data.size() && data.get(lci) < data.get(mini))
			 mini = lci;
		 if(rci < this.data.size() && data.get(rci) < data.get(mini))
			 mini = rci;
		 if(mini != pi) {
			 this.swap(pi , mini);
			 this.downheapify(mini);
		 }
	}
	
	public int get() {
		return this.data.get(0); 
	}

}
