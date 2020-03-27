package InterfaceAndGenerics;

import java.util.Comparator;

public class CarsClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cars[] cars = new Cars[5];
		cars[0] = new Cars(1000, 400, "red");
		cars[1] = new Cars(2000, 200, "yellow");
		cars[2] = new Cars(500, 900, "black");
		cars[3] = new Cars(300, 30, "grey");
		cars[4] = new Cars(700, 60, "white");
//		bubbleSort(cars);
		bubbleSort(cars, new CarSpeedComparator());
		display(cars);
		System.out.println();
		bubbleSort(cars, new CarPriceComparator());
		display(cars);
	}
	
	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int i = 0; i < arr.length - counter - 1; i++) {
				if (comparator.compare(arr[i], arr[i+1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int i = 0; i < arr.length - counter - 1; i++) {
				if (arr[i].compareTo(arr[i+1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

	
	public static void display(Cars[] cars) {
		for (int i = 0; i < cars.length; i++) {
			System.out.println(cars[i]);
		}
	}

}
