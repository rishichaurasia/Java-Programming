package Heap;

import java.util.ArrayList;

public class HeapGeneric<T extends Comparable<T>> {

	ArrayList<T> data = new ArrayList<>();

	public void add(T item) {
		// O(logn (base 2) )
		data.add(item);
		upheapify(data.size() - 1);
	}

	public void upheapify(int ci) {
		int pi = (ci - 1) / 2;
		if (isLarge(data.get(ci), data.get(pi)) > 0) {
			swap(pi, ci);
			upheapify(pi);
		}
	}

	public void swap(int i, int j) {
		T ith = data.get(i);
		T jth = data.get(j);

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

	public T remove() {
		swap(0, data.size() - 1);
		T rv = data.remove(data.size() - 1);
		downheapify(0);
		return rv;
	}

	public void downheapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;
		int mini = pi;
		if (lci < this.data.size() && isLarge(data.get(lci), data.get(mini)) > 0)
			mini = lci;
		if (rci < this.data.size() && isLarge(data.get(rci), data.get(mini)) > 0)
			mini = rci;
		if (mini != pi) {
			this.swap(pi, mini);
			this.downheapify(mini);
		}
	}

	public T get() {
		return this.data.get(0);
	}

	// If t is having higher probability then return positive value
	public int isLarge(T t, T o) {
		return t.compareTo(o);
	}

}
