package BinaryTree;

import java.util.Scanner;


/*
Given a Binary Tree, write a program that returns the size of the largest subtree which is also a Binary Search Tree (BST)

Input Format
The first line of input will contain an integer n. The next line will contain n integers denoting the the preorder traversal of the BT. The next line will contain n more integers denoting the inorder traversal of the BT.

Constraints
2 ≤ N ≤ 10^3

Output Format
A single integer denoting the size ( no of nodes in tree ) of largest BST in the given tree.

Sample Input
4
60 65 50 70
50 65 60 70
Sample Output
2
Explanation
The tree looks like

             60
          /      \
       65           70
     /           
   50       
The largest BST subtree is

       65           
     /           
   50       
which has the size 2 i.e. it has 2 nodes in it.
 */

public class LargestBSTSubtree {
	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node lChild, Node rChild) {
			this.data = data;
			this.left = lChild;
			this.right = rChild;
		}
	}
	
	static Scanner scn = new Scanner(System.in);
	
	static Node root;
	
	static void construct(int[] pre, int[] in){
		root = construct(pre, 0, pre.length-1, in, 0, in.length-1);
	}
	
	static Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		if(plo > phi || ilo>ihi)
			return null;
		Node nn = new Node(pre[plo], null, null);
		int i, nel = 0;
		for(i = ilo; i<ihi; i++) {
			if(in[i] == pre[plo])
				break;
			nel++;
		}
		
		nn.left = construct(pre, plo+1, plo + nel, in, ilo, i-1);
		nn.right = construct(pre, plo+nel+1, phi, in, i+1, ihi);
		return nn;
	}
	
	static class maxBSTPair{
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean isBST = true;
		int maxSize = 0;
	}
	
	static int getMaxBSTSubtree() {
		return getMaxBSTSubtree(root).maxSize;
	}
	
	static maxBSTPair getMaxBSTSubtree(Node node) {
		if(node == null)
			return new maxBSTPair();
		maxBSTPair lbp = getMaxBSTSubtree(node.left);
		maxBSTPair rbp = getMaxBSTSubtree(node.right);
		maxBSTPair sbp = new maxBSTPair();
		sbp.min = Math.min(node.data, Math.min(lbp.min, rbp.min));
		sbp.max = Math.max(node.data, Math.max(lbp.max, rbp.max));
		sbp.isBST = lbp.isBST && rbp.isBST && lbp.max <= node.data && rbp.min >= node.data;
		if(sbp.isBST)
			sbp.maxSize = lbp.maxSize + 1 + rbp.maxSize;
		else
			sbp.maxSize = Math.max(lbp.maxSize, rbp.maxSize);
		return sbp;
	}
	
	public static void main(String[] args) {
		int n = scn.nextInt();
		int[] pre = new int[n];
		for (int i = 0; i < pre.length; i++) {
			pre[i] = scn.nextInt();
		}
		int[] in = new int[n];
		for (int i = 0; i < in.length; i++) {
			in[i] = scn.nextInt();
		}
		construct(pre, in);
		System.out.println(getMaxBSTSubtree());
	}
}
