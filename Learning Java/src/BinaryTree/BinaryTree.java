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

	private Node root = null;
	private int size = 0;

	BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = takeInput(scn, null, false);
	}

	public Node takeInput(Scanner s, Node parent, Boolean isLeft) {
		if (parent == null)
			System.out.println("Enter the data for the root node");
		else if (isLeft)
			System.out.println("Enter the data for the left child of " + parent.data);
		else {
			System.out.println("Enter the data for the right child of " + parent.data);
		}

		int nodeData = s.nextInt();
		Node node = new Node(nodeData, null, null);
		this.size++;
		System.out.println("Do you have left child of " + node.data + "?");
		if (s.nextBoolean())
			node.LChild = takeInput(s, node, true);
		System.out.println("Do you have right child of " + node.data + "?");
		if (s.nextBoolean())
			node.RChild = takeInput(s, node, false);
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
			str += "END=>";
		else
			str += node.LChild.data + "=>";
		str += node.data;
		if (node.RChild == null)
			str += "<=END";
		else
			str += "<=" + node.RChild.data;
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
	
}
