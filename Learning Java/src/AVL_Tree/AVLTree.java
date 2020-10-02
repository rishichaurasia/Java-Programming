package AVL_Tree;

public class AVLTree {
	
	private class Node{
		int data;
		Node left;
		Node right;
		int height;
		
		Node(int data){
			this.data = data;
			this.height = 1;
		}
	}
	
	private Node root;
	
	public void insert(int item) {
		
		this.root = insert(this.root, item);
		
	}

	private Node insert(Node node, int item) {
		
		if(node == null) {
			return new Node(item);
		}
		
		if(item > node.data) {
			node.right = insert(node.right, item);
		}else if(item < node.data) {
			node.left = insert(node.left, item);
		}
		
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		int bf = bf(node);
		//LL case
		if(bf > 1 && item < node.left.data)
			return rightRotate(node);
		
		// RR case
		if(bf < -1 && item > node.right.data)
			return leftRotate(node);
		
		// LR case
		if(bf > 1 && item > node.left.data) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		
		// RL case
		if(bf <  -1 && item < node.right.data) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		
		return node;
		
	}
	
	private int bf(Node node) {
		
		if(node == null)
			return 0;
		
		return height(node.left) - height(node.right);
		
	}
	
	private Node rightRotate(Node c) {
		
		Node b = c.left;
		Node T3 = b.right;
		
		// Rotate
		b.right = c;
		c.left = T3;
		
		// ht update
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;
		
		return b;
	}
	
	private Node leftRotate(Node c) {
		
		Node b = c.right;
		Node T2 = b.left;
		
		// Rotate
		b.left = c;
		c.right = T2;
		
		// ht update
		c.height = Math.max(height(c.left), height(c.right)) + 1;
		b.height = Math.max(height(b.left), height(b.right)) + 1;
		
		return b;
	}
	
	private int height(Node node) {
		if(node == null)
			return 0;
		
		return node.height;
	}
	
	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		
		if(node == null)
			return;
		
		String str = "";
		
		if(node.left == null)
			str += ".";
		else
			str += node.left.data;
		
		str += " -> " + node.data + " <- ";
		
		if(node.right == null)
			str += ".";
		else
			str += node.right.data;
		
		System.out.println(str);
		
		display(node.left);
		display(node.right);
		
	}
	
}
