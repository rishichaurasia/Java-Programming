package Lec18;

import Lec17.Stack;

public class NextGreaterElement {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int[] arr = { 50, 20, 10, 40, 30, 60, 15, 12 };
		int[] res = getNextGreaterInOrder(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "," + res[i]);
		}
	}

	public static void printNextGreater(int[] arr) throws Exception {

		Stack s = new Stack(arr.length);
		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() && s.peek() < arr[i]) {
				System.out.println(s.pop() + "," + arr[i]);
			}
			s.push(arr[i]);
		}
		while (!s.isEmpty()) {
			System.out.println(s.pop() + "," + -1);
		}

	}
	
	public static int[] getNextGreaterInOrder(int[] arr) throws Exception {
		Stack s = new Stack(arr.length);
		int[] arr1 = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
				arr1[s.pop()] = arr[i];
			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			arr1[s.pop()] = -1;
		}
		return arr1;
	}

}
