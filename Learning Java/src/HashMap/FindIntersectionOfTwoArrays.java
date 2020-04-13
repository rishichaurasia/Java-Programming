package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindIntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 5, 1, 3, 4, 7};
		int[] arr2 = {2, 4, 3, 5, 7, 10, 15};
		ArrayList<Integer> list = getIntersection(arr1, arr2);
		System.out.println(list);
	}
	
	public static ArrayList<Integer> getIntersection(int[] arr1, int[] arr2) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int val: arr1)
			map.put(val, false);
		for(int val: arr2) {
			if(map.containsKey(val))
				map.put(val, true);
		}
		ArrayList<Integer> list = new ArrayList<>();
//		Set<Map.Entry<Integer, Boolean>> entries = map.entrySet();
//		for(Map.Entry<Integer, Boolean> entry: entries) {
//			if(entry.getValue())
//				list.add(entry.getKey());
//		}
		for(Map.Entry<Integer, Boolean> entry: map.entrySet()) {
			if(entry.getValue())
				list.add(entry.getKey());
		}
		return list;
	}

}
