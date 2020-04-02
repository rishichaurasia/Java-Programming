package Assignment;

import java.util.Scanner;

/*
 * Given three linked lists, say a, b and c, find one node from each list such that the sum of the values of the nodes is equal to a given number say, Target. As any number of answers can be possible return the first one you get while traversing.

Input Format
The First Line contains 3 Integers n, m and k as the Size of the Three LinedLists. Next 3 Lines contains n, m and k integers Respectively as the elements of Linked Lists. Next Line contains the an Integer as Target.

Constraints
The Size of the Lists can be different.

Output Format
Display the 3 elements from each of the Lists whose sum is equals to the target separated by space.

Sample Input
3 3 3
12 6 29
23 5 8
90 20 59
101

Sample Output
6 5 90

Explanation
In the Given Sample Input, 6, 5 and 90 from lists 1, 2 and 3 respectively add to give 101.
 */

public class LinkedList7 {
	
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

	public LinkedList7() {
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
	
	public void printNodesHavingSum(LinkedList7 list1, LinkedList7 list2, LinkedList7 list3, int sum) {
		Node node1 = list1.head;
		while(node1 != null) {
			Node node2 = list2.head;
			while(node2 != null) {
				Node node3 = list3.head;
				while(node3 != null) {
					if(node1.data + node2.data + node3.data == sum) {
						System.out.println(node1.data + " " + node2.data + " " + node3.data);
						return;
					}
					node3 = node3.next;
				}
				node2 = node2.next;
			}
			node1 = node1.next;
		}
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int N1 = scn.nextInt();
		int N2 = scn.nextInt();
		int N3 = scn.nextInt();
		LinkedList7 list1 = new LinkedList7();
		LinkedList7 list2 = new LinkedList7();
		LinkedList7 list3 = new LinkedList7();
		for(int i = 0; i<N1; i++) {
			list1.addLast(scn.nextInt());
		}
		for(int i = 0; i<N2; i++) {
			list2.addLast(scn.nextInt());
		}
		for(int i = 0; i<N3; i++) {
			list3.addLast(scn.nextInt());
		}
		int sum = scn.nextInt();
		list1.printNodesHavingSum(list1, list2, list3, sum);
		

	}

}
