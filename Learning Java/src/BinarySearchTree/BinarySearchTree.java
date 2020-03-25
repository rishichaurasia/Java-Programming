package BinarySearchTree;

public class BinarySearchTree {

	private class Node{
		int data;
		Node left;
		Node right;
	}
	
	private Node root;
	
	public BinarySearchTree(int[] arr) {
		this.root = construct(arr, 0, arr.length-1);
	}
	
	private Node construct(int[] arr, int lo, int hi) {
		if(lo > hi)
			return null;
		int mid = (lo+hi)/2;
		Node node = new Node();
		node.data = arr[mid];
		node.left = construct(arr, lo, mid-1);
		node.right = construct(arr, mid+1, hi);
		return node;
	}
	
	public void display() {
		display(this.root);
	}
	
	private void display(Node node) {
		if(node == null)
			return;
		String str = "";
		if(node.left != null)
			str += node.left.data;
		else
			str += null;
		str +=  "->" + node.data + "<-";
		if(node.right != null)
			str += node.right.data;
		else
			str += null;
		System.out.println(str);
		display(node.left);
		display(node.right);
	}
	
}
