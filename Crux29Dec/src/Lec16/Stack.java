package Lec16;

public class Stack {
	
	private int[] data;
	private int tos;
	private int min_index = 0;
	
	public Stack() {
		data = new int[5];
		tos = -1;
	}
	
	public Stack(int size){
		data = new int[size];
		tos = -1;
	}
	
	public void push(int item) throws Exception {
		if(isFull()) {
			throw new Exception("Stack is Full!");
		}
		tos++;
		if(item<data[min_index])
			min_index = tos;
		data[tos] = item;
	}
	
	public int pop() throws Exception {
		if(isEmpty()) {
			throw new Exception("Stack is Empty!");
		}
		if(tos == min_index) {
			findMin();
		}
		int temp = data[tos];
		data[tos] = 0;
		tos--;
		return temp;
	}
	
	public int peek() throws Exception{
		if(isEmpty()) {
			throw new Exception("Stack is Empty!");
		}
	
		return data[tos];
	}
	
	public int size() {
		return tos+1;
	}
	
	public boolean isEmpty() {
		if(tos == -1)
			return true;
		return false;
	}
	
	public boolean isFull() {
		if(tos == data.length-1)
			return true;
		return false;
	}
	
	public int getMin() {
		return data[min_index];
	}
	
	private void findMin() {
		min_index = 0;
		for (int i = min_index; i >0; i--) {
			if(data[i]<data[min_index])
				min_index = i;
		}
	}
	
	public void display() {
		for(int i = tos; i>=0; i--)
			System.out.print(data[i] + " ");
		System.out.println();
	}

}
