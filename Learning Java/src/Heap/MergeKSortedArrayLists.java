package Heap;

import java.util.ArrayList;

class Pair implements Comparable<Pair>{
	ArrayList<Integer> al;
	int ci;
	
	public Pair(ArrayList<Integer> al) {
		this.al = al;
		this.ci = 0;
	}
	
	@Override
	public int compareTo(Pair o) {
		return o.al.get(o.ci) - this.al.get(this.ci);
	}
}

public class MergeKSortedArrayLists {
	
	// O(nlog(k))
	public static ArrayList<Integer> mergeKSortedArrayLists(ArrayList<ArrayList<Integer>> list) {
		ArrayList<Integer> ans = new ArrayList<>();
		HeapGeneric<Pair> heap = new HeapGeneric<>();
		for(ArrayList<Integer> cl: list) {
			Pair np = new Pair(cl);
			heap.add(np);
		}
		
		while(!heap.isEmpty()) {
			Pair rp = heap.remove();
			ans.add(rp.al.get(rp.ci));
			rp.ci = rp.ci+1;
			if(rp.ci < rp.al.size())
				heap.add(rp);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());
		list.add(new ArrayList<>());

		list.get(0).add(10);
		list.get(0).add(20);
		list.get(0).add(30);
		list.get(0).add(40);
		
		list.get(1).add(5);
		list.get(1).add(15);
		list.get(1).add(30);
		
		list.get(2).add(2);
		list.get(2).add(8);
		list.get(2).add(25);
		
		System.out.println(mergeKSortedArrayLists(list));
	}

}
