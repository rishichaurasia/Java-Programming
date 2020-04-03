package Lec17;

public class QUSDeqEff {
	private DynamicStack s = new DynamicStack();
	
	public void enqueue(int item) throws Exception {
		try {
			DynamicStack hs = new DynamicStack();
			while(!s.isEmpty())
				hs.push(s.pop());
			s.push(item);
			while(!hs.isEmpty())
				s.push(hs.pop());
		}catch (Exception e) {
			throw new Exception("Queue is full!");
		}
	}
	
	public int dequeue() throws Exception {
		try {
			return s.pop();
		}catch (Exception e) {
			throw new Exception("Queue is Empty!");
		}
	}
	
	public int getFront() throws Exception {
		try {
			return s.peek();
		}catch(Exception e) {
			throw new Exception("Queue is Empty!");
		}
	}
	
	public void display() {
		s.display();
	}
}
