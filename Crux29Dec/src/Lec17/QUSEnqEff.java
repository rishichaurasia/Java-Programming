package Lec17;

public class QUSEnqEff {
	private DynamicStack s = new DynamicStack();
	
	public void enqueue(int item) throws Exception{
		try {
			s.push(item);
		}
		catch(Exception e) {
			throw new Exception("Queue is Full");
		}
	}
	
	public int dequeue() throws Exception {
		try {
			DynamicStack hs = new DynamicStack();
			while(s.size() != 1)
				hs.push(s.pop());
			int rv = s.pop();
			while(!hs.isEmpty())
				s.push(hs.pop());
			return rv;
		}catch(Exception e) {
			throw new Exception("Queue is empty!");
		}
	}
	
	public int getFront() throws Exception {
		try {
			DynamicStack hs = new DynamicStack();
			while(s.size() != 1)
				hs.push(s.pop());
			int rv = s.peek();
			while(!hs.isEmpty())
				s.push(hs.pop());
			return rv;
		}catch(Exception e) {
			throw new Exception("Queue is empty!");
		}
	}
	
	public void display() throws Exception {
		display1();
		System.out.println();
	}
	
	private void display1() throws Exception {
		try {
			if(s.isEmpty())
				return;
			int val = s.pop();
			display1();
			System.out.print(val + " ");
			s.push(val);
		}
		catch (Exception e) {
			throw new Exception("Error in display!");
		}
	}
}
