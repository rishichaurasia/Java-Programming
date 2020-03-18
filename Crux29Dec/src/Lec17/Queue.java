package Lec17;

public class Queue {
	
	protected int[] data;
	protected int front;
	protected int size;
	
	public Queue() {
		data = new int[5];
		front = 0;
		size = 0;
	}
	
	public Queue(int n) {
		data = new int[n];
		front = 0;
		size = 0;
	}
	
	public void enqueue(int item) throws Exception {
		if(isFull()) {
			throw new Exception("Queue is Full");
		}
		int idx = (front+size)%data.length;
		data[idx] = item;
		size++;
	}
	
	public int dequeue() throws Exception {
		if(isEmpty())
			throw new Exception("Queue is Empty");
		int temp = data[front];
		front = (front+1)%data.length;
		size--;
		return temp;
	}
	
	public int getFront() {
		return data[front];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size == data.length;
	}
	
	public void display() {
		for (int i = 0; i < size; i++) {
			int idx = (front + i)%data.length;
			System.out.print(data[idx] + " ");
		}
		System.out.println();
	}
	
}
