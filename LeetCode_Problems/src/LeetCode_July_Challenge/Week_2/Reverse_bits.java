package LeetCode_July_Challenge.Week_2;

public class Reverse_bits {

	public static void main(String[] args) {
		int n = -3;
		System.out.println(reverseBits1(n));
	}

	public static int reverseBits(int n) {
		int rv = 0;
		for (int i = 0; i < 32; ++i) {
			rv = (rv<<1) | (n & 1);
			n >>= 1;
		}
		return rv;
	}
	
	public static int reverseBits1(int n) {
		 
		n = n>>>16 | n<<16;
		
//		n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
		
		n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
		
		n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
		
		n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
		
		n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
		
		return n;
		
	}

}
