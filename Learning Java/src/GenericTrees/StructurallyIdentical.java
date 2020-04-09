package GenericTrees;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Given two trees, return true if they are structurally identical they are made of nodes with the same values arranged in the same way.

Input Format
Enter the value of the node and then its number of children , further add value of the 1st children and then its number of children and so on in a space separated manner

Constraints
None

Output Format
Display the Boolean result

Sample Input
10 3 20 2 50 0 60 0 30 1 70 0 40 3 80 0 90 0 100 0
80 3 40 2 110 0 120 0 60 0 70 1 140 0

Sample Output
false
 */

public class StructurallyIdentical {

	Scanner scn = new Scanner(System.in) ;
	
	public static void main(String[] args) {

		StructurallyIdentical m = new StructurallyIdentical();
		GenericTree gt1 = m.new GenericTree();
		GenericTree gt2 = m.new GenericTree();

		System.out.println(gt1.structurallyIdentical(gt2));

	}

	private class GenericTree {
		private class Node {
			int data;
			ArrayList<Node> children = new ArrayList<>();
		}

		private Node root;

		public GenericTree() {
			this.root = this.takeInput(scn, null, -1);
		}

		private Node takeInput(Scanner scn, Node parent, int i) {

			int childData = scn.nextInt();

			int numGC = scn.nextInt();

			Node child = new Node();
			child.data = childData;

			for (int j = 0; j < numGC; j++) {
				Node gc = this.takeInput(scn, child, j);
				child.children.add(gc);
			}

			return child;
		}

		public boolean structurallyIdentical(GenericTree other) {
			return this.structurallyIdentical(this.root, other.root);
		}

		private boolean structurallyIdentical(Node tnode, Node onode) {
			if(tnode.children.size() == onode.children.size()) {
				for(int i = 0; i<tnode.children.size(); i++) {
					boolean rv = structurallyIdentical(tnode.children.get(i), onode.children.get(i));
					if(!rv)
						return rv;
				}
				return true;
			}
			return false;
		}
		
		private boolean isIdentical(Node tnode, Node onode) {
			if(tnode.data == onode.data && tnode.children.size() == onode.children.size()) {
				for(int i = 0; i<tnode.children.size(); i++) {
					boolean rv = isIdentical(tnode.children.get(i), onode.children.get(i));
					if(!rv)
						return rv;
				}
				return true;
			}
			return false;
		}



	}

}