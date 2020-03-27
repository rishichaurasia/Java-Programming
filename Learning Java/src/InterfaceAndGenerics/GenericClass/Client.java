package InterfaceAndGenerics.GenericClass;

import InterfaceAndGenerics.Cars;

public class Client {

	public static void main(String[] args) {
		
		Pair<String> pair = new Pair<>();
		pair.one = "abc";
		pair.two = "def";
		
		Pair<Integer> pair1 = new Pair<>();
		pair1.one = 10;
		pair1.two = 20;
		
		Pairtwo<Integer, String> pair2 = new Pairtwo<>();
		pair2.one = 30;
		pair2.two = "xyz";
		
		LinkedListGeneric<Cars> list = new LinkedListGeneric<>();
		Cars[] cars = new Cars[5];
		cars[0] = new Cars(1000, 400, "red");
		cars[1] = new Cars(2000, 200, "yellow");
		cars[2] = new Cars(500, 900, "black");
		cars[3] = new Cars(300, 30, "grey");
		cars[4] = new Cars(700, 60, "white");
		
		list.addLast(cars[0]);
		list.addLast(cars[1]);
		list.addLast(cars[2]);
		list.addLast(cars[3]);
		list.addLast(cars[4]);
		
		list.display();

	}

}
