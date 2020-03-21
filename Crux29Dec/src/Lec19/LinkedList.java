package Lec19;

public class LinkedList {

	private class Node {
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
		
		Node(){
			
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public LinkedList() {
		this.head = this.tail =  null;
		this.size = 0;
	}
	
	public void addLast(int data){
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
	
	public void addFirst(int data) {
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
	
	public int getFirst() throws Exception {
		if(this.size == 0) {
			throw new Exception("Linked List is empty!");
		}
		return this.head.data;
	}
	
	public int getLast() throws Exception {
		if(this.size == 0) {
			throw new Exception("Linked List is empty!");
		}
		return this.tail.data;
	} 
	
	public int getAt(int idx) throws Exception {
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
	
	public void addAt(int data, int idx) throws Exception {
		
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
	
	public int removeFirst() throws Exception {
		if(this.size == 0) {
			throw new Exception("LL is empty!");
		}
		int rv = this.head.data;
		if(this.size == 1) {
			this.head = this.tail = null;
		}else {
			this.head = this.head.next;
		}
		size--;
		return rv;
		
	}
	
	public int removeLast() throws Exception {
		if(this.size == 0) {
			throw new Exception("LL is empty!");
		}
		int rv = this.tail.data;
		if(this.size == 1) {
			this.head = this.tail = null;
		}else {
			Node temp = getNodeAt(size-2);
			temp.next = null;
		}
		size--;
		return rv;
	}
	
	public int removeAt(int idx) throws Exception {
		if(idx < 0 || idx >= this.size) {
			throw new Exception("Invalid index!");
		}
		if(idx == 0)
			return removeFirst();
		if(idx == size-1)
			return removeLast();
		Node temp = getNodeAt(idx-1);
		int rv = temp.next.data;
		temp.next = temp.next.next;
		size--;
		return rv;
	}
	
	public void reverseByData() throws Exception{
		int lidx = 0;
		int ridx = this.size-1;
		while(lidx<ridx) {
			Node ln = getNodeAt(lidx);
			Node rn = getNodeAt(ridx);
			int temp = ln.data;
			ln.data = rn.data;
			rn.data = temp;
			lidx++;
			ridx--;
		}
	}
	
	public void reverseByPointer() throws Exception {
		if(this.size == 0) {
			throw new Exception("LL is empty!");
		}
		Node cn = this.head;
		Node cnp1 = head.next;
		cn.next = null;
		while(cnp1!=null) {
			Node temp = cnp1.next;
			cnp1.next = cn;
			cn = cnp1;
			cnp1 = temp;
		}
		this.tail = this.head;
		this.head = cn;
	}
	
	public int midNode() {
		Node nx = this.head;
		Node n2x = this.head;
		while(n2x.next != null && n2x.next.next != null) {
			nx = nx.next;
			n2x = n2x.next.next;
		}
		return nx.data;
	}
	
	public void reversePointerRecursively() {
		reversePointerRecursively(null, head);
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}
	
	private void reversePointerRecursively(Node prev, Node curr) {
		if(curr == null)
			return;
		reversePointerRecursively(curr, curr.next);
		curr.next = prev;
	}
	
	private class HeapMover{
		Node left;
	}
	
	public void reverseDataRecursively1() {
		HeapMover mover = new HeapMover();
		mover.left = head;
		reverseDataRecursively1(mover, head, 0);
	}
	
	private void reverseDataRecursively1(HeapMover mover, Node right, int count) {
		if(right == null) {
			return;
		}
		reverseDataRecursively1(mover, right.next, count+1);
		if(count >= this.size/2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}
		mover.left = mover.left.next;
	}
	
	public void reverseDataRecursively2() {
		reverseDataRecursively2(head, head, 0);
	}
	
	private Node reverseDataRecursively2(Node left, Node right, int count) {
		if(right == null) {
			return left;
		}
		Node rn = reverseDataRecursively2(left, right.next, count+1);
		if(count >= this.size/2) {
			int temp = rn.data;
			rn.data = right.data;
			right.data = temp;
		}
		return rn.next;
	}
	
	public void foldLL() {
		foldLL(head, head, 0);
	}
	
	private Node foldLL(Node left, Node right, int count) {
		if(right == null)
			return left;
		Node nn = foldLL(left, right.next, count+1);
		if(count > this.size/2) {
			Node nnp1 = nn.next;
			nn.next = right;
			right.next = nnp1;
			return nnp1;
		}
		if(count == this.size/2) {
			this.tail = right;
			tail.next = null;
			return tail;
		}
		return nn;
		
	}
	
	public boolean isPalindrome() {
		HeapMover mover = new HeapMover();
		mover.left = head;
		return isPalindrome(mover, head, 0);
	}
	
	private boolean isPalindrome(HeapMover mover, Node right, int count) {
		if(right == null)
			return true;
		boolean rv = isPalindrome(mover, right.next, count+1);
		if(count >= this.size/2 && rv) {
			if(mover.left.data != right.data)
				rv = false;
		}
		mover.left = mover.left.next;
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
	
	public int kthNodeFromLast(int k) throws Exception {
		if(k<=0 || k>size)
			throw new Exception("Invalid value");
		Node curr = head;
		Node ahead = head;
		for(int i = 1; i<=k; i++) {
			ahead = ahead.next;
		}
		while(ahead != null) {
			curr = curr.next;
			ahead = ahead.next;
		}
		return curr.data;
	}
	
}
