package GenericTrees;
/*
 * Replace each node with its depth value

Input Format
Enter the value of the node and then its number of children , further add value of the 1st children and then its number of children and so on in a space separated manner

Constraints
None

Output Format
Display the tree in which all the values have been replaced with the depth value

Sample Input
80 3 40 2 110 0 160 0 60 0 70 1 140 0

Sample Output
0 => 1, 1, 1, END
1 => 2, 2, END
2 => END
2 => END
1 => END
1 => 2, END
2 => END

 */

import java.util.ArrayList;
import java.util.Scanner;

public class DepthValue {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		DepthValue m = new DepthValue();
		GenericTree gt = m.new GenericTree();
		gt.replaceWithDepth();
		gt.display();
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

		public void display() {
			this.display(this.root);
		}

		private void display(Node node) {
			// work
			String str = node.data + " => ";
			for (Node child : node.children) {
				str += child.data + ", ";
			}
			System.out.println(str + "END");

			// delegate
			for (Node child : node.children) {
				this.display(child);
			}
		}

		public void replaceWithDepth() {
			this.replaceWithDepth(this.root, 0);
		}

		private void replaceWithDepth(Node node, int d) {

			node.data = d;
			for(Node child: node.children)
				replaceWithDepth(child, d+1);

		}
	}

}

