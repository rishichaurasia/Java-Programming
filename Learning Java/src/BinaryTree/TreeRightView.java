package BinaryTree;

/*
Given a binary tree , print its nodes from root to bottom as visible from right side of tree

Input Format
Level order input for the binary tree will be given.

Constraints
No of nodes in the tree can be less than or equal to 10^7

Output Format
A single line containing space separated integers representing the right view of the tree

Sample Input
1 2 3 4 5 -1 6 -1 -1 -1 -1 -1 -1
Sample Output
1 3 6
Explanation
The tree looks like

             1
          /      \
       2           3
    /     \           \
   4       5           6
When viewed from the left , we would see the nodes 1,3 and 6.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TreeRightView {
	
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
    
    static void printRightView(TreeNode root) {
    	int[] maxLevel = new int[] {-1};
    	printRightView(root, 0, maxLevel);
    	System.out.println();
    }
    
    //Recursive
    static void printRightView(TreeNode node, int level, int[] maxLevel) {
    	if(node == null)
    		return;
    	if(level > maxLevel[0]) {
    		System.out.print(node.data + " ");
    		maxLevel[0] = level;
    	}
    	printRightView(node.right, level+1, maxLevel);
    	printRightView(node.left, level+1, maxLevel);
    }
    
    //Iterative
    static void printRightSide(TreeNode node) {
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
    			if(currNode.right != null)
					q.add(currNode.right);
    			if(currNode.left != null)
    				q.add(currNode.left);
				
				q.remove();
					
    		}
    	}
    	System.out.println();
    }
    
    static void printRightSide2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int prev = 0;

        while (!q.isEmpty()) {
            TreeNode f = q.peek();
            if (f == null) {
                q.remove();
                if (!q.isEmpty()) {
                    q.add(null);
                }
                System.out.print(prev + " ");
            } else {
                prev = f.data;
                q.remove();

                if (f.left != null) {
                    q.add(f.left);
                }
                if (f.right != null) {
                    q.add(f.right);
                }
            }
        }
        System.out.println();
    }

	
	public static void main(String[] args) {
        TreeNode root = buildTreeLevelWise();
        printRightView(root);
        printRightSide(root);
        printRightSide2(root);
    }
	
}
