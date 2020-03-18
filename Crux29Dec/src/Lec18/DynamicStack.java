package Lec18;

import Lec17.Stack;

public class DynamicStack extends Stack {
	
	@Override
	public void push(int item) throws Exception {
		
		if(isFull()) {
			int[] data1 = new int[2 * data.length];
			for(int i = 0; i<data.length; i++) {
				data1[i] = data[i];
			}
			data = data1;
		}
		super.push(item);
		
	}
}
