package Heap;

public class HeapClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap hp = new Heap();
		hp.add(10);
		hp.display();
		hp.add(20);
		hp.display();
		hp.add(30);
		hp.display();
		hp.add(40);
		hp.display();
		hp.add(5);
		hp.display();
		hp.add(3);
		hp.display();
		
		System.out.println(hp.remove());
		hp.display();
		System.out.println(hp.remove());
		hp.display();
		System.out.println(hp.remove());
		hp.display();
	}

}
