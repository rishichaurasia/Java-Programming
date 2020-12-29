package Additional_Problems;

import java.io.*;
import java.util.*;

public class Shortest_Subsequence {

public static void main(String[] args) {
		
		FastReader s = new FastReader();
		String str = s.next();
		HashSet<Character> set = new HashSet<>();
		StringBuilder res = new StringBuilder();
		for(int i = 0; i<str.length(); i++) {
			set.add(str.charAt(i));
			if(set.size() == 4) {
				res.append(str.charAt(i));
				set.clear();
			}
		}
		if(!set.contains('A'))
			res.append('A');
		else if(!set.contains('C'))
			res.append('C');
		else if(!set.contains('G'))
			res.append('G');
		else if(!set.contains('T'))
			res.append('T');
		
		System.out.println(res);
	}
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }

}
