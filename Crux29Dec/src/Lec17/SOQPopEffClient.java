package Lec17;

public class SOQPopEffClient {

	public static void main(String[] args) throws Exception {
		SUQPopEff stack = new SUQPopEff();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		stack.push(60);
		stack.display();
		System.out.println(stack.peek());
	}

}
