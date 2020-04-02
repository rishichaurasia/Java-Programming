package Assignment;

import java.util.Scanner;

/*
 * Given 2 sorted linked lists , merge the two given sorted linked list and print the final Linked List.

Input Format
First Line contains T the number of test cases.
For each test case :
Line 1 : N1 the size of list 1
Line 2 : N1 elements for list 1
Line 3 : N2 the size of list 2
Line 4 : N2 elements for list 2

Constraints
1 <= T <= 1000
0<= N1, N2 <= 10^6
-10^7 <= Ai <= 10^7

Output Format
For each testcase , print the node data of merged linked list.

Sample Input
1
4
1 3 5 7
3
2 4 6

Sample Output
1 2 3 4 5 6 7
 
Explanation
The two lists after merging give the sorted output as [1,2,3,4,5,6,7] .
 */

public class LinkedList3 {
	
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

	public LinkedList3() {
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
	
	public void merge_sorted_list(LinkedList3 other) {
		
		if(this.head == null) {
			this.head = other.head;
			this.tail = other.tail;
			return;
		}
		if(other.head == null) {
			return;
		}
		Node node1 = this.head;
		Node node2 = other.head;
		Node newHead , newTail;
		newHead = newTail = null;
		while(node1 != null && node2 != null) {
			if(newHead != null) {
				if(node1.data <= node2.data) {
					newTail = newTail.next = node1;
					node1 = node1.next;
				}else {
					newTail = newTail.next = node2;
					node2 = node2.next;
				}
			}else {
				if(node1.data <= node2.data) {
					newHead = newTail = node1;
					node1 = node1.next;
				}else {
					newHead = newTail = node2;
					node2 = node2.next;
				}
			}
		}
		while(node1 != null) {
			newTail = newTail.next = node1;
			node1 = node1.next;
		}
		while(node2 != null) {
			newTail = newTail.next = node2;
			node2 = node2.next;
		}
		this.head = newHead;
		this.tail = newTail;
		
	}
	
	public void display() {

		Node temp = this.head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}
	
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		
		int t = scn.nextInt();
	    
	    while(t > 0){

		    LinkedList3 list1 = new LinkedList3();
		    int n1 = scn.nextInt();
		 
		    for (int j = 0; j < n1; j++) {
			    int item = scn.nextInt();
			    list1.addLast(item);
		}

            LinkedList3 list2 = new LinkedList3();
		    int n2 = scn.nextInt();
		 
		    for (int j = 0; j < n2; j++) {
			    int item = scn.nextInt();
			    list2.addLast(item);
		}
		   list1.merge_sorted_list(list2);
		   list1.display();
        t--;
        }
		
	}

}
