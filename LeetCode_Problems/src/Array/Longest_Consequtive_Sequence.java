package Array;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consequtive_Sequence {
	public int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        
        for (int num : nums) 
            num_set.add(num);
         

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum ++;
                    currentStreak ++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
