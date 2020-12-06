package Searching_and_Sorting;

import java.io.*;
import java.util.*;

public class Room_Allocation {

	public static void main(String[] args) {
		
		FastReader s = new FastReader();
		int n = s.nextInt();
		int[] result = new int[n];
		int[][] arr = new int[n][3];
		for (int i = 0; i < n; i++) {
			arr[i][0] = s.nextInt();
			arr[i][1] = s.nextInt();
			arr[i][2] = i;
		}
		Arrays.sort(arr, (x, y) -> Integer.compare(x[0], y[0]));

		Queue<int[]> pq = new PriorityQueue<>(n, (x, y) -> Integer.compare(x[0], y[0]));
		int[] room;
		for (int[] cus : arr) {
			if (!pq.isEmpty() && cus[0] > pq.peek()[0]) {
				room = pq.remove();
				room[0] = cus[1];
			} else {
				room = new int[2];
				room[0] = cus[1];
				room[1] = pq.size() + 1;
			}
			pq.add(room);
			result[cus[2]] = room[1];
		}
		System.out.println(pq.size());
		StringBuilder sb = new StringBuilder();
		for (int num : result) {
			sb.append(num).append(' ');
		}
		System.out.println(sb);
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
