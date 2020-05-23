package Backtracking;

// https://leetcode.com/problems/letter-tile-possibilities/

public class Letter_Tile_Possibility {

	public static void main(String[] args) {
		String input = "AAB";
		System.out.println(numTilePossibilities(input));

	}
	
	static int count;
	
	public static int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for(int i = 0; i<tiles.length(); i++) {
        	char ch = tiles.charAt(i);
        	freq[ch - 'A']++;
        }
        count = 0;
//		numTilePossibilities(freq , "");
		numTilePossibilities(freq);
        return count;
    }
	
	// More efficient
	private static void numTilePossibilities(int[] freq) {
		
		for(int i = 0; i<freq.length; i++) {
			if(freq[i] > 0) {
				count++;
				freq[i]--;
				numTilePossibilities(freq);
				freq[i]++;
			}
		}
		
	}
	
	// Less efficient bcoz concatination of string consumes lot of time
	private static void numTilePossibilities(int[] freq, String ans) {
		
		for(int i = 0; i<freq.length; i++) {
			if(freq[i] > 0) {
				count++;
				freq[i]--;
				numTilePossibilities(freq, ans + (char)(i+'A'));
				freq[i]++;
			}
		}
		
	}

}
