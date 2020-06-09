package BinaryTree;

/*
 * Given a binary tree. Print the zig zag order i.e print level 1 from left to right, level 2 from right to left and so on. This means odd levels should get printed from left to right and even levels should be printed from right to left. Each level should be printed at a new line.

Input Format
Enter the values of all the nodes in the binary tree in pre-order format where true suggest the node exists and false suggests it is NULL

Constraints
None

Output Format
Display the values in zigzag level order in which each value is separated by a space

Sample Input
10 true 20 true 40 false false true 50 false false true 30 true 60 false false true 73 false false
Sample Output
10 30 20 40 50 60 73 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Level_Order_zigzag {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	static Scanner scn = new Scanner(System.in);
	private static Node root = null;

	public static Node takeInput(Node parent, Boolean isLeft) {
		int nodeData = scn.nextInt();
		Node node = new Node(nodeData, null, null);
		if (scn.nextBoolean())
			node.left = takeInput(node, true);
		if (scn.nextBoolean())
			node.right = takeInput(node, false);
		return node;
	}

//	public static void LO_zigzag(Node root) {
//		Queue<Node> q = new LinkedList<>();
//		q.add(root);
//		q.add(null);
//		ArrayList<Integer> list = new ArrayList<>();
//		int level = 1;
//		while (!q.isEmpty()) {
//			Node node = q.poll();
//			if (node == null) {
//				if (level % 2 == 1)
//					list.forEach(x -> System.out.print(x + " "));
//				else {
//					for (int i = list.size() - 1; i >= 0; i--)
//						System.out.print(list.get(i) + " ");
//				}
////				System.out.println();
//				if (q.isEmpty())
//					break;
//				q.add(null);
//				list = new ArrayList<>();
//				level++;
//				continue;
//			}
//			list.add(node.data);
//			if (node.left != null)
//				q.add(node.left);
//			if (node.right != null)
//				q.add(node.right);
//		}
//	}
	
	public static void levelOrderZZ() {

        LinkedList<Node> list = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        list.addLast(root);

        int count = 0;

        while (!list.isEmpty()) {
            Node rn = list.removeFirst();

            if (rn != null) {
                System.out.print(rn.data + " ");

                if (count % 2 == 0) {

                    stack.addFirst(rn.left);
                    stack.addFirst(rn.right);

                } else

                {
                    stack.addFirst(rn.right);
                    stack.addFirst(rn.left);

                }
            }
            if (list.isEmpty()) {
                // System.out.println();
                list = stack;
                stack = new LinkedList<>();
                count++;
            }

        }
    }

	public static void main(String[] args) {
		root = takeInput(null, false);
//		LO_zigzag(root);
		levelOrderZZ();
	}

}
