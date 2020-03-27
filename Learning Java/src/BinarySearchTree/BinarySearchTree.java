package BinarySearchTree;

public class BinarySearchTree {

	private class Node{
		int data;
		Node left = null;
		Node right = null;
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
	
	public boolean find(int item) {
		return find(this.root, item);
	}
	
	private boolean find(Node node, int item) {
		if(node == null)
			return false;
		if(node.data == item)
			return true;
		if(item < node.data)
			return find(node.left, item);
		else
			return find(node.right, item);
	}
	
	public int getMaximum() {
		return getMaximum(this.root);
	}
	
	private int getMaximum(Node node) {
		
		if(node.right == null)
			return node.data;
		return getMaximum(node.right);
		
//		Node start = this.root;
//		while(start.right != null)
//			start = start.right;
//		return start.data;
	}
	
	public void add(int item) {
		add(this.root, item);
	}
	
	private void add(Node node, int item) {

		if(item <= node.data) {
			if(node.left == null){
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
				return;
			}
			add(node.left, item);
		}
		else {
			if(node.right == null){
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
				return;
			}
			add(node.right, item);
		}
	}
	
	public void remove(int item) {
		this.remove(this.root, null, false, item);
	}
	
	private void remove(Node node, Node parent, boolean isleft, int item) {
		if(node == null)
			return;
		if(item < node.data) {
			remove(node.left, node, true, item);
		}else if(item > node.data){
			remove(node.right, node, false, item);
		}else {
			
			if(node.left == null && node.right == null) {
				if(isleft)
					parent.left = null;
				else
					parent.right = null;
			}
			
			else if(node.left == null && node.right != null) {
				if(isleft)
					parent.left = node.right;
				else
					parent.right = node.right;
			}
			
			else if(node.left != null && node.right == null) {
				if(isleft)
					parent.left = node.left;
				else
					parent.right = node.left ;
			}
			
			else {
				// right != null & left != null
				int max = getMaximum(node.left);
				node.data = max;
				remove(node.left, node, true, max);
			}

		}
	}
	
}
