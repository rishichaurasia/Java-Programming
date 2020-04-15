package Trie;

import java.util.BitSet;

public class HuffmanEncoderClient {

	public static void main(String[] args) {
		
		String str = "abbccda";
		HuffmanEncoder hf = new HuffmanEncoder(str);
		String coded = hf.encode(str);
		System.out.println(coded);
		String decoded =  hf.decode(coded);
		System.out.println(decoded);
		
		BitSet bitset = new BitSet(coded.length());
		int bitCounter = 0;
		for(Character ch: coded.toCharArray()) {
			if(ch.equals('1'))
				bitset.set(bitCounter);
			bitCounter++;
		}
		
		byte[] arr = bitset.toByteArray();
		for(byte bt: arr)
			System.out.print(bt + " ");
		System.out.println(arr.length);
	}

}
