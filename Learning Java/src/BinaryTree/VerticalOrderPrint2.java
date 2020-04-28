package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class VerticalOrderPrint2 {

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
 
        TreeNode(int d) {
            data = d;
            left = null;
            right = null;
        }
    };

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

    static void verticalOrderPrint(TreeNode root, Map<Integer, ArrayList<Integer>> m, int d) {
        if (root == null) {
            return;
        }
        if (!m.containsKey(d)) {
            m.put(d, new ArrayList<>());
        }
        m.get(d).add(root.data);
        verticalOrderPrint(root.left, m, d - 1);
        verticalOrderPrint(root.right, m, d + 1);
    }

    public static void main(String[] args) {
        int levels = sc.nextInt();
        TreeNode root = buildTreeLevelWise();

        Map<Integer, ArrayList<Integer>> m = new TreeMap<>();

        verticalOrderPrint(root, m, 0);

        m.forEach((hd, array) -> {
            array.forEach(x -> System.out.print(x + " "));
            System.out.println();
        });

    }
}

