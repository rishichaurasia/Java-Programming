package Leetcode_August_Challenge;

public class Add_and_Search_Word_Data_Structure_Design {

	public static void main(String[] args) {
		
		WordDictionary wd = new WordDictionary();
		wd.addWord("bad");
		wd.addWord("dad");
		wd.addWord("mad");
		System.out.println(wd.search("pad"));
		System.out.println(wd.search("bad"));
		System.out.println(wd.search(".ad"));
		System.out.println(wd.search("b.."));
	}
	
	static class WordDictionary {

	    private class Node{
	        Node[] charArray = new Node[26];
	        boolean isTerminal = false;
	    }
	    
	    Node root;
	    
	    /** Initialize your data structure here. */
	    public WordDictionary() {
	        this.root = new Node();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        Node node = this.root;
	        for(int i = 0; i<word.length(); i++){
	            char ch = word.charAt(i);
	            int idx = ch - 'a';
	            if(node.charArray[idx] == null)
	                node.charArray[idx] = new Node();
	            node = node.charArray[idx];
	        }
	        node.isTerminal = true;
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return search(word, 0, this.root);
	    }
	    
	    public boolean search(String word, int idx, Node node){
	        
	        if(node == null)
	            return false;
	        
	        if(idx == word.length())
	            return node.isTerminal;
	        
	        
	        char ch = word.charAt(idx);
	        if(ch != '.')
	            return search(word, idx+1, node.charArray[ch - 'a']);
	        else{
	            for(int i = 0; i<26; i++){
	                if(search(word, idx+1, node.charArray[i]))
	                    return true;
	            }
	            return false;
	        }
	        
	    }
	}

	/**
	 * Your WordDictionary object will be instantiated and called as such:
	 * WordDictionary obj = new WordDictionary();
	 * obj.addWord(word);
	 * boolean param_2 = obj.search(word);
	 */

}
