package Heap;

import java.util.ArrayList;
import java.util.List;

public class KLargestElements {

	public static List<Integer> getKLargestElements(int[] arr, int k) {
		List<Integer> ans = new ArrayList<>();
		
		Heap heap = new Heap();
		for (int i = 0; i < k; i++) {
			heap.add(arr[i]);
		}
		for(int i = k; i<arr.length; i++) {
			if(arr[i] > heap.get()) {
				heap.remove();
				heap.add(arr[i]);
			}
		}
		while(!heap.isEmpty()) {
			ans.add(heap.remove());
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] arr = { 32, 45, 32, 21, 2, 32, 87, 45, 73, 98, 12};
		System.out.println(getKLargestElements(arr, 6));

	}

}
