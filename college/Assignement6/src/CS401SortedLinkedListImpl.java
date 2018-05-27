public class CS401SortedLinkedListImpl<E> extends CS401LinkedListImpl<E>
{
   public CS401SortedLinkedListImpl()
   {
      super();
   }

   /** 
    * Adds element e in sorted order in the collection class (linked 
    * list).
    * Returns true if e was added successfully, false otherwise.
    */
   public boolean add(E e)
   {
	   LinkEntry<E> ne = new LinkEntry<E>();
	   
	      ne.element = e;

	      if (head == null && tail == null)
	      {
	          head = tail = ne;
	      }
	      
	      else 
	      {
	    	  LinkEntry<E> prev=null;
	    	  LinkEntry<E> temp;
	    	  for(temp=head;temp!=null;temp=temp.next)
	    	  {

	    		  int comp=((Comparable)e).compareTo(temp.element);
	    		  if(comp<0)
	    		  {
	    			  break;
	    		  }
	    		  prev=temp;
	    	  }
	    	  if(prev==null)
	    	  {
	    		  ne.next=head;
	    		  head=ne;
	    	  }
	    	  else if(temp==null)
	    	  {
	    		  tail.next=ne;
	    		  tail=ne;
	    	  }
	    	  else
	    	  {
	    		  ne.next=prev.next;
	    		  prev.next=ne;
	    	  }
	    	  
	    	  
	      }

  num_elements++;
      return true;
   }

   /**
    * Print the sorted linked list in reverse order using recursion.
    */
   public void reverse_print()  {
	   
	   
	   if(head==null)
	   {
		   System.out.println("null");
	   }
	   else
	   {
		   LinkEntry<E> rec=head;
		   recursion(rec);
	   }
      /**
       * Add code here 
       */
   }
  // public int size() { return num_elements; }

   public void recursion( LinkEntry<E> rec){

	   String output="";
	   if(rec==null)
		   return;
	   
	   recursion(rec.next);
	   output+=rec.element;
	  
	   System.out.print(output);
   }

} /* CS401SortedLinkedListImpl<E> */
