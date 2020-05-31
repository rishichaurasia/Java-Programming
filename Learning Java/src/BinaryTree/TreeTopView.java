package BinaryTree;

/*
Given a binary tree , print the nodes in left to right manner as visible from above the tree

Input Format
Level order input for the binary tree will be given.

Constraints
No of nodes in the tree can be less than or equal to 10^7

Output Format
A single line containing space separated integers representing the top view of the tree

Sample Input
1 2 3 4 5 6  -1 -1 -1 -1 -1 -1 -1
Sample Output
4 2 1 3
Explanation
The tree looks like

             1
          /      \
       2           3
    /     \       /
   4       5     6
When viewed from the top , we would see the nodes 4, 2, 1 and 3.
*/

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;


public class TreeTopView {
	
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
    static void printTopView(TreeNode node, int hd, int ht, Map<Integer, DataHtPair> map) {
    	if(node == null)
    		return;
    	DataHtPair pair = new DataHtPair();
    	pair.data = node.data;
    	pair.ht = ht;
    	if(!map.containsKey(hd))
    		map.put(hd, pair);
    	else if(ht < map.get(hd).ht)
    		map.put(hd, pair);
    	printTopView(node.left, hd-1, ht+1, map);
    	printTopView(node.right, hd+1, ht+1, map);
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
    static void topViewIterative(TreeNode root) {
        Queue<NodeIntPair> qu = new LinkedList<>();
        qu.add(new NodeIntPair(root, 0));
        Map<Integer, Integer> mp = new TreeMap<>();
        while (!qu.isEmpty()) {
            TreeNode temp = qu.peek().first;
            int dist = qu.peek().second;
            qu.remove();
            if (!mp.containsKey(dist)) {
                mp.put(dist, temp.data);
            }
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
//        printTopView(root, 0, 0, map);
//        map.forEach((hd, pair) -> System.out.print(pair.data + " "));
        topViewIterative(root);
        
    }

}
