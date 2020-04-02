package Assignment;

import java.util.Scanner;

/*
 * Given a linked list with n nodes. Find the kth element from last without computing the length of the linked list.

Input Format
First line contains space separated integers representing the node values of the linked list. The list ends when the input comes as '-1'. The next line contains a single integer k.

Constraints
n < 10^5

Output Format
Output a single line containing the node value at the kth element from last.

Sample Input
1 2 3 4 5 6 -1
3

Sample Output
4

Explanation
The linked list is 1 2 3 4 5 6. -1 is not included in the list. So the third element from the last is 4
 */

public class LinkedList1 {

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

	public LinkedList1() {
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

	public int kthEleFromLast(int k) {
		Node curr = head;
		Node ahead = head;
		for (int i = 0; i < k; i++)
			ahead = ahead.next;
		while (ahead != null) {
			curr = curr.next;
			ahead = ahead.next;
		}
		return curr.data;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		LinkedList1 list = new LinkedList1();
		int input = scn.nextInt();
		while (input != -1) {
			list.addLast(input);
			input = scn.nextInt();
		}
		System.out.println(list.kthEleFromLast(scn.nextInt()));
	}

}
