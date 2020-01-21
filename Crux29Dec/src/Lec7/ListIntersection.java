package Lec7;

import java.util.ArrayList;

public class ListIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = { 10, 20, 20, 30, 35, 40, 40, 50 };
		int[] arr2 = { 5, 7, 9, 10, 10, 10, 20, 25, 37, 40, 40, 40 };
		ArrayList<Integer> list = intersection(arr1,arr2);
		System.out.println(list);

	}
	
	public static ArrayList<Integer> intersection(int[] arr1, int[] arr2){
		ArrayList<Integer> list = new ArrayList<>();
		int left1 = 0, right1 = arr1.length;
		int left2 = 0, right2 = arr2.length;
		while(left1<right1 && left2<right2) {
			if(arr1[left1]<arr2[left2])
				left1++;
			else if(arr1[left1]==arr2[left2]) {
				list.add(arr1[left1]);
				left1++;
				left2++;
			}
			else
				left2++;
		}
		
		return list;
	}

}
