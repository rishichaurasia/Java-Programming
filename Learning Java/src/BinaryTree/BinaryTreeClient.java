package BinaryTree;

public class BinaryTreeClient {

	public static void main(String[] args) {
		// Input : 50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
		BinaryTree bt = new BinaryTree();
		bt.display();
//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.find(60));
//		System.out.println(bt.height1());
		// Input: 10 true 20 true 40 true 70 true 90 true 110 false false false false false true 50 false true 80 false true 100 false true 120 false false true 30 false true 60 false false 
//		System.out.println(bt.diameter());
		System.out.println(bt.isBalanced());
//		bt.preorderTraversal();
//		bt.postorderTraversal();
//		bt.inorderTraversal();
//		bt.levelOrder();
	}

}