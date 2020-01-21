package Lec7;

import java.util.ArrayList;

public class SumOf2Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 9, 9, 8, 9 };
		int[] arr2 = { 7, 6 };
		ArrayList<Integer> list = sum(arr1,arr2);
		System.out.println(list);

	}
	
	public static ArrayList<Integer> sum(int[] arr1, int[] arr2){
		ArrayList<Integer> list = new ArrayList<>();
		int i = arr1.length-1;
		int j = arr2.length-1;
		int sum = 0;
		while(i>=0 || j>=0) {
			if(i>=0)
				sum+=arr1[i];
			if(j>=0)
				sum+=arr2[j];
			list.add(0, sum%10);
			sum/=10;
			i--;
			j--;
			
		}
		if(sum>0)
			list.add(0,sum);
		
		
		
		return list;
	}

}
