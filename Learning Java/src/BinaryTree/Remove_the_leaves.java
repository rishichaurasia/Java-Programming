package BinaryTree;

/*
 * Given a binary tree, remove all the leaves from the tree

Input Format
Enter the value of the nodes of the tree

Constraints
None

Output Format
Display the tree in which all the leaves have been removed in pre-order traversal in the following format :
Left->data => Root->data <= Right->Data
Output END if left or right node is NULL

Sample Input
50 true 12 true 18 false false false false
Sample Output
12 => 50 <= END
END => 12 <= END
 */

import java.util.Scanner;

public class Remove_the_leaves {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	static Scanner scn = new Scanner(System.in);
	private static Node root = null;

	public static Node takeInput(Node parent, Boolean isLeft) {
		int nodeData = scn.nextInt();
		Node node = new Node(nodeData, null, null);
		if (scn.nextBoolean())
			node.left = takeInput(node, true);
		if (scn.nextBoolean())
			node.right = takeInput(node, false);
		return node;
	}

	public static Node deleteLeaves(Node node) {
		if (node == null)
			return null;
		if (node.left == null && node.right == null)
			return null;
		node.left = deleteLeaves(node.left);
		node.right = deleteLeaves(node.right);
		return node;
	}

	private static void removeLeaves(Node parent, Node child, boolean ilc) {
		if (child == null)
			return;
		if (child.left == null && child.right == null) {
			if (ilc)
				parent.left = null;
			else
				parent.right = null;
		}
		removeLeaves(child, child.left, true);
		removeLeaves(child, child.right, false);

	}

	public static void display(Node node) {
		if (node == null) {
			return;
		}

		String str = "";

		if (node.left != null) {
			str += node.left.data;
		} else {
			str += "END";
		}

		str += " => " + node.data + " <= ";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += "END";
		}

		System.out.println(str);

		display(node.left);
		display(node.right);
	}

	public static void main(String[] args) {
		Node root = takeInput(null, false);
		deleteLeaves(root);
//		removeLeaves(null, root, false);
		display(root);
	}

}
