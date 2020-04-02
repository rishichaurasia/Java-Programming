package Assignment;

import java.util.Scanner;

/*
 * Given a list, modify it such that all odd elements appear before the even ones. The order of odd elements and even shall remain intact.

See explantaion for more info.

Input Format
The first line contains an integer N, the number of elements in the list.

The next line contains N space separated integral elements of the list.

Constraints
1 <= T <= 1000 0 <= N <= 10^6

Output Format
T lines of output

Sample Input
5
1 2 3 4 5

Sample Output
1 3 5 2 4 

Explanation
Input : 1 -> 2 -> 3 -> 4 -> 5

The order of odd elements and even does not change. For instance 3 comes before 5 in the input, so comes in the output.

Output: 1 -> 3 -> 5 -> 2 -> 4
 */

public class LinkedList2 {
	
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

	public LinkedList2() {
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
	
	public void arrangeOddEven() {
		if(this.head == null)
			return;
		Node node = this.head;
		Node fe, le, fo, lo;
		fe = le = fo = lo = null;
		while(node != null) {
			if(node.data % 2 == 0) {
				if(fe == null) {
					fe = le = node;
				}else {
					le = le.next = node;
				}
			}else {
				if(fo == null) {
					fo = lo = node;
				}else {
					lo = lo.next = node;
				}
			}
			node = node.next;
		}
		if(fo == null) {
			this.head = fe;
			this.tail = le;
		}
		else if(fo != null && fe == null) {
			this.head = fo;
			this.tail = lo;
		}else {
			this.head = fo;
			lo.next = fe;
			this.tail = le;
			le.next = null;
		}
	}
	
	public void display() {
		Node temp = this.head;
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		LinkedList2 list = new LinkedList2();
		int n = scn.nextInt();
		for(int i = 0; i<n; i++) {
			list.addLast(scn.nextInt());
		}
		list.arrangeOddEven();
		list.display();

	}

}
