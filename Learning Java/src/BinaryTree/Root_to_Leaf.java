package BinaryTree;

/*
 * Given a binary tree and a number k, print out all root to leaf paths where the sum of all nodes value is same as the given number.

Input Format
First line contains the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL. Second line contains the number k.

Constraints
None

Output Format
Display the root to leaf path whose sum is equal to k.

Sample Input
10 true 20 true 30 false false true 50 false false true 40 true 60 false false true 73 false false
60
Sample Output
10 20 30
Explanation
The given tree is in pre order traversal. So convert it into binary tree and check root to leaf path sum.
 */

import java.util.Scanner;

public class Root_to_Leaf {

	static class Node {
		int data;
		Node LChild;
		Node RChild;

		Node(int data, Node lChild, Node rChild) {
			this.data = data;
			this.LChild = lChild;
			this.RChild = rChild;
		}
	}

	static Scanner scn = new Scanner(System.in);
	private static Node root = null;

	public static Node takeInput(Node parent, Boolean isLeft) {
		int nodeData = scn.nextInt();
		Node node = new Node(nodeData, null, null);
		if (scn.nextBoolean())
			node.LChild = takeInput(node, true);
		if (scn.nextBoolean())
			node.RChild = takeInput(node, false);
		return node;
	}

	public static void printPaths(Node node, String path, int sum, int currSum) {
		if (node == null)
			return;
		path += node.data + " ";
		currSum += node.data;
		if (currSum == sum) {
			if (node.LChild == null && node.RChild == null)
				System.out.println(path);
			return;
		}
		printPaths(node.LChild, path, sum, currSum);
		printPaths(node.RChild, path, sum, currSum);
	}

	public static void main(String[] args) {
		root = takeInput(null, false);
		int sum = scn.nextInt();
		printPaths(root, "", sum, 0);
	}

}
