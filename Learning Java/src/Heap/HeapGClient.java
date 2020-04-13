package Heap;

import InterfaceAndGenerics.Cars;

public class HeapGClient {

	public static void main(String[] args) {
		Cars[] cars = new Cars[5];
		cars[0] = new Cars(1000, 400, "red");
		cars[1] = new Cars(2000, 200, "yellow");
		cars[2] = new Cars(500, 900, "black");
		cars[3] = new Cars(300, 30, "grey");
		cars[4] = new Cars(700, 60, "white");
		
		HeapGeneric<Cars> hg = new HeapGeneric<>();
		hg.add(cars[0]);
		hg.add(cars[1] );
		hg.add(cars[2]);
		hg.add(cars[3]);
		hg.add(cars[4]);
		System.out.println(hg.remove());
		System.out.println(hg.remove());
		System.out.println(hg.remove());
		System.out.println(hg.remove());
		System.out.println(hg.remove()); 

	}

}
