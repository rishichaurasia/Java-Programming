package InterfaceAndGenerics;

public interface StackI {
	public int size = 0;  // Always static & final.
	
	public void push(int item);
	
	public int pop();
	
}

// We cannot instantiate an interface.
// It doesn't have a constructor.
// Methods are abstract. It is have a body.
// Always implemented by a class.
// One interface can extend other intefaces.
// One interface can extend multiple interface.
