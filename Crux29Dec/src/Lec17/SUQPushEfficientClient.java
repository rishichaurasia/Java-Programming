package Lec17;

public class SUQPushEfficientClient {

	public static void main(String[] args) throws Exception {
		
		SUQPushEfficient stack = new SUQPushEfficient();
		for(int i = 1; i<=6; i++) {
			stack.push(10*i);
		}
		stack.display();
		System.out.println(stack.pop());
		stack.display();
		System.out.println(stack.top());
		stack.display();
		stack.push(70);
		stack.display();

	}

}
