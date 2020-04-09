package LinkedList;

import java.util.Scanner;

/*
 * Given two numbers represented by two linked lists, write a program that prints the sum list. The sum list is linked list representation of addition of two input numbers in linked lists. It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Use Recursion).

Input Format
First line contains N,M, number of nodes in the 1st and 2nd list.
Next line contains N nodes of 1st list.
Next line contains M nodes of 2nd list.

Constraints
0<N<10^6

Output Format
Print the sum list after adding the two linked lists.

Sample Input
3 3
5 6 3
8 4 2

Sample Output
1 4 0 5

Explanation
After adding the two numbers represented by linked lists i.e. 563 + 842 =1405 is represented as sum list. Sum list =1 -> 4 -> 0 -> 5.
 */

public class SumOf2LinkedList {

	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = scn.nextInt();
		int M = scn.nextInt();
		SumOf2LinkedList m = new SumOf2LinkedList();
		LinkedList list1 = m.new LinkedList();
		LinkedList list2 = m.new LinkedList();
		for(int i = 0; i<N; i++)
			list1.addLast(scn.nextInt());
		for(int i = 0; i<M; i++)
			list2.addLast(scn.nextInt());
		LinkedList result = list1.addLists(list2);  // O(m+n)
		result.display();
	}
	
	private class LinkedList {

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

		public LinkedList() {
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
		
		public void addFirst(int data) {
			Node nn = new Node();
			nn.data = data;
			nn.next = null;
			if(size == 0) {
				this.head = this.tail = nn;
			}else {
				nn.next = head;
				head = nn;
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
		
		public LinkedList addLists(LinkedList other) {
			LinkedList result = new LinkedList();
			Node head1 = this.head;
			Node head2 = other.head;
			if(this.size < other.size) {
				Node temp = head1;
				head1 = head2;
				head2 = temp;
			}
			int diff = Math.abs(this.size - other.size);
			int carry = sumLists(head1, head2, diff, 0, result);
			if(carry > 0)
				result.addFirst(carry);
			return result;
		}
		
		public int sumLists(Node n1, Node n2, int diff, int cn, LinkedList result) {
			if(cn == diff) {
				return sumSameSize(n1, n2, result);
			}
			int carry = sumLists(n1.next, n2, diff, cn + 1, result);
			int sum = n1.data + carry;
			result.addFirst(sum % 10);
			return sum / 10;
		}
		
		public int sumSameSize(Node node1, Node node2, LinkedList result) {
			if(node1 == null)
				return 0;
			int carry = sumSameSize(node1.next, node2.next, result);
			int sum = node1.data + node2.data + carry;
			result.addFirst(sum % 10);
			return sum/10;
		}
		
	}

}
