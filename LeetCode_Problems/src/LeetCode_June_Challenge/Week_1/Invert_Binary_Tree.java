package LeetCode_June_Challenge.Week_1;

public class Invert_Binary_Tree {
	
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	    	this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
	
	public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;
        return root;
    }
}
