package GenericTrees;

/*
 * Take input of a generic tree using buildtree() function and also take input K the level at which we need to find the sum.

Input Format
Take a generic tree input where you are first given the data of the node and then its no of children. The input is of preorder form and it is assured that the no of children will not exceed 2. The input of the tree is followed by a single integer K.

Constraints
1 <= Nodes in tree <=1000
1<K<10

Output Format
A single line containing the sum at level K.

Sample Input
1 2
2 2
3 0
4 0
5 2
6 0
7 0
2

Sample Output
20

Explanation
Here the tree looks like

                     1                                 Level 0
                /          \
              2              5                         Level 1
           /      \       /     \
          3       4      6        7                    Level 2
Sum at Level 2 = 3 + 4 + 6 + 7 = 20
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SumAtLevelK {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		SumAtLevelK m = new SumAtLevelK();
		GenericTree gt = m.new GenericTree();
		int k = scn.nextInt();
		System.out.println(gt.sumAtLevelK(k));

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

		public int sumAtLevelK(int k) {
			return this.sumAtLevelK(this.root, k, 0);
		}

		private int sumAtLevelK(Node node, int k, int level) {
			if(level == k)
				return node.data;
			if(level > k)
				return 0;
			int sum = 0;
			for(Node child: node.children)
				sum += sumAtLevelK(child, k, level + 1);
			return sum;
		}

	}

}


