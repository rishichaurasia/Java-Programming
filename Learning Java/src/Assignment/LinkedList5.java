package Assignment;

import java.util.Scanner;

public class LinkedList5 {

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

	public LinkedList5() {
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
	
	public void appendLastN(int n) {

		n = n % this.size;
		Node curr = this.head;
		Node ahead = this.head;
		for(int i = 0; i<n; i++) {
			ahead = ahead.next;
		}
		if(ahead == null)
			return;
		while(ahead.next != null) {
			curr = curr.next;
			ahead = ahead.next;
		}
		ahead.next = this.head;
		this.head = curr.next;
		this.tail = curr;
		curr.next = null;
		
	}
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();

		LinkedList5 list = new LinkedList5();

		for (int i = 0; i < N; i++) {
			list.addLast(scn.nextInt());
		}
		int n= scn.nextInt();
		list.appendLastN(n);
		list.display();

	}

}
