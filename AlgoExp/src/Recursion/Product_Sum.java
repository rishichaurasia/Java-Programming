package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product_Sum {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add(5);
		list.add(2);
		list.add(Arrays.asList(7,-1));
		list.add(3);
		list.add(Arrays.asList(6, Arrays.asList(-13,8), 4));
		System.out.println(list);
		System.out.println(productSum(list, 1));

	}
	
	public static int productSum(List<Object> list, int multiplier) {
		int sum=0;
		for(Object obj: list) {
			if(obj instanceof List) {
				sum+=productSum( (List<Object>)obj, multiplier+1);
			}else
				sum+=(int)obj;
		}
		return sum * multiplier;
	}

}
