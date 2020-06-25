package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRU_Cache {
	
	private class Node{
        int key;
        int value;
        Node next;
        Node prev;
        
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRU_Cache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null)
            return -1;
        removeNode(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node != null){
            removeNode(node);
            node.value = value;
            add(node);
        }else{
            if(map.size() == capacity){
                map.remove(tail.key);
                removeNode(tail);
            }
            node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
    }
    
    private void add(Node node){
        if(head == null){
            head = node;
            tail = node;
        }
        node.next = head;
        head.prev = node;
        head = node;
    }
    
    private void removeNode(Node node){
        if(node == head && node == tail){
            head = null;
            tail = null;
        }else if(node == head){
            head = node.next;
        }else if(node == tail){
            tail = node.prev;
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
	
}
