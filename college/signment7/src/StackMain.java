

public class StackMain {

	
	public static void main(String[] args) {
		CS401StackArrayImpl<String> one = new CS401StackArrayImpl<String>(10);
		System.out.println("implementaion of stack using array");
		one.push("a");
		one.push("b");
		one.push("c");
		one.push("d");
		one.push("e");
		one.push("f");
		one.push("g");
		one.push("h");
		one.push("i");
		one.push("j");
		System.out.println(one.size());
		one.push("k");
		System.out.println(one.size());
		one.pop();
		one.pop();
		String a=one.peek();
		System.out.println(a);
		System.out.println(one.size()+"\n\n");
		
		System.out.println("Implementaion of stack using linked list\n");
		CS401StackLinkedListImpl<String> two= new CS401StackLinkedListImpl<String>();
		
		two.push("a");
		two.push("b");
		two.push("c");
		two.push("d");
		two.push("e");
		two.push("f");
		two.push("g");
		two.push("h");
		two.push("i");
		two.push("j");
		System.out.println(two.size());
		two.push("k");
		System.out.println(two.size());
		two.pop();
		two.pop();
		System.out.println(two.peek());
		System.out.println(two.size());
		
		
		

	}

}
