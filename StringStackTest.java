public class StringStackTest{
	public static void main(String[] arvs){
		StringStack stack = new StringStack(20);
		stack.push("paper");
		stack.push("plastic");
		stack.push("tissue");
		System.out.println(stack); //paper, plastic, tissue
		System.out.println(stack.size()); // 3

		String item1 = stack.pop();
		String item2 = stack.pop();
		String item3 = stack.pop();
		System.out.println(item1); 
		System.out.println(item2); 
		System.out.println(item3);
		System.out.println(stack);
		System.out.println(stack.size());   
	}
}