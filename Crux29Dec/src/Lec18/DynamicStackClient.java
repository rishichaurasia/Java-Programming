package Lec18;

import Lec17.Stack;

public class DynamicStackClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Stack ds = new DynamicStack();
		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(50);
		ds.display();
		ds.push(60);
		ds.display();
//		displayReverse(ds);
//		System.out.println();
		actualReverse(ds, new DynamicStack());
		ds.display();

	}
	
	
	public static void displayReverse(Stack s) throws Exception {
		if(s.isEmpty()) {
			return;
		}
		int item = s.pop();
		displayReverse(s);
		System.out.print(item + " ");
		s.push(item);
		
	}
	
	public static void actualReverse(Stack s, Stack other) throws Exception {
		if(s.isEmpty()) {
			if(other.isEmpty())
				return;
			int item = other.pop();
			actualReverse(s, other);
			s.push(item);
			return;
		}
		int item = s.pop();
		other.push(item);
		actualReverse(s, other);
	}

//	public static void actualReverseHelper (Stack s, Stack other) throws Exception {
//		if(other.isEmpty())
//			return;
//		int item = other.pop();
//		actualReverseHelper(s, other);
//		s.push(item);
//		
//	}
	
}
