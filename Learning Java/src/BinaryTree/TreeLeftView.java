package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Given a binary tree , print its nodes from root to bottom as visible from left side of tree

Input Format
Level order input for the binary tree will be given.

Constraints
No of nodes in the tree can be less than or equal to 10^7

Output Format
A single line containing space separated integers representing the left view of the tree

Sample Input
1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
Sample Output
1 2 4
Explanation
The tree looks like

             1
          /      \
       2           3
    /     \           \
   4       5           6
When viewed from the left , we would see the nodes 1,2 and 4.
 */

public class TreeLeftView {
	
	static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
 
        TreeNode(int d) {
            data = d;
            left = null;
            right = null;
        }
    }
    
    static Scanner sc = new Scanner(System.in);

    static TreeNode buildTreeLevelWise() {

        int d = sc.nextInt();
        if(d == -1)
        	return null;
        TreeNode root = new TreeNode(d);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            TreeNode f = q.poll();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            if (c1 != -1) {
                f.left = new TreeNode(c1);
                q.add(f.left);
            }
            if (c2 != -1) {
                f.right = new TreeNode(c2);
                q.add(f.right);
            }
        }
        return root;
    }
    
    static void printLeftView(TreeNode root) {
    	int[] maxLevel = new int[] {-1};
    	printLeftView(root, 0, maxLevel);
    }
    
    //Recursive
    static void printLeftView(TreeNode node, int level, int[] maxLevel) {
    	if(node == null)
    		return;
    	if(level > maxLevel[0]) {
    		System.out.print(node.data + " ");
    		maxLevel[0] = level;
    	}
    	printLeftView(node.left, level+1, maxLevel);
    	printLeftView(node.right, level+1, maxLevel);
    }
    
    //Iterative
    static void printLeftSide(TreeNode node) {
    	if(node == null)
    		return;
    	Queue<TreeNode> q = new LinkedList<>();
    	q.add(node);
    	q.add(null);
    	
    	boolean flag = true;
    	
    	while(!q.isEmpty()) {
    		TreeNode currNode = q.peek();
    		if(currNode == null) {
    			q.remove();
    			if(!q.isEmpty())
    				q.add(null);
    			flag = true;
    		}else {
    			if(flag) {
    				System.out.print(currNode.data + " ");
    				flag = false;
    			}
    			if(currNode.left != null)
    				q.add(currNode.left);
				if(currNode.right != null)
					q.add(currNode.right);
				q.remove();
					
    		}
    	}
    }
    
    
	public static void main(String[] args) {
        TreeNode root = buildTreeLevelWise();
        printLeftView(root);
//        printLeftSide(root);
    }
	
}
