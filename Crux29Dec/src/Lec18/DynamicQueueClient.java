package Lec18;

import Lec17.Queue;

public class DynamicQueueClient {

	public static void main(String[] args) throws Exception {
		
		Queue dq = new DynamicQueue();
		dq.enqueue(10);
		dq.enqueue(20);
		dq.enqueue(30);
		dq.enqueue(40);
		dq.enqueue(50);
		dq.display();
		dq.dequeue();
		dq.enqueue(10);
		dq.enqueue(60);
		dq.display();
//		actualReverse(dq);
		displayReverse(dq, dq.size());
		System.out.println();
		dq.display();

	}
	
	public static void displayReverse(Queue q, int size ) throws Exception {
		if(size == 0)
			return;
		int item = q.dequeue();
		q.enqueue(item);
		size--;
		displayReverse(q, size);
		System.out.print(item + " ");
	}
	
	public static void actualReverse(Queue q) throws Exception {
		if(q.isEmpty())
			return;
		int item = q.dequeue();
		actualReverse(q);
		q.enqueue(item);
	}

}
