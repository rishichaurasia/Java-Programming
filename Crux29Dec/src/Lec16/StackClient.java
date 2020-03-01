package Lec16;

public class StackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(5);
		s.display();
		System.out.println(s.getMin());
		s.pop();
		System.out.println(s.getMin());
		s.display();
//		System.out.println(s.size());

	}

}
