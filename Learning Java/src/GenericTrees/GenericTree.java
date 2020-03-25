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
	
	public void display() {
		this.display(this.root);
	}
	
	public void display(Node node) {
		String str = node.data + " => ";
		for(int i = 0; i < node.children.size(); i++)
			str += node.children.get(i).data + ", ";
		str += "END";
		System.out.println(str);
		for(int i = 0; i < node.children.size(); i++)
			this.display(node.children.get(i));
	}
	
}
