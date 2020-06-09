package BinaryTree;

/*
 * Given a binary tree print all nodes that don’t have a sibling

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
None

Output Format
Display all the nodes which do not have a sibling in a space separated manner

Sample Input
50 true 12 true 18 false false false false
Sample Output
12 18
 */

import java.util.Scanner;

import BinaryTree.Level_Order_zigzag.Node;

public class Sibling {

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

	public static void sibling(Node node) {
		if (node == null)
			return;
		if (node.left == null && node.right != null)
			System.out.print(node.right.data + " ");
		if (node.left != null && node.right == null)
			System.out.print(node.left.data + " ");
		sibling(node.left);
		sibling(node.right);
	}

	public static void main(String[] args) {
		root = takeInput(null, false);
		sibling(root);
	}

}
