package BinarySearchTree;

/*
 * For each node in a binary search tree, create a new duplicate node, and insert the duplicate as the left child of the original node.

Input Format
Enter the number of nodes N and add N more numbers to the BST

Constraints
None

Output Format
Display the tree

Sample Input
3
2
1
3
Sample Output
2 => 2 <= 3
1 => 2 <= END
1 => 1 <= END
END => 1 <= END
3 => 3 <=END
END => 3 <=END
 */

import java.util.Scanner;

public class Add_Duplicate {

	private static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private static Node root = null;
	private static int size = 0;

	public static int size() {
		return size;
	}

	public static boolean isEmpty() {
		return size() == 0;
	}

	public static void add(int data) {
		add(data, root);
	}

	private static void add(int data, Node node) {
		if (isEmpty()) {
			Node n = new Node(data, null, null);
			size++;
			root = n;
			return;
		} else {
			if (data > node.data && node.right == null) {
				Node n = new Node(data, null, null);
				size++;
				node.right = n;
			} else if (data < node.data && node.left == null) {
				Node n = new Node(data, null, null);
				size++;
				node.left = n;
			} else if (data > node.data) {
				add(data, node.right);
			} else if (data < node.data) {
				add(data, node.left);
			}
		}
	}

	public static void display() {
		display(root);
	}

	private static void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + " => ");
		} else {
			System.out.print("END => ");
		}
		System.out.print(node.data);
		if (node.right != null) {
			System.out.print(" <= " + node.right.data);
		} else {
			System.out.print(" <= END");
		}
		System.out.println();
		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}
	}

	public static void duplicate() {
		duplicate(root);
	}

	private static void duplicate(Node node) {
		if (node == null)
			return;
		duplicate(node.left);
		duplicate(node.right);
		Node nn = new Node(node.data, node.left, null);
		node.left = nn;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			add(s.nextInt());
		}
		duplicate();
		display();
	}

}
