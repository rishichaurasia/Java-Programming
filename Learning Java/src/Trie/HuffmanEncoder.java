package Trie;

import java.util.HashMap;
import java.util.Map;

import Heap.HeapGeneric;

public class HuffmanEncoder {
	
	private class Node implements Comparable<Node>{
		char data;
		int cost;
		Node left;
		Node right;
		
		Node(char data, int cost){
			this.data = data;
			this.cost = cost;
			this.left = null;
			this.right = null;
		}
		
		Node(Node left, Node right){
			this.data = '\0';
			this.cost = left.cost + right.cost;
			this.left = left;
			this.right = right;
		}
		
		@Override
		public int compareTo(Node other) {
			return other.cost - this.cost;
		}
		
	}
	
	private HashMap<Character, String> encoder;
	private HashMap<String, Character> decoder;
	
	public HuffmanEncoder(String feeder) {
		// Create freq map
		HashMap<Character, Integer> fmap = new HashMap<>();
		for(int i = 0; i<feeder.length(); i++) {
			char ch = feeder.charAt(i);
			if(fmap.containsKey(ch))
				fmap.put(ch, fmap.get(ch) + 1);
			else
				fmap.put(ch, 1);
		}
		
		// Create MinHeap
		HeapGeneric<Node> minHeap = new HeapGeneric<>();
		for(Map.Entry<Character, Integer> entry: fmap.entrySet()) {
			Node node = new Node(entry.getKey(), entry.getValue());
			minHeap.add(node);
		}
		
		// Combine Nodes until one node is left in heap
		while(minHeap.size() != 1) {
			Node n1 = minHeap.remove();
			Node n2 = minHeap.remove();
			Node nn = new Node(n1, n2);
			minHeap.add(nn);
		}
		
		Node ft = minHeap.remove();
		this.encoder = new HashMap<>();
		this.decoder = new HashMap<>();
		
		this.initEncoderDecoder(ft, "");
		
	}
	
	//Filling my encoder and decoder
	private void initEncoderDecoder(Node node, String osf) {   // osf - output so far
		if(node.data != '\0') { 
			this.encoder.put(node.data, osf);
			this.decoder.put(osf, node.data);
			return;
		}
		initEncoderDecoder(node.left, osf + 0);
		initEncoderDecoder(node.right, osf + 1);
	}
	
	public String encode(String source) {
		String rv = "";
		for(int i = 0; i<source.length(); i++) {
			char ch = source.charAt(i);
			String code = this.encoder.get(ch);
			rv += code;
		}
		return rv;
	}
	
	public String decode(String codedString) {
		String rv = "";
		String key = "";
		for(int i = 0; i<codedString.length(); i++) {
			key += codedString.charAt(i);
			if(decoder.containsKey(key)) {
				rv += decoder.get(key);
				key = "";
			}
		}
		return rv;
	}
}
