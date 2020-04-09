package GenericTrees;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Count number of leaf nodes in a tree.

Input Format
Enter the value of the node and then its number of children , further add value of the 1st children and then its number of children and so on in a space separated manner.

Constraints
None

Output Format
Display the total number of leaf nodes

Sample Input
80 3 40 2 110 0 160 0 60 0 70 1 140 0

Sample Output
4
 */

public class LeafNodes {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		LeafNodes m = new LeafNodes();
		GenericTree gt = m.new GenericTree();
		System.out.println(gt.countLeafNodes());
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

		public int countLeafNodes() {
			return this.countLeafNodes(this.root);
		}

		private int countLeafNodes(Node node) {
			if(node.children.size() == 0)
				return 1;
			int ln = 0;
			for(Node child: node.children)
				ln += countLeafNodes(child);
			return ln;
		}
	}

}

