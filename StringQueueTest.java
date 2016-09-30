public class StringQueueTest{
	public static void main(String[] arvs){
		StringQueue queue = new StringQueue();
		queue.enqueue("Leah");
		queue.enqueue("Queen");
		queue.enqueue("Arvs");
		queue.enqueue("Uy");
		queue.enqueue("ArvsGay");
		System.out.println(queue);
		System.out.println(queue.size());
		queue.dequeue(4);
		queue.dequeue();
		System.out.println(queue.size());
		System.out.println(queue);
		queue.singit(123, "jhessa");
		System.out.println(queue);
		System.out.println(queue.size());

	}	
}