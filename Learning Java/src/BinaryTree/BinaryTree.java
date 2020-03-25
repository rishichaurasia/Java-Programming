package BinaryTree;

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
}
