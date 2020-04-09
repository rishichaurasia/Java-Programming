 package GenericTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTree {

	protected class Node{
		
		int data;
		ArrayList<Node> children;
		
		Node(int data){
			this.data = data;
			children = new ArrayList<>();
		}
		
	}
	
	protected Node root;
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
	
	public void mirror() {
		this.mirror(this.root);
	}
	
	private void mirror(Node node) {
		for(Node child: node.children)
			mirror(child);
		int i = 0;
		int j = node.children.size() - 1;
		while(i < j) {
			Node in = node.children.get(i);
			Node jn = node.children.get(j);
			
			node.children.set(i, jn);
			node.children.set(j, in);
			
			i++; j--;
		}
		
		// Collentions.reverse(node.children)
	}
	
	public void printAtLevel(int level) {
		printAtLevel(root, level, 0);
	}
	
	private void printAtLevel(Node node, int level, int cl) {
		if(level == cl) {
			System.out.print(node.data + " ");
			return;
		}
		for(Node child: node.children)
			printAtLevel(child, level, cl + 1);
	}
	
	public void linearize() {
		linearize(this.root);
	}
	
	private void linearize(Node node) {
		for(Node child: node.children) {
			linearize(child);
		}
		while(node.children.size() > 1) {
			Node temp = node.children.remove(1);
			Node tail = getTail(node.children.get(0));
			tail.children.add(temp);
		}
	}
	private Node getTail(Node node) {
		if(node.children.size() == 0)
			return node;
		return getTail(node.children.get(0));
	}
	
	public void preorder() {
		preorder(root);
		System.out.println();
	}
	
	private void preorder(Node node) {
		System.out.print(node.data + " ");
		for(Node child: node.children)
			preorder(child);
	}
	
	public void postorder() {
		postorder(root);
		System.out.println();
	}
	
	private void postorder(Node node) {
		for(Node child: node.children)
			postorder(child);
		System.out.print(node.data + " ");
	}
	
	public void levelorder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this.root);
		while(!queue.isEmpty()) {
			Node node = queue.removeFirst();
			System.out.print(node.data + " ");
			for(Node child: node.children)
				queue.add(child);
		}
		System.out.println();
	}
	
	public void levelorderByLine1() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(this.root);
		queue.add(null);
		while(!queue.isEmpty()) {
			Node node = queue.removeFirst();
			if(node == null) {
				System.out.println();
				if(queue.isEmpty())
					break;
				queue.addLast(null);
				continue;
			}
			System.out.print(node.data + " ");
			for(Node child: node.children)
				queue.add(child);
		}
	}
	
	public void levelorderByLine2() {
		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();

		primary.add(this.root);
		while(!primary.isEmpty()) {
			Node node = primary.removeFirst();
			System.out.print(node.data + " ");
			for(Node child: node.children)
				helper.add(child);
			if(primary.isEmpty()) {
				System.out.println();
				primary = helper;
				helper = new LinkedList<>();
			}
		}
	}
	
}
