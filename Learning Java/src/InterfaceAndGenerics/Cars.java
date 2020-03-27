package InterfaceAndGenerics;

public class Cars { //implements Comparable<Cars> {
	int speed;
	int price;
	String color;
	
	public Cars(int speed, int price, String color){
		this.speed = speed;
		 this.price = price;
		 this.color = color;
	}
	
	@Override
	public String toString() {
		return "S:" + this.speed + " P:" + this.price + " C:" + this.color; 
	}

//	@Override
//	public int compareTo(Cars other) {
//		return this.speed - other.speed;
////		return this.compareTo(other);
//	}


	
	
	
}
