package BinaryTree;

public class BinaryTreeClient {

	public static void main(String[] args) {
		// Input : 50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
//		BinaryTree bt = new BinaryTree();
//		bt.display();
		// BST Input : 40 true 20 true 10 false false true 30 false false true 60 true 50 false false true 70 false false
//		System.out.println(bt.isTreeBST1());
//		System.out.println(bt.isTreeBST2());
		
		int[] pre = {400, 20, 10, 30, 25, 22, 35, 60, 50, 70};
		int[] in = {10, 20, 22, 25, 30, 35, 400, 50, 60, 70};
		BinaryTree bt = new BinaryTree(pre, in);
		bt.display();
		bt.getMaxBSTSubtree();
		
//		bt.display();
//		System.out.println(bt.sum());
//		bt.preorderTraversal();
//		bt.preorder1();
//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.find(60));
//		System.out.println(bt.height1());
		// Input: 10 true 20 true 40 true 70 true 90 true 110 false false false false false true 50 false true 80 false true 100 false true 120 false false true 30 false true 60 false false 
//		System.out.println(bt.diameter1());
//		System.out.println(bt.diameter2());
//		System.out.println(bt.diameter3());
//		System.out.println(bt.isBalanced());
//		bt.preorderTraversal();
//		bt.postorderTraversal();
//		bt.inorderTraversal();
//		bt.levelOrder();
		
		// 10 true 20 true 40 true 2 false false true 3 false false true -60 false false true -30 true 50 true 60 true 80 false false false true 70 false false true -100 false false
//		System.out.println(bt.maxSubtreeSum1());
//		System.out.println(bt.maxSubtreeSum2());
//		System.out.println(bt.maxSubtreeSum3());
//		int[] pre = { 10, 20, 40, 30, 50, 60, 70};
//		int[] in = {40, 20, 10, 50, 30, 60, 70};
//		int[] post = {40, 20, 50, 70, 60, 30, 10};
//		BinaryTree bt1 = new BinaryTree(post, in);
//		bt1.display();
//		bt1.preorderTraversal();
//		bt1.inorderTraversal();
//		bt1.postorderTraversal();
	}

}