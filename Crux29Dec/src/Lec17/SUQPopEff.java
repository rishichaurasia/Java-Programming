package Lec17;

import Lec18.DynamicQueue;

public class SUQPopEff {
	
	private DynamicQueue q = new DynamicQueue();
	
	public void push(int item) throws Exception {
		try {
			DynamicQueue hq = new DynamicQueue();
			hq.enqueue(item);
			while(!q.isEmpty())
				hq.enqueue(q.dequeue());
			q = hq;
		}
		catch(Exception e) {
			throw new Exception("Stack is full");
		}
	}
	
	public int pop() throws Exception{
		try {
			return q.dequeue();
		}
		catch(Exception e) {
			throw new Exception("Stack is empty!");
		}
	}
	
	public int peek() {
		return q.getFront();
	}
	
	public void display() {
		q.display();
	}

}
