package HashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InbuiltHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> map = new HashMap<>();
		map.put("USA", 200);
		map.put("UK", 175);
		map.put("India", 300);
		map.put("China", 350);
		
		System.out.println(map);
		
		map.put("Sweden", 100);
		
		System.out.println(map);
		map.put("India", 325);
		System.out.println(map);
		System.out.println(map.get("India"));
		System.out.println(map.get("RSA"));
		System.out.println(map.remove("USA"));
//		System.out.println(map);
//		System.out.println(map.containsKey("India"));
//		Set<String> keys = map.keySet();
//		for(String key: keys)
//			System.out.print(key + " ");
//		System.out.println();
//		
//		Collection<Integer> values = map.values();
//		for(int val: values)
//			System.out.print(val + " ");
//		System.out.println();
//		
//		Set<Map.Entry<String, Integer>>  entryset = map.entrySet();
//		for(Map.Entry<String, Integer> entry: entryset)
//			System.out.println(entry.getKey() + "->" + entry.getValue());
	}

}
