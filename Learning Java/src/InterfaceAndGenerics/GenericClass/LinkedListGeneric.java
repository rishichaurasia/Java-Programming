package InterfaceAndGenerics.GenericClass;

public class LinkedListGeneric<T> {

	private class Node {
		T data;
		Node next;
		
		Node(T data){
			this.data = data;
			this.next = null;
		}
		
		Node(){
			
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedListGeneric() {
		this.head = this.tail =  null;
		this.size = 0;
	}
	
	public void addLast(T data){
		Node nn = new Node();
		nn.data = data;
		nn.next = null;
		
		if(size == 0) {
			this.head = this.tail = nn;
		} else {
			this.tail.next = nn;
			this.tail = nn;
		}
		size++; 
		
	}
	
	public void addFirst(T data) {
		Node nn = new Node();
		nn.data = data;
		nn.next = null;
		if(size == 0) {
			this.head = this.tail = nn;
		}else {
			nn.next = head;
			head = nn;
		}
		size++;
	}
	
	public T getFirst() throws Exception {
		if(this.size == 0) {
			throw new Exception("Linked List is empty!");
		}
		return this.head.data;
	}
	
	public T getLast() throws Exception {
		if(this.size == 0) {
			throw new Exception("Linked List is empty!");
		}
		return this.tail.data;
	} 
	
	public T getAt(int idx) throws Exception {
		if(this.size == 0) {
			throw new Exception("LL is empty!");
		}
		if(idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index!");
		}
		int i = 1;
		Node temp = this.head;
		while(i <= idx) {
			temp = temp.next;
			i++;
		}
		return temp.data;
	}
	
	private Node getNodeAt(int idx) throws Exception {
		
		if(this.size == 0) {
			throw new Exception("LL is empty!");
		}
		if(idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index!");
		}
		int i = 1;
		Node temp = this.head;
		while(i <= idx) {
			temp = temp.next;
			i++;
		}
		return temp;
	}
	
	public void addAt(T data, int idx) throws Exception {
		
		if(idx == 0)
			addFirst(data);
		else if(idx == size)
			addLast(data);
		else {
		Node nn = new Node();
		nn.data = data;
		Node temp = getNodeAt(idx-1);
		nn.next = temp.next;
		temp.next = nn;
		}

	}
	
	public T removeFirst() throws Exception {
		if(this.size == 0) {
			throw new Exception("LL is empty!");
		}
		T rv = this.head.data;
		if(this.size == 1) {
			this.head = this.tail = null;
		}else {
			this.head = this.head.next;
		}
		size--;
		return rv;
		
	}
	
	public T removeLast() throws Exception {
		if(this.size == 0) {
			throw new Exception("LL is empty!");
		}
		T rv = this.tail.data;
		if(this.size == 1) {
			this.head = this.tail = null;
		}else {
			Node temp = getNodeAt(size-2);
			temp.next = null;
		}
		size--;
		return rv;
	}
	
	public T removeAt(int idx) throws Exception {
		if(idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index!");
		}
		if(idx == 0)
			return removeFirst();
		if(idx == size-1)
			return removeLast();
		Node temp = getNodeAt(idx-1);
		T rv = temp.next.data;
		temp.next = temp.next.next;
		size--;
		return rv;
	}
	
	public void display() {
		Node temp = this.head;
		while(temp!=null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
		System.out.println("end");
	}
	
}
