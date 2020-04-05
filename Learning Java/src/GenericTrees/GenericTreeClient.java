package GenericTrees;

public class GenericTreeClient {

	public static void main(String[] args) {
		// input : 10 3 20 2 50 0 60 1 80 0 30 0 40 1 70 0
		GenericTree gt = new GenericTree();
		gt.display();
		System.out.println(gt.size());
		System.out.println(gt.getMax());
		System.out.println(gt.height());
		System.out.println(gt.find(60));
		System.out.println(gt.find(90));
	}

}
