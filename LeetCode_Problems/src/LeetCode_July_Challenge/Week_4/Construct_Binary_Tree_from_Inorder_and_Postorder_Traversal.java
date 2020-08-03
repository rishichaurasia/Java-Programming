package LeetCode_July_Challenge.Week_4;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	public static void main(String[] args) {
		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };
		TreeNode root = buildTree(inorder, postorder);

	}

//	Definition for a binary tree node.
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
	}

	// Everytime we just need to know the root index in postorder array
	private static TreeNode helper(int[] in, int lo, int hi, int[] post, int index) {
		if (lo > hi)
			return null;
		TreeNode root = new TreeNode(post[index]);
		// i is the count ot nodes in right sub tree
		int i = 0;
		while (in[hi - i] != post[index])
			++i;
		root.left = helper(in, lo, hi - i - 1, post, index - 1 - i);
		root.right = helper(in, hi - i + 1, hi, post, index - 1);
		return root;
	}

	class Solution {
		int post_index;
		int[] postorder;
		int[] inorder;
		HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

		public TreeNode buildTree(int[] inorder, int[] postorder) {
			this.postorder = postorder;
			this.inorder = inorder;
			this.post_index = postorder.length - 1;

			// build a hashmap value -> its index
			int idx = 0;
			for (Integer val : inorder) {
				idx_map.put(val, idx++);
			}

			return helper(0, inorder.length - 1);

		}

		public TreeNode helper(int left, int right) {
			if (left > right) {
				return null;
			}

			// find the root value
			TreeNode root = new TreeNode(postorder[post_index]);
			int mid_index = idx_map.get(root.val);

			// recursion
			post_index--;

			// build the tree
			root.right = helper(mid_index + 1, right);
			root.left = helper(left, mid_index - 1);
			return root;

		}
	}

}
