package Lec19;

public class LinkedListClient {

	public static void main(String[] args) throws Exception {
		
		LinkedList ll = new LinkedList();
		ll.addFirst(10);
		ll.addFirst(20);
		ll.addFirst(30);
		ll.addFirst(40);
		ll.addFirst(50);
		ll.addFirst(60);
		ll.display();
		System.out.println(ll.kthNodeFromLast(8));
//		ll.display();

	}

}
