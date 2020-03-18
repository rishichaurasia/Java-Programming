package Lec17;

import java.util.Queue;

import Lec18.DynamicQueue;

public class SUQPushEfficient {

	private DynamicQueue primary;
	private DynamicQueue secondary;
	public SUQPushEfficient() {
		
		this.primary = new DynamicQueue();
		this.secondary = new DynamicQueue();
		
	}
	
	public int size() {
		
		return this.primary.size;
		
	}
	
	public boolean isEmpty() {
		
		return this.primary.isEmpty();
		
	}
	
	public void push(int data) throws Exception {
		
		this.primary.enqueue(data);
		
	}
	
	public int pop() throws Exception {
		
		 while(this.primary.size != 1) {
			 this.secondary.enqueue(this.primary.dequeue());
		 }
		 int val = this.primary.dequeue();
		 while(!this.secondary.isEmpty()) {
			 this.primary.enqueue(this.secondary.dequeue());
		 }
		 return val;
		 
	}

	public int top() throws Exception {
		
		int val = -1;
		for (int i = 1; i <= this.primary.size; i++) {
			if(i == this.primary.size)
				val = this.primary.getFront();
			this.primary.enqueue(this.primary.dequeue());
		}
		return val;
		
	}
	
	public void display() throws Exception {
		
		reverseQueue(this.primary);
		this.primary.display();
		reverseQueue(this.primary);
		
	}
	
	private void reverseQueue(DynamicQueue queue) throws Exception{
		
		if(queue.isEmpty())
			return;
		int ele = queue.dequeue();
		reverseQueue(queue);
		queue.enqueue(ele);
		
	}
}
