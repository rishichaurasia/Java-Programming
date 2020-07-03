package LeetCode_June_Challenge.Week_5;

import java.util.ArrayList;
import java.util.List;

public class Word_search_II {
	static class Trie {
        Trie[] next = new Trie[26];
        String word;
    }
	
    public static List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        Trie root = new Trie();
        for (String word: words) {
            Trie node = root;
            for (char ch: word.toCharArray()) {
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new Trie();
                }
                node = node.next[ch - 'a'];
            }
            node.word = word;
        }

        // Depth First Search
        List<String> results = new ArrayList<>();

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                dfs(board, root, x, y, results);
            }
        }
        return results;
    }

    public static void dfs(char[][] board, Trie node, int x, int y, List<String> results) {
        if (x < 0 || y < 0 || y >= board.length || x >= board[y].length) {
            return;
        }

        char ch = board[y][x];
        if (ch == ' ') {
            return;
        }
        node = node.next[ch - 'a'];
        if (node == null) {
            return;
        }
        if (node.word != null) {
            results.add(node.word);
            node.word = null; // prevent dupes
        }
        board[y][x] = ' '; // visited
            dfs(board, node, x + 1, y, results);
            dfs(board, node, x - 1, y, results);
            dfs(board, node, x, y + 1, results);
            dfs(board, node, x, y - 1, results);
        board[y][x] = ch; //restore for next iterations
    }
}
