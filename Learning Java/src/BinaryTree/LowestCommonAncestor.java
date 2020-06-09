package BinaryTree;

/*
 * Find LCA(Lowest Common Ancestor) of two elements in a Binary Tree.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
None

Output Format
Display the LCA value.

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
50
60
Sample Output
10
 */

import java.util.Scanner;

public class LowestCommonAncestor {

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

	public static int LCA(Node node, int p, int q) {
		if (node == null)
			return -1;
		if (node.data == p || node.data == q)
			return node.data;
		int left = LCA(node.left, p, q);
		int right = LCA(node.right, p, q);
		if (left != -1 && right != -1)
			return node.data;
		if (left == -1)
			return right;
		return left;
	}

	public static void main(String[] args) {
		root = takeInput(null, false);
		int p = scn.nextInt();
		int q = scn.nextInt();
		System.out.println(LCA(root, p, q));
	}

}
