package Assignment;

import java.util.Scanner;

public class HoodiesAtCodingBlocks {
	protected int size;

	protected int front;
	protected Object[] data;

	public HoodiesAtCodingBlocks() {
		this.size = 0;
		this.front = 0;
		this.data = new Object[5];
	}

	public HoodiesAtCodingBlocks(int cap) {
		this.size = 0;
		this.front = 0;
		this.data = new Object[cap];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public void enqueue(Object item) throws Exception {
		if (this.size() == this.data.length) {
			Object[] oa = this.data;
			Object[] na = new Object[oa.length * 2];
			for (int i = 0; i < this.size(); i++) {
				int idx = (i + front) % oa.length;
				na[i] = oa[idx];
			}

			this.data = na;
			this.front = 0;
		}

		// if (this.size == this.data.length) {
		// throw new Exception("queue is full");
		// }

		this.data[(front + size) % this.data.length] = item;
		size++;

	}

	public Object dequeue() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");

		}

		Object rv = this.data[front];
		front = (front + 1) % this.data.length;
		size--;

		return rv;

	}

	public Object getFront() throws Exception {
		if (this.size == 0) {
			throw new Exception("queue is empty");
		}

		Object rv = this.data[front];

		return rv;
	}

	public void display() {
		System.out.println();
		for (int i = 0; i < size; i++) {
			int idx = (i + front) % this.data.length;
			System.out.print(this.data[idx] + " ");
		}
        System.out.print("END");
	}

	static Scanner scn = new Scanner(System.in);
	
	class Student{
		int course;
		int rollno;
		public Student(int cour, int roll) {
			course = cour;
			rollno = roll;
		}
		
		@Override
		public String toString() {
			return this.course + " " + this.rollno;
		}
	}
	
	static HoodiesAtCodingBlocks queue = new HoodiesAtCodingBlocks();
	
    public static void hoodies(int q) throws Exception{ 
	
		
    	
    	for(int i = 0; i<q; i++){
			String s = scn.next();
			if( s.equals('E')){
				Student stu = queue.new Student(scn.nextInt(), scn.nextInt());
				addToQueue(stu, false);;
			}
			else{
				System.out.println(queue.dequeue());
			}
		}
	}

	public static boolean addToQueue(Student stu, boolean flag) throws Exception{
		if(queue.isEmpty())
			return false;
		Student s = (Student)queue.dequeue();
		flag = addToQueue(stu, flag);
		queue.enqueue(s);
		if(s.course == stu.course &&!flag) {
			queue.enqueue(stu);
			flag = true;
		}
		return flag;
		
	} 


	

	public static void main(String[] args) throws Exception {

        int n = scn.nextInt();
        
        hoodies(n);
	}
}
