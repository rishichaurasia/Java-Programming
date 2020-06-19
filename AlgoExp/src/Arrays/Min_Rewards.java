package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Min_Rewards {

	public static void main(String[] args) {
		int[] scores = {8,4,2,1,3,6,7,9,5};
		System.out.println(minRewards(scores));
		System.out.println(minRewards1(scores));
		System.out.println(minRewards2(scores));
	}

	// O(n^2) time | O(n) space
	private static int minRewards(int[] scores) {
		int[] rewards = new int[scores.length];
		Arrays.fill(rewards, 1);
		for(int i = 1; i<scores.length; i++) {
			int j = i-1;
			if(scores[j]<scores[i])
				rewards[i] = rewards[j]+1;
			else {
				while(j>=0 && scores[j] > scores[j+1]) {
					rewards[j] = Math.max(rewards[j], rewards[j+1]+1);
					j--;
				}
			}
		}
		IntStream.of(rewards).forEach(x -> System.out.print(x + " "));
		System.out.println();
		return IntStream.of(rewards).sum();
	}
	
	private static int minRewards1(int[] scores) {
		int[] rewards = new int[scores.length];
		Arrays.fill(rewards, 1); 
		List<Integer> localMinIdxs = getLocalMinIdxs(scores);
		
		for(int localMinIdx: localMinIdxs) {
			expandFromLocalMinIdx(localMinIdx, scores, rewards);
		}
		
		IntStream.of(rewards).forEach(x -> System.out.print(x + " "));
		System.out.println();
		return IntStream.of(rewards).sum();
		
	}

	private static void expandFromLocalMinIdx(int localMinIdx, int[] scores, int[] rewards) {
		int leftIdx = localMinIdx-1;
		while(leftIdx >= 0 && scores[leftIdx] > scores[leftIdx+1]) {
			rewards[leftIdx] = Math.max(rewards[leftIdx], rewards[leftIdx+1] + 1);
			leftIdx--;
		}
		int rightIdx = localMinIdx+1;
		while(rightIdx < scores.length && scores[rightIdx-1] < scores[rightIdx]) {
			rewards[rightIdx] = rewards[rightIdx-1] + 1;
			rightIdx++;
		}
	}

	private static List<Integer> getLocalMinIdxs(int[] scores) {
		List<Integer> list = new ArrayList<>();
		if(scores.length == 1) {
			list.add(scores[0]);
			return list;
		}
		
		for(int i = 0; i<scores.length; i++) {
			if(i == 0 && scores[i]<scores[i+1])	list.add(i);
			if(i == scores.length-1 && scores[i-1] > scores[i]) list.add(i);
			if(i == 0 || i == scores.length-1) continue;
			if(scores[i-1]>scores[i] && scores[i]<scores[i+1]) list.add(i);
		}
		return list;
	}
	
	public static int minRewards2(int[] scores) {
		int[] rewards = new int[scores.length];
		Arrays.fill(rewards, 1);
		
		for(int i = 1; i<scores.length; i++) {
			if(scores[i] > scores[i-1])	rewards[i] = rewards[i-1]+1;
		}
		
		for(int i = scores.length-2; i>=0; i--) {
			if(scores[i] > scores[i+1]) rewards[i] = Math.max(rewards[i], rewards[i+1]+1);
		}
		
		IntStream.of(rewards).forEach(x -> System.out.print(x + " "));
		System.out.println();
		return IntStream.of(rewards).sum();
	}

}
