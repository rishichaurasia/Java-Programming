package Linked_List;

public class Linked_List_Construction {

	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.setHead(1);
		dll.setTail(2);
		dll.setTail(3);
		dll.setTail(4);
		dll.setTail(5);
		dll.insertBefore(4, 6);
		dll.insertAfter(3, 5);
		dll.insertAtPosition(4, 7);
		dll.remove(7);
		dll.removeAll(5);
//		System.out.println(dll.containsNodeWithValue(6));
		dll.display();
	}
	
	static class DoublyLinkedList{
		
		public static class Node{
			int data;
			Node prev;
			Node next;
			
			Node(int data) {
				this.data = data;
			}
		}
		
		private Node head;
		private Node tail;
		
		public void setHead(int data) {
			Node node = new Node(data);
			if(head == null) {
				head = node;
				tail = node;
				return;
			}
			node.next = head;
			head.prev = node;
			head = node;
		}
		
		public void setTail(int data) {
			Node node = new Node(data);
			if(tail == null) {
				head = node;
				tail = node;
				return;
			}
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		
		public void insertBefore(int item, int itemToInsert) {
			Node temp = head;
			while(temp != null && temp.data != item)
				temp = temp.next;
			if(temp == null)
				return;
			if(temp == head) {
				setHead(itemToInsert);
				return;
			}
			Node node = new Node(itemToInsert);
			node.prev = temp.prev;
			node.next = temp;
			temp.prev = node;
			node.prev.next = node;
		}
		
		public void insertAfter(int item, int itemToInsert) {
			Node temp = head;
			while(temp != null && temp.data != item)
				temp = temp.next;
			if(temp == null)
				return;
			if(temp == tail) {
				setTail(itemToInsert);
				return;
			}
			Node node = new Node(itemToInsert);
			node.next = temp.next;
			node.prev = temp;
			temp.next = node;
			node.next.prev = node;
		}
		
		public void insertAtPosition(int position, int item) {
			if(position == 1) {
				setHead(item);
				return;
			}
			Node temp = head;
			for(int i = 1; i<position; i++)
				temp = temp.next;
			if(temp == null)
				setTail(item);
			else {
				Node node = new Node(item);
				node.prev = temp.prev;
				node.next = temp;
				node.prev.next = node;
				temp.prev = node;
			}
		}
		
		public void removeAll(int item) {
			Node temp = head;
			while(temp != null) {
				if(temp.data == item)
					remove(temp);
				temp = temp.next;
			}
		}
		
		public void remove(Node node) {
			if(node == null)
				return;
			if(node == head && node == tail) {
				head = null;
				tail = null;
				return;
			}
			if(node == head) {
				head = node.next;
				head.prev = null;
			}else if(node == tail) {
				tail = tail.prev;
				tail.next = null;
			}else {
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}
		}
		
		public void remove(int data) {
			Node temp = head;
			while(temp != null && temp.data != data)
				temp = temp.next;
			remove(temp);
			
		}
		
		public boolean containsNodeWithValue(int value) {
			Node temp = head;
			while(temp != null) {
				if(temp.data == value)
					return true;
				temp = temp.next;
			}
			return false;
		}
		
		public void display() {
			if(head == null) {
				System.out.println(head);
				return;
			}
			System.out.print("null <-> ");
			Node node = head;
			while(node != null) {
				System.out.print(node.data + " <-> ");
				node = node.next;
			}
			System.out.println("null");
		}
	}

}
