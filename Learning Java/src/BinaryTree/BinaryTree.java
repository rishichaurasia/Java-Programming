package BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {
	private class Node {
		int data;
		Node LChild;
		Node RChild;

		Node(int data, Node lChild, Node rChild) {
			this.data = data;
			this.LChild = lChild;
			this.RChild = rChild;
		}
	}
	
	Scanner scn = new Scanner(System.in);
	private Node root = null;
	private int size = 0;

	BinaryTree() {
		this.root = takeInput(null, false);
	}

	public Node takeInput(Node parent, Boolean isLeft) {
		if (parent == null)
			System.out.println("Enter the data for the root node");
		else if (isLeft)
			System.out.println("Enter the data for the left child of " + parent.data);
		else {
			System.out.println("Enter the data for the right child of " + parent.data);
		}

		int nodeData = scn.nextInt();
		Node node = new Node(nodeData, null, null);
		this.size++;
		System.out.println("Do you have left child of " + node.data + "?");
		if (scn.nextBoolean())
			node.LChild = takeInput(node, true);
		System.out.println("Do you have right child of " + node.data + "?");
		if (scn.nextBoolean())
			node.RChild = takeInput(node, false);
		return node;
	}
	
	BinaryTree(int[] pre, int[] in){
		this.root = construct(pre, 0, pre.length-1, in, 0, in.length-1);
	}
	
	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {
		if(plo > phi || ilo>ihi)
			return null;
		Node nn = new Node(pre[plo], null, null);
		int i, nel = 0;
		for(i = ilo; i<ihi; i++) {
			if(in[i] == pre[plo])
				break;
			nel++;
		}
		
		nn.LChild = construct(pre, plo+1, plo + nel, in, ilo, i-1);
		nn.RChild = construct(pre, plo+nel+1, phi, in, i+1, ihi);
		return nn;
	}
	
//	BinaryTree(int[] post, int[] in){
//		this.root = construct(post, 0, post.length-1, in, 0, in.length-1);
//	}
//
//	private Node construct(int[] post, int plo, int phi, int[] in, int ilo, int ihi) {
//		if(plo > phi || ilo > ihi)
//			return null;
//		Node nn = new Node(post[phi], null, null);
//		int i, nel = 0;
//		for(i = ilo; i<ihi; i++) {
//			if(in[i] == post[phi])
//				break;
//			nel++;
//		}
//		nn.LChild = construct(post, plo, plo+nel-1, in, ilo, i-1);
//		nn.RChild = construct(post, plo+nel, phi-1, in, i+1, ihi);
//		return nn;
//	}

	public void display() {
		this.display(this.root);
	}

	public void display(Node node) {
		if(node == null)
			return;
		String str = "";
		if (node.LChild == null)
			str += "END->";
		else
			str += node.LChild.data + "->";
		str += node.data;
		if (node.RChild == null)
			str += "<-END";
		else
			str += "<-" + node.RChild.data;
		System.out.println(str);
		display(node.LChild);
		display(node.RChild);
	}
	
	public int height() {
		return this.height(this.root);
	}
	
	private int height(Node node) {
		
		if(node != null)
			return Math.max(this.height(node.LChild), this.height(node.RChild)) + 1;
		else
			return -1;
	}
	
	public void preorderTraversal() {
		this.preorderTraversal(this.root);
		System.out.println("END");
	}
	
	private void preorderTraversal(Node node) {
		if(node == null)
			return;
		System.out.print(node.data + ", ");
		this.preorderTraversal(node.LChild);
		this.preorderTraversal(node.RChild);
	}
	
	public void postorderTraversal() {
		this.postorderTraversal(this.root);
		System.out.println("END");
	}
	
	private void postorderTraversal(Node node) {
		if(node == null)
			return;
		this.postorderTraversal(node.LChild);
		this.postorderTraversal(node.RChild);
		System.out.print(node.data + ", ");
	}
	
	public void inorderTraversal() {
		this.inorderTraversal(this.root);
		System.out.println("END");
	}
	
	private void inorderTraversal(Node node) {
		if(node == null)
			return;
		this.inorderTraversal(node.LChild);
		System.out.print(node.data + ", ");
		this.inorderTraversal(node.RChild);
		
	}
	
	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this.root);
		while(!queue.isEmpty()) {
			Node rv = queue.removeFirst();
			System.out.print(rv.data + ", ");
			if(rv.LChild != null)
				queue.add(rv.LChild);
			if(rv.RChild != null)
				queue.add(rv.RChild);
		}
		System.out.println("END");
	}
	
	public int size() {
		return this.size(this.root);
	}
	
	private int size(Node node) {
		if(node == null)
			return 0;
		return 1 + size(node.LChild) + size(node.RChild); 
	}
	
	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if(node == null)
			return Integer.MIN_VALUE;
		int max = node.data;
		int left = max(node.LChild);
		int right = max(node.RChild);
		if(left > max)
			max = left;
		if(right > max)
			max = right;
		return max;
	}
	
	public boolean find(int item) {
		return this.find(this.root, item);
	}

	private boolean find(Node node, int item) {
		if(node == null)
			return false;
		if(node.data == item)
			return true;
		return find(node.LChild, item) || find(node.RChild, item);
	}
	
	public int height1() {
		return this.height1(this.root);
	}

	private int height1(Node node) {
		if(node == null)
			return -1;
		int max = Math.max(height1(node.LChild), height1(node.LChild));
		return max + 1;
	}
	
	private int maxDia = 0;
	
	public int diameter1() {
		diameter1(this.root);
		return maxDia;
	}
	
	private int diameter1(Node node) {
		if(node == null)
			return -1;
		int lh = diameter1(node.LChild);
		int rh = diameter1(node.RChild);
		int dia = lh + rh + 2;
		maxDia = Math.max(maxDia, dia);
		return Math.max(lh,rh) + 1;
	}

	public int diameter2() {
		return diameter2(this.root);
	}
	
	private int diameter2(Node node) {
		if(node == null)
			return 0;
		int lh = height(node.LChild);
		int rh = height(node.RChild);
		int curr_dia = lh + rh + 2;
		return Math.max(curr_dia, Math.max(diameter2(node.LChild), diameter2(node.RChild)));
	}
	
	public int diameter3() {
		return diameter3(this.root).dia;
	}
	
	private class Diapair{
		int dia = 0;
		int ht = -1;
	}
	
	private Diapair diameter3(Node node) {
		if(node == null)
			return new Diapair();
		Diapair ldp = diameter3(node.LChild);
		Diapair rdp = diameter3(node.RChild);
		Diapair sdp = new Diapair();
		sdp.dia = Math.max(ldp.ht + rdp.ht + 2, Math.max(ldp.dia, rdp.dia));
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;
		return sdp;
	}
	
	public boolean isBalanced() {
		return isBalanced(this.root).isbal;
	}
	
	private class Balpair{
		int ht = -1;
		boolean isbal = true;
	}
	
	private Balpair isBalanced(Node node) {
		if(node == null)
			return new Balpair();
		Balpair lbp = isBalanced(node.LChild);
		Balpair rbp = isBalanced(node.RChild);
		Balpair sbp = new Balpair();
		int bf = lbp.ht - rbp.ht;
		boolean isBal = false;
		if(bf == 1 || bf == 0 || bf == -1)
			isBal = true;
		sbp.isbal = lbp.isbal && rbp.isbal && isBal;
		sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;
		return sbp;
		
	}
	
	public boolean flipEqivalent(BinaryTree other) {
		return flipEqivalent(this.root,other.root);
	}

	private boolean flipEqivalent(Node node1, Node node2) {
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null && node2 != null)
			return false;
		if(node1 != null && node2 == null)
			return false;
		if(node1.data != node2.data)
			return false;
		boolean ll = flipEqivalent(node1.LChild, node2.LChild);
		boolean rr = flipEqivalent(node1.RChild, node2.RChild);
		if(ll && rr)
			return true;
		boolean lr = flipEqivalent(node1.LChild, node2.RChild);
		boolean rl = flipEqivalent(node1.RChild, node2.LChild);
		return (lr && rl);
	}
	
	private class Pair{
		Node node;
		boolean sd;
		boolean ld;
		boolean rd;
	}
	
	public void preorder1() {
		Stack<Pair> stack = new Stack<>();
		
		Pair sp = new Pair();
		sp.node  = this.root;
		
		stack.push(sp);
		
		while(!stack.isEmpty()) {
			Pair tp = stack.peek();
			
			if(tp.node == null) {
				stack.pop();
				continue;
			}
			
			if(tp.sd == false) {
				System.out.print(tp.node.data + " ");
				tp.sd = true;
			}else if(tp.ld == false) {
				Pair np = new Pair();
				np.node = tp.node.LChild;
				
				stack.push(np);
				tp.ld = true;
			}else if(tp.rd == false) {
				Pair np = new Pair();
				np.node = tp.node.RChild;
				
				stack.push(np);
				tp.rd = true;
			}else {
				stack.pop();
			}
		}
		System.out.println();
	}
	
	public int sum() {
		return sum(this.root);
	}

	private int sum(Node node) {

		if(node == null)
			return 0;
		return node.data + sum(node.LChild) + sum(node.RChild);
		
	}
	
	int maxSum = Integer.MIN_VALUE;
	
	public int maxSubtreeSum1() {
		maxSubtreeSum1(this.root);
		return maxSum;
	}

//	private void maxSubtreeSum1(Node node) {
//		
//		if(node == null)
//			return;
//		int curr_sum = this.sum(node);
//		maxSum = Math.max(maxSum, curr_sum);
//		maxSubtreeSum1(node.LChild);
//		maxSubtreeSum1(node.RChild);
//	}
	
	private int maxSubtreeSum1(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = maxSubtreeSum1(node.LChild);
		int rs = maxSubtreeSum1(node.RChild);

		int nodeans = ls + rs + node.data;

		if (nodeans > maxSum) {
			maxSum = nodeans;
		}

		return nodeans;

	}
	
	public int maxSubtreeSum2() {
		return maxSubtreeSum2(this.root);
	}

	private int maxSubtreeSum2(Node node) {

		if(node == null)
			return Integer.MIN_VALUE;
		int lmax = maxSubtreeSum2(node.LChild);
		int rmax = maxSubtreeSum2(node.RChild);
		return Math.max(sum(node), Math.max(lmax, rmax));
		
	}
	
	public int maxSubtreeSum3() {
		return maxSubtreeSum3(this.root).maxSubtreeSum;
	}
	
	private class maxSubtreeSumPair{
		int maxSubtreeSum = Integer.MIN_VALUE;
		int entireSum = 0;
	}

	private maxSubtreeSumPair maxSubtreeSum3(Node node) {

		if(node == null) {
			return new maxSubtreeSumPair();
		}
		maxSubtreeSumPair lp = maxSubtreeSum3(node.LChild);
		maxSubtreeSumPair rp = maxSubtreeSum3(node.RChild);
		maxSubtreeSumPair sp = new maxSubtreeSumPair();
		sp.entireSum = lp.entireSum + node.data + rp.entireSum;
		sp.maxSubtreeSum = Math.max(sp.entireSum, Math.max(lp.maxSubtreeSum, rp.maxSubtreeSum));
		return sp;
	}
	
	//using global variable
	public boolean isTreeBST1() {
		return isTreeBST1(this.root);
	}

	int predecessor = Integer.MIN_VALUE;
	
	private boolean isTreeBST1(Node node) {
		if(node == null)
			return true;
		if(!isTreeBST1(node.LChild))
			return false;
		if(!(node.data >= predecessor))
			return false;
		predecessor = node.data;
		if(!isTreeBST1(node.RChild))
			return false;
		return true;
		
	}
	
	//without using global variable
	class BSTPair{
		boolean isBST = true;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	}
	public boolean isTreeBST2() {
		return isTreeBST2(this.root).isBST;
	}

	private BSTPair isTreeBST2(Node node) {
		if(node == null)
			return new BSTPair();
		BSTPair lbp = isTreeBST2(node.LChild);
		BSTPair rbp = isTreeBST2(node.RChild);
		BSTPair sbp = new BSTPair();
		sbp.min = Math.min(node.data,Math.min(lbp.min, rbp.min));
		sbp.max = Math.max(node.data ,Math.max(lbp.max, rbp.max));
		sbp.isBST = node.data >= lbp.max && node.data <= rbp.min;
		return sbp;
	}
	
	class maxBSTPair{
		boolean isBST = true;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		int largestBSTRootNode;
		int largestBSTSize ;
	}
	
	public void getMaxBSTSubtree() {
		maxBSTPair rv = getMaxBSTSubtree(this.root);
		System.out.println(rv.largestBSTRootNode + " " + rv.largestBSTSize);
	}

	private maxBSTPair getMaxBSTSubtree(Node node) {
		if(node == null)
			return new maxBSTPair();
		maxBSTPair lbp = getMaxBSTSubtree(node.LChild);
		maxBSTPair rbp = getMaxBSTSubtree(node.RChild);
		maxBSTPair sbp = new maxBSTPair();
		sbp.min = Math.min(node.data,Math.min(lbp.min, rbp.min));
		sbp.max = Math.max(node.data ,Math.max(lbp.max, rbp.max));
		sbp.isBST = node.data >= lbp.max && node.data <= rbp.min;
		if(sbp.isBST) {
			sbp.largestBSTRootNode = node.data;
			sbp.largestBSTSize = lbp.largestBSTSize + rbp.largestBSTSize + 1;
		}else {
			if(lbp.largestBSTSize > rbp.largestBSTSize) {
				sbp.largestBSTRootNode = lbp.largestBSTRootNode;
				sbp.largestBSTSize = lbp.largestBSTSize;
			}else {
				sbp.largestBSTRootNode = rbp.largestBSTRootNode;
				sbp.largestBSTSize = rbp.largestBSTSize;
			}
		}
		return sbp;
	}
	
}
