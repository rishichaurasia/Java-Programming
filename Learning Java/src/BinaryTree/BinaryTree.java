package BinaryTree;

import java.util.LinkedList;
import java.util.Scanner;

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
	
	public int diameter() {
		return diameter(this.root);
	}
	
	private int diameter(Node node) {
		if(node == null)
			return 0;
		int lh = height(node.LChild);
		int rh = height(node.RChild);
		int curr_dia = lh + rh + 2;
		return Math.max(curr_dia, Math.max(diameter(node.LChild), diameter(node.RChild)));
	}
	
	public int diameter2() {
		return diameter2(this.root).dia;
	}
	
	private class Diapair{
		int dia = 0;
		int ht = -1;
	}
	
	private Diapair diameter2(Node node) {
		if(node == null)
			return new Diapair();
		Diapair ldp = diameter2(node.LChild);
		Diapair rdp = diameter2(node.RChild);
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
	
}
