package Trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {

	private class Node{
		char data;
		HashMap<Character, Node> children;;
		boolean isTerminal;
		
		Node(char data, boolean isTerminal){
			this.data = data;
			this.children = new HashMap<>();
			this.isTerminal = isTerminal;
		}
	}
	
	private int numWords;
	private Node root;
	
	public Trie(){
		this.root = new Node('\0', false);
		this.numWords = 0;
	}
	
	public int numWords() {
		return this.numWords;
	}
	
	public void addWord(String word) {
		this.addWord(this.root, word);
	}
	
	private void addWord(Node parent, String word) {
		if(word.length() == 0) {
			if(!parent.isTerminal) {
				parent.isTerminal = true;
				this.numWords++;
			}
			return;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);
		if(child == null) {
			child = new Node(ch, false);
			parent.children.put(ch, child);
		}
		this.addWord(child, ros);
	}
	
	public void remove(String word) {
		this.remove(this.root, word);
	}
	
	private void remove(Node parent, String word) {
		if(word.length() == 0) {
			if(parent.isTerminal) {
				this.numWords--;
				parent.isTerminal = false;
			}
			return;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);
		if(child == null)
			return;
		remove(child, ros);
		if(!child.isTerminal && child.children.size()==0)
			parent.children.remove(child);
	}
	
	public boolean search(String word) {
		return this.search(this.root, word);
	}
	
	private boolean search(Node parent, String word) {
		if(word.length() == 0) {
			if(parent.isTerminal)
				return true;
			return false;
		}
		char ch = word.charAt(0);
		String ros = word.substring(1);
		Node child = parent.children.get(ch);
		if(child == null)
			return false;
		return search(child, ros);
	}
	
	public void display() {
		this.display(this.root, "");
	}
	
	private void display(Node parent, String ans) {
		if(parent.isTerminal)
			System.out.println(ans);
		Set<Map.Entry<Character, Node>> entries = parent.children.entrySet();
		for(Map.Entry<Character, Node> entry: entries) {
			this.display(entry.getValue(), ans+entry.getKey());
		}
	}
	
}
