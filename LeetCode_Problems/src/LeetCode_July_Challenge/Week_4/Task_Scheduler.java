package LeetCode_July_Challenge.Week_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Task_Scheduler {

	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };

	}
	
	public static int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> counts = new HashMap();
        for(char t: tasks) 
            counts.put(t, counts.getOrDefault(t, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue(counts.size(), Collections.reverseOrder());
        pq.addAll(counts.values());
        
        int result = 0;
        while(!pq.isEmpty()){
            int time = 0;
            List<Integer> tmp = new ArrayList();
            for(int i = 0; i < n+1; ++i){
                if(!pq.isEmpty()){
                    tmp.add(pq.remove() - 1);
                    time++;
                }
            }
            for(int t: tmp)
                if(t > 0) pq.add(t);
            result += pq.isEmpty() ? time : n+1;
        }
        return result;
    }

	public static int leastInterval(char[] tasks, int n) {
		int[] freq = new int[26];
		for (char ch : tasks)
			freq[ch - 'A']++;

		Arrays.sort(freq);
		int mostFreq = freq[25] - 1;
		int idleTime = mostFreq * n;

		for (int i = 24; i >= 0; i--) {
			idleTime -= Math.min(freq[i], mostFreq);
			if (idleTime < 0)
				return tasks.length;
		}

		return idleTime + tasks.length;
	}

	public static int leastInterval1(char[] tasks, int n) {

		int[] freq = new int[26];
		for (int i = 0; i < tasks.length; i++) {
			freq[tasks[i] - 'A']++;
		}
		// find max frequency
		int maxF = 0;
		for (int i = 0; i < 26; i++) {
			maxF = Math.max(maxF, freq[i]);
		}
		// find number of tasks with max frequency
		int nMax = 0;
		for (int i = 0; i < 26; i++) {
			if (freq[i] == maxF)
				nMax++;
		}
		return (Math.max(tasks.length, (maxF - 1) * (n + 1) + nMax));

	}

}
