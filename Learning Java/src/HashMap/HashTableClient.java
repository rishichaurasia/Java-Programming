package HashMap;

public class HashTableClient {

	public static void main(String[] args) throws Exception {
		HashTable<String, Integer> map = new HashTable<>(3);
		map.put("USA", 200);
		map.put("UK", 175);
		map.put("India", 300);
		map.put("China", 350);
		
//		map.display();
		
		map.put("Sweden", 100);
		map.put("RAS", 125);
//		map.display();
//		map.put("India", 325);
		map.display();
		map.put("Canada", 225);
		map.display();
//		
//		System.out.println(map.get("India"));
//		System.out.println(map.get("RSA"));
//		System.out.println(map.get("ADFFDA"));
//		
//		System.out.println(map.remove("ADFFDA"));
//		System.out.println(map.remove("USA"));
//		
//		map.display();
		
		
	}

}
