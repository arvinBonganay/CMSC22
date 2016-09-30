import java.util.*;

public class StringQueue{
	private String[] elements;
	private int count;

	public StringQueue(){
		elements = new String[10];
	}

	public void enqueue(String name){
		if (count == elements.length){
			elements = Arrays.copyOf(elements, count + 10);
		}
		elements[count++] = name;
	}

	public String dequeue(){
		if (count == 0){
			throw new IllegalArgumentException("No elements present");
		}
		String res = elements[0];
		for (int i = 0; i < count - 1; i++){
			elements[i] = elements[i + 1];
		}
		count--;
		return res;
	}

	public String dequeue(int n){
		String res = elements[0];
		for (int i = 0; i < n; i++){
			res = dequeue();
		}
		return res;
	}

	public String peek(){
		return elements[0];
	}

	public int size(){
		return count;
	}

	public void singit(int i, String name){
		if (count == elements.length){
			elements = Arrays.copyOf(elements, count + 10);
		}
		if(i > count){
			elements[count] = name;
			count++;
		} else {
			for(int j = count; j >= i; j--){
				elements[j] = elements[j - 1];
			}
			elements[i - 1] = name;
			count++;
		}
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