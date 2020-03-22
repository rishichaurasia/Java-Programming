package Lec19;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {
		
		LinkedList ll = new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.addLast(40);
		ll.addLast(50);
		ll.addLast(60);
		ll.addLast(70);
		ll.addLast(80);
		ll.addLast(90);
		ll.display();
		ll.reverseInPairsOfK(3);
		ll.display();

	}

}
