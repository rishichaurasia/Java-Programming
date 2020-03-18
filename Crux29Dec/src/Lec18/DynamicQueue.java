package Lec18;

import Lec17.Queue;

public class DynamicQueue extends Queue {
	
	@Override
	public void enqueue(int item) throws Exception {
		
		if(isFull()) {
			int[] data1 = new int[2 * data.length];
			for (int i = 0; i < size; i++) {
				int idx = (front + i)%data.length;
				data1[i] = data[idx];
			}
			front = 0;
			data = data1;
		}
		
		super.enqueue(item);
	}
	
}
