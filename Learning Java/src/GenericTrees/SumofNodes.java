package GenericTrees;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Given a tree find sum of all the nodes.

Input Format
Enter the value of the node and then its number of children , further add value of the 1st children and then its number of children and so on in a space separated manner.

Constraints
None

Output Format
Display the sum of all the nodes

Sample Input
80 3 40 2 110 0 120 0 60 0 70 1 140 0

Sample Output
620
 */

public class SumofNodes {

	public static void main(String[] args) {

		SumofNodes m = new SumofNodes();
		GenericTree gt = m.new GenericTree();

		System.out.println(gt.sumOfNodes());

	}

	private class GenericTree {
		private class Node {
			int data;
			ArrayList<Node> children = new ArrayList<>();
		}

		private Node root;

		public GenericTree() {
			this.root = this.takeInput(new Scanner(System.in), null, -1);
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

		public int sumOfNodes() {
			return this.sumOfNodes(this.root);
		}

		private int sumOfNodes(Node node) {
			
			int sum = node.data;
			for(Node child: node.children)
				sum += sumOfNodes(child);
			return sum;
		}

	}

}

