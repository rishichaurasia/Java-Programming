package BinaryTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

import BinaryTree.TreeTopView.DataHtPair;
import BinaryTree.TreeTopView.NodeIntPair;
import BinaryTree.TreeTopView.TreeNode;

/*
Given a binary tree , print the nodes in left to right manner as visible from below the tree

Input Format
Level order input for the binary tree will be given.

Constraints
No of nodes in the tree can be less than or equal to 10^7

Output Format
A single line containing space separated integers representing the bottom view of the tree

Sample Input
1 2 3 4 5 6  -1 -1 -1 -1 -1 -1 -1
Sample Output
4 2 6 3
Explanation
The tree looks like

             1
          /      \
       2           3
    /     \       /
   4       5     6
(Note that 5 and 6 are at the same position so we consider the right one to lower)
 */

public class TreeBottomView {
	
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
    
    static class DataHtPair{
    	int data;
    	int ht;
    }
    
    //recursive
    static void printBottomView(TreeNode node, int hd, int ht, Map<Integer, DataHtPair> map) {
    	if(node == null)
    		return;
    	DataHtPair pair = new DataHtPair();
    	pair.data = node.data;
    	pair.ht = ht;
    	if(!map.containsKey(hd))
    		map.put(hd, pair);
    	else if(ht >= map.get(hd).ht)
    		map.put(hd, pair);
    	printBottomView(node.left, hd-1, ht+1, map);
    	printBottomView(node.right, hd+1, ht+1, map);
    }
    
    static class NodeIntPair{
    	TreeNode first;
    	int second;
    	
    	public NodeIntPair(TreeNode node, int hd) {
			first = node;
			second = hd;
		}
    }
    
    //iterative
    static void bottomViewIterative(TreeNode root) {
        Queue<NodeIntPair> qu = new LinkedList<>();
        qu.add(new NodeIntPair(root, 0));
        Map<Integer, Integer> mp = new TreeMap<>();
        while (!qu.isEmpty()) {
            TreeNode temp = qu.peek().first;
            int dist = qu.peek().second;
            qu.remove();
            mp.put(dist, temp.data);
            if (temp.left != null) {
                qu.add(new NodeIntPair(temp.left, dist - 1));
            }
            if (temp.right != null) {
                qu.add(new NodeIntPair(temp.right, dist + 1));
            }
        }

        mp.forEach((k, v) -> System.out.print(v + " "));
    }
	
	public static void main(String[] args) {
        TreeNode root = buildTreeLevelWise();
        Map<Integer, DataHtPair> map = new TreeMap<>();
//        printBottomView(root, 0, 0, map);
//        map.forEach((hd, pair) -> System.out.print(pair.data + " "));
        bottomViewIterative(root);
        // 20 8 22 5 3 4 25 -1 -1 10 14 -1 -1 -1 -1 -1 -1 -1 -1
    }
	
	
	
}
