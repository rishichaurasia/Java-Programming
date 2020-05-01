package BinaryTree;
/*
You will be given a Binary Tree. Your task is to print the binary tree in Vertical Fashion. The image below describes how we define a vertical traversal of a tree.

Input Format
You will be given an Integer N denoting the number of levels in the corresponding tree. On the next line you will be given (2^N)-1 integers denoting the level order input for the tree. If at any level any node is absent then that will denoted by -1 and every integer other than -1 shows the presence of a node at that level.

Constraints
1 <= N <= 10^5

Output Format
Print all nodes of a given column in the same line.


Sample Input
4 
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 8 -1 9 -1 -1 -1 -1
Sample Output
4
2
1 5 6
3 8 
7
9
Explanation
We are to simply print the traversal of each vertical level from left to right.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Scanner;

public class VerticalOrderPrint {
	
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		VerticalOrderPrint obj = new VerticalOrderPrint();
		int level = scn.nextInt();
		BinaryTree bt = obj.new BinaryTree();
		bt.printVertical();
	}
	
	class BinaryTree{
	
		private class Node{
			int data;
			Node left;
			Node right;
		}
		
		private Node root;
		
		public BinaryTree(){
			this.construct();
		}

		private void construct() {
			
			LinkedList<Node> queue = new LinkedList<>();
			int data = scn.nextInt();
			if(data == -1)
				return;
			this.root = new Node();
			this.root.data = data;
			queue.add(this.root);
			
			while(!queue.isEmpty()) {
				Node node = queue.removeFirst();
				int ldata = scn.nextInt();
				int rdata = scn.nextInt();
				if(ldata != -1) {
					Node left = new Node();
					left.data = ldata;
					node.left = left;
					queue.add(left);
				}
				if(rdata != -1) {
					Node right = new Node();
					right.data = rdata;
					node.right = right;
					queue.add(right);
				}
			}
			
		}
		
		private class MinMax{
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
		}
		
		public void printVertical() {
			
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			MinMax minMax = new MinMax();
			verticalMap(map, this.root, 0, minMax);
			for(int i = minMax.min; i<=minMax.max; i++) {
				for(int val: map.get(i))
					System.out.print(val + " ");
				System.out.println();
			}
		}
		
		
		
		public void verticalMap(HashMap<Integer, ArrayList<Integer>> map, Node node, int hd, MinMax minMax) {
			if(node == null)
				return;
			if(!map.containsKey(hd))
				 map.put(hd, new ArrayList<Integer>());
			 map.get(hd).add(node.data);
			 if(hd < minMax.min)
				 minMax.min = hd;
			 if(hd > minMax.max)
				 minMax.max = hd;
			 verticalMap(map, node.left, hd-1, minMax);
			 verticalMap(map, node.right, hd+1, minMax);
		}

		public void display() {
			this.display(this.root);
		}
		
		public void display(Node node) {
			if(node == null)
				return;
			String str = "";
			if (node.left == null)
				str += "END->";
			else
				str += node.left.data + "->";
			str += node.data;
			if (node.right == null)
				str += "<-END";
			else
				str += "<-" + node.right.data;
			System.out.println(str);
			display(node.left);
			display(node.right);
		}
		
	
	}
	
}
