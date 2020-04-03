package Lec17;

public class QUSDeqEffClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		QUSEnqEff q = new QUSEnqEff();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.display();
		System.out.println(q.dequeue());
		q.display();
		q.enqueue(50);
		q.display();
		System.out.println(q.getFront());
	}

}
