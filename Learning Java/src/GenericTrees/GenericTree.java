 package GenericTrees;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {

	private class Node{
		
		int data;
		ArrayList<Node> children;
		
		Node(int data){
			this.data = data;
			children = new ArrayList<>();
		}
		
	}
	
	private Node root;
	private int size;
	
	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		this.root = takeInput(scn, null, 0);
	}
	
	private Node takeInput(Scanner s, Node parent, int ithChild) {
		if(parent == null) {
			System.out.println("Enter the data for the root node");
		}
		else {
			System.out.println("Enter the data for the " + ithChild + "th child of node " + parent.data);
		}
		
		Node node = new Node(s.nextInt());
		size++;
		System.out.println("Enter the number of childrens for the node " + node.data);
		int children = s.nextInt();
		for(int i = 0; i<children; i++) {
			node.children.add(this.takeInput(s, node, i));
		}
		return node;
	}
	
	public int size() {
		return this.size(this.root);
	}
	
	private int size(Node node) {
		if(node == null)
			return 0;
		int count = 1;
		for(Node child: node.children)
			count += size(child);
		return count;
	}
	
	public void display() {
		this.display(this.root);
	}
	
	public int getMax() {
		return this.getMax(this.root);
	}
	
	private int getMax(Node node) {
		int maxVal = node.data;
		for(Node child: node.children)
			maxVal = Math.max(maxVal, getMax(child));
		return maxVal;
	}
	
	public int height() {
		return this.height(this.root);
	}
	
	private int height(Node node) {
		int maxH = -1;
		for(Node child: node.children)
			maxH = Math.max(maxH, height(child));
		return maxH + 1;
	}
	
	public boolean find(int item) {
		return find(this.root, item);
	}
	
	private boolean find(Node node, int item) {
		if(node.data == item)
			return true;
		for(Node child: node.children) {
			if(find(child, item))
				return true;
		}
		return false;
//		boolean rv = false;
//		for(Node child: node.children)
//			rv = rv || find(child, item);
//		return rv;
	}
	
	public void display(Node node) {
		String str = node.data + " => ";
		for(Node child: node.children)
			str += child.data + ", ";
//		for(int i = 0; i < node.children.size(); i++)
//			str += node.children.get(i).data + ", ";
		str += "END";
		System.out.println(str);
		for(int i = 0; i < node.children.size(); i++)
			this.display(node.children.get(i));
	}
	
}
