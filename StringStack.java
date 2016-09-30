import java.util.*;

public class StringStack{
	public String[] elements;
	private int count;
	public final int DEFAULT_SIZE = 10;
	
	
	public StringStack(int size){
		if (size <= 0){
			throw new IllegalArgumentException("Invalid size");
		}
		elements = new String[size];
	}

	public StringStack(){
		elements = new String[DEFAULT_SIZE];
	}

	
	public void push(String item){
		if (elements.length == count){
			elements = Arrays.copyOf(elements, count + 10);
		}
		elements[count] = item;
		count++;

	}

	public String pop(){
		if (count == 0){
			throw new IllegalArgumentException("No elements");
		}
		count--;
		return elements[count];
	}

	public String pop(int n){
		if (n >  count){
			throw new IllegalArgumentException("n cannot exceeds the number of elements");
		}
		return elements[count - n];
	}

	public String peek(){
		if (count == 0){
			throw new IllegalArgumentException("There is no element in the stack");
		}
		return elements[elements.length - 1];
	}

	public int size(){
		return count;
	}

	
	public String toString(){
		if (count == 0){
			return "Empty!";
		}
		String res = "";
		for (int i = 0; i < count - 1; i++){
			res += elements[i] + ", ";
		}
		res += elements[count - 1];
		return res;
	}


}