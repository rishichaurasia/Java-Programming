package July_Long_Challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

public class Missing_a_Point {

	static Scanner scn = new Scanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{
		int t = scn.nextInt();
		while(t-- > 0){
//		    HashMap<Integer,Integer> xcor = new HashMap<>();
//		    HashMap<Integer,Integer> ycor = new HashMap<>();
//		    int n = scn.nextInt();
//		    for(int i = 1; i<=4*n-1; ++i){
//		        int x = scn.nextInt();
//		        int y = scn.nextInt();
//		        xcor.put(x,xcor.getOrDefault(x, 0)+1);
//		        ycor.put(y,ycor.getOrDefault(y, 0)+1);
//		    }
//		    int missingX = 0;
//		    for(Entry<Integer,Integer> set : xcor.entrySet()) {
//		    	if((set.getValue() & 1) == 1) {
//		    		missingX = set.getKey();
//		    	}
//		    }
//		    int missingY = 0;
//		    for(Entry<Integer,Integer> set : ycor.entrySet()) {
//		    	if((set.getValue() & 1) == 1) {
//		    		missingY = set.getKey();
//		    	}
//		    }
//		    System.out.println(missingX + " " + missingY);
			HashSet<Integer> xcor = new HashSet<>();
			HashSet<Integer> ycor = new HashSet<>();
			int n = scn.nextInt();
			for(int i = 1; i<4*n; ++i) {
				int x = scn.nextInt();
				int y = scn.nextInt();
				if(xcor.contains(x))
					xcor.remove(x);
				else xcor.add(x);
				if(ycor.contains(x))
					ycor.remove(x);
				else ycor.add(x);
			}
			int mx = 0, my = 0;
			for(int x: xcor)
				mx = x;
			for(int y: ycor)
				my = y;
			System.out.println(mx + " " + my);
		}
	}
	
}
