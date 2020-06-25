package LeetCode_June_Challenge.Week_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Queue_Reconstruction_by_Height {

	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		reconstructQueue(people);

	}
	
	public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] a, int[] b) {
        		if(a[0] != b[0])
        			return b[0] - a[0];
        		else
        			return a[1] - b[1];
        	}
		});
        
        ArrayList<int[]> queue = new ArrayList<>();
        for(int[] person: people) {
        	queue.add(person[1], person);
        }
        
        int[][] res = new int[people.length][];
        for (int i = 0; i < res.length; i++) {
			res[i] = queue.get(i);
		}
        return res;
    }

}
