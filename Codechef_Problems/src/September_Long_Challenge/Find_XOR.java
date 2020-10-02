package September_Long_Challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Find_XOR {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws Exception {
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<t; i++) {
			if(solve() == -1)
				break;
		}
		
	}

	private static int solve() throws Exception {
		
		int N = Integer.parseInt(br.readLine());
		
		int rv = interact(1, 1<<20);
		
		int sum = rv - N*(1<<20);
		
		int result = 0;
		
		if((sum & 1) == 1)
			result += 1;
		
		int mask = 2;
		
		for(int i = 1; i<20; i++) {
			rv = interact(1, mask);
			int diff = (sum - rv)/mask;
			
			int setBitCount = (N + diff)/2;
			if((setBitCount & 1) ==  1)
				result += mask;
			
			mask <<= 1;
			
		}
		
		return interact(2, result);
		
	}

	private static int interact(int type, int n) throws Exception {
		
		System.out.println(type + " " + n);
		return Integer.parseInt(br.readLine());
		
	}	

}
