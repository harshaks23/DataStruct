
public class linkedList {
Node head;
Node tail;
	 linkedList() {
		head =null;
		
	}
	 linkedList(int x) {
		head = new Node(x);
		head.next=null;
		
		
	}
	public void front(int d){
		Node temp = new Node(d);
		temp.next=head;
		head=temp;
		return;
	}
	public void after(int d,int a){
		if (head==null){
			return;
		}
		Node temp= head;
		Node Nodenew= new Node(a);
		
		while (temp!= null){
			
			if(temp.next.data==d){
			
				Nodenew.next=temp.next.next;
				temp.next.next=Nodenew;
				return;
			
			}
			
			temp=temp.next;
		}
		
		
		
	}
	class Node{
		Node next;
		int data;
		Node(int d){
			data=d;
			next=null;
		}
	}
	public void printl(){
		Node temp= head;
		while(temp!=null){
			System.out.println(temp.data);temp=temp.next;
			
		
		}
		
	}
	
	public void append(int a){
		if(head==null){
			head= new Node(a);
			return;
		}
		
		Node temp= new Node(a);
		Node trav= head;
		while(trav.next!= null){
			trav=trav.next;
			
		}
		trav.next=temp;
		return;
	}
	public static void main(String[] args) {
linkedList LL= new linkedList();
LL.append(5);
LL.append(8);
LL.front(6);
LL.printl();
LL.after(8,9);
LL.printl();
	}

}
