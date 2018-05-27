

public class QueueMain {

	public static void main(String[] args) {
		CS401QueueArrayFixedImpl<String> one = new CS401QueueArrayFixedImpl<String>(10);
		System.out.println("Implementaion of queue using fixed stack front");
		one.add("a");
		one.add("b");
		one.add("c");
		one.add("d");
		one.add("e");
		one.add("f");
		one.add("g");
		one.add("h");
		one.add("i");
		one.add("j");
		
		one.add("k");
		
		one.remove();
		
		String a=one.peek();
		System.out.println(a);
	
		System.out.println("Implementaion of queue using floating front array  ");
		
		
CS401QueueArrayFloatingImpl<String> two= new CS401QueueArrayFloatingImpl<String>(10);
		
		two.add("a");
		two.add("b");
		two.add("c");
		two.add("d");
		two.add("e");
		two.add("f");
		two.add("g");
		two.add("h");
		two.add("i");
		two.add("j");
		two.add("k");
		two.remove();
		
		System.out.println(two.peek());
		System.out.println("Implementaion of queue using linked lsit");
		
		
CS401QueueLinkedListImpl<String> three= new CS401QueueLinkedListImpl<String>();
		
		three.add("a");
		three.add("b");
		three.add("c");
		three.add("d");
		three.add("e");
		three.add("f");
		three.add("g");
		three.add("h");
		three.add("i");
		three.add("j");
		three.add("k");
		three.remove();
		
		System.out.println(three.peek());
		
		
		
		

	}


}
