package BinaryTree;

public class BinaryTreeClient {

	public static void main(String[] args) {
		// Input : 50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
		BinaryTree bt = new BinaryTree();
//		bt.display();
		bt.preorderTraversal();
		bt.postorderTraversal();
		bt.inorderTraversal();
		bt.levelOrder();
	}

}