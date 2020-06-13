package Array;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Absolute_Difference {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 3};
		System.out.println(minimumAbsDifference1(arr));

	}
	
	public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i<arr.length; i++){
            int currDiff = arr[i] - arr[i-1];
            if(currDiff < minDiff){
                list = new ArrayList<>();
                list.add(Arrays.asList(arr[i-1], arr[i]));
                minDiff = currDiff;
            }else if(currDiff == minDiff){
                list.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return list;
    }
	
	public static List<List<Integer>> minimumAbsDifference1(int[] arr) {
        return new AbstractList<List<Integer>>() {

            int buffer[];
            int size = 0;
            int min;
            boolean init = false;

            @Override
            public List<Integer> get(int index) {
                if (!init) {
                    init();
                }
                return Arrays.asList(buffer[index] - min, buffer[index]);
            }

            @Override
            public int size() {
                if (!init) {
                    init();
                }
                return size;
            }

            private void init() {
                Arrays.sort(arr);
                buffer = new int[arr.length];
                min = Integer.MAX_VALUE;
                size = 0;
                for (int i = 1; i < arr.length; i++) {
                    int abs = arr[i] - arr[i - 1];
                    if (abs == min) {
                        buffer[size++] = arr[i];
                    } else if (abs < min) {
                        size = 0;
                        buffer[size++] = arr[i];
                        min = abs;
                    }
                }
                init = true;
            }
        };
    }

}
