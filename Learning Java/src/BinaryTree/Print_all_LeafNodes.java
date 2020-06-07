package BinaryTree;

/*
 * Given a Binary Tree Print all the leaf nodes.

Input Format
Level order input of the binary tree

Constraints
Total no of nodes <1000

Output Format
All leaf nodes from left to right in single line

Sample Input
1
2 3
4 5
6 7
-1 -1
-1 -1
-1 -1
-1 -1
Sample Output
4 5 6 7
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Print_all_LeafNodes {

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

	static Scanner sc = new Scanner(System.in);

	static TreeNode buildTreeLevelWise() {

		int d = sc.nextInt();
		if (d == -1)
			return null;
		TreeNode root = new TreeNode(d);
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			TreeNode f = q.poll();
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();

			if (c1 != -1) {
				f.left = new TreeNode(c1);
				q.add(f.left);
			}
			if (c2 != -1) {
				f.right = new TreeNode(c2);
				q.add(f.right);
			}
		}
		return root;
	}

	public static void printLeafNodes(TreeNode node) {
		if (node == null)
			return;
		if (node.left == null && node.right == null) {
			System.out.print(node.data + " ");
			return;
		}
		printLeafNodes(node.left);
		printLeafNodes(node.right);
	}

	public static void main(String[] args) {
		TreeNode root = buildTreeLevelWise();
		printLeafNodes(root);
	}

}
