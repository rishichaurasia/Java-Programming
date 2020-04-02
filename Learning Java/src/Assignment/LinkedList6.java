package Assignment;

import java.util.Scanner;

/*
 * Given a singly linked list delete all nodes which are having a greater value among any of the nodes residing on the right side.

Input Format
First line contains N, the number of nodes in the linked list.
Next line contains the N nodes data .

Constraints
0<N<10^9

Output Format
Print the linked list after deleting the nodes which are having a greater value on right side.

Sample Input
8
12 15 10 11 5 6 2 3

Sample Output
15 11 6 3
 
Explanation
In the given case 12 is having right node greater than itself i.e. 12<15 so delete it.
Similarly, 10<11, 5<6 and 2<3 so delete 10, 5 and 2 as well.
Thus, linked list becomes 15->11->6->3.
 */

public class LinkedList6 {

	private class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		Node() {

		}
	}

	private Node head;
	private Node tail;
	private int size;

	public LinkedList6() {
		this.head = this.tail = null;
		this.size = 0;
	}

	public void addLast(int data) {
		Node nn = new Node();
		nn.data = data;
		nn.next = null;

		if (size == 0) {
			this.head = this.tail = nn;
		} else {
			this.tail.next = nn;
			this.tail = nn;
		}
		size++;

	}

	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

		System.out.println();
	}

	public void deleteNodes() {
		this.head = deleteNodes(this.head);
	}

	public Node deleteNodes(Node node) {
		// deletes nodes which have greater value on its right.
		if (node == null || node.next == null)
			return node;
		Node nextnode = deleteNodes(node.next);
		node.next = nextnode;
		if (nextnode.data > node.data) {
			return nextnode;
		} else {
			return node;
		}
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		LinkedList6 list = new LinkedList6();
		for (int i = 0; i < N; i++) {
			list.addLast(scn.nextInt());
		}
		list.deleteNodes();
		list.display();

	}

}
