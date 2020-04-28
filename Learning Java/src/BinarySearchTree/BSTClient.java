package BinarySearchTree;

public class BSTClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 20, 30, 40, 50, 60, 70 };
		BinarySearchTree  bst = new BinarySearchTree(arr);
//		System.out.println(bst.find(50));
//		System.out.println(bst.getMaximum());
//		bst.add(55);
//		bst.add(27);
//		bst.display();
//		System.out.println();
//		bst.remove(60);
//		bst.replaceWithSumOfLarger1();
//		bst.replaceWit hSumOfLarger2();
//		bst.display();
//		bst.printDecreasing();
		bst.printInRange(15, 65);
	}
	
	

}
