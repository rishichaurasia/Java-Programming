package Assignment;

import java.util.Scanner;

/*
 * Given a head to Linked List L, write a function to reverse the list taking k elements at a time. Assume k is a factor of the size of List.

You need not have to create a new list. Just reverse the old one using head.

Input Format
The first line contains 2 space separated integers N and K

The next line contains N space separated integral elements of the list.

Constraints
0 <= N <= 10^6 0 <= K <= 10^6

Output Format
Display the linkedlist after reversing every k elements

Sample Input
9 3
9 4 1 7 8 3 2 6 5

Sample Output
1 4 9 3 8 7 5 6 2

Explanation
N = 9 & K = 3

Original LL is : 9 -> 4 -> 1 -> 7 -> 8 -> 3 -> 2 -> 6 -> 5

After k Reverse : 1 -> 4 -> 9 -> 3 -> 8 -> 7 -> 5 -> 6 -> 2
 */

public class LinkedList4 {

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

	public LinkedList4() {
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

	public void reverse(int k) {

		this.head = reverse(this.head, k);

	}
	
	private Node reverse(Node start, int k) {
		if(start == null) {
			return null;
		}
		Node prev = null;
		Node curr = start;
		for(int i = 0; i<k && curr != null; i++) {
			Node ahead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = ahead;
		}
		start.next = reverse(curr, k);
		if(start.next == null)
			this.tail = start;
		return prev;
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int k = scn.nextInt();

		LinkedList4 list = new LinkedList4();

		for (int i = 0; i < N; i++) {
			list.addLast(scn.nextInt());
		}

		list.reverse(k);
		list.display();
	}

}
