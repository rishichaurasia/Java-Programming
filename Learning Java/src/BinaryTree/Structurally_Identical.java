package BinaryTree;

/*
 * Given two trees check if they are structurally identically. Structurally identical trees are trees that have same structure. They may or may not have the same data though.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
1 <= N <= 10^4

Output Format
Display the Boolean result

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
true
Explanation
The given two trees have the exact same structure and hence we print true.
 */

import java.util.Scanner;

public class Structurally_Identical {
	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int d) {
			data = d;
			left = null;
			right = null;
		}
	}

	static Scanner scn = new Scanner(System.in);

	public static TreeNode takeInput(TreeNode parent, Boolean isLeft) {
		int nodeData = scn.nextInt();
		TreeNode node = new TreeNode(nodeData);
		if (scn.nextBoolean())
			node.left = takeInput(node, true);
		if (scn.nextBoolean())
			node.right = takeInput(node, false);
		return node;
	}

	public static boolean isIdentical(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;
		return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
	}

	public static void main(String[] args) {
		TreeNode root1 = takeInput(null, false);
		TreeNode root2 = takeInput(null, false);
		System.out.println(isIdentical(root1, root2));
	}
}
