import java.util.Iterator;

public class CS401DblLinkedListImpl<E> extends CS401LinkedListImpl<E> 
{
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements = 0;

   public CS401DblLinkedListImpl()
   {
      head = tail = null;
      
      
   }

   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { return false; }

   public int size() { return num_elements; }

   /*
    * Add e to the end of the doubly linked list.
    * Returns true - if e was successfully added, false otherwise.
    */
   public boolean add(E e)
   {
	   add(Where.BACK, e);          
      return true;
   }

   /**
    * Remove element indicated by i.
    * If the element exists in the collection, return that element back 
    * to the user.  If index is out of bounds, return null.
    */
   public E remove(int i)
   {
	   CS401DbLinkedListIterator  ab= new CS401DbLinkedListIterator("front");
	   E e = null;
	  
	   int a=1;
	   
	      if(i<0 | i>num_elements)
	      {	 
	      return null;
	      }
	      
	      
	      else
	    	  
	    	  
	     if(i==1)
	     {
	    	
	    	 e=head.element;
	    	 ab.current=ab.current.next;
	    	 ab.current.previous=null;
	    	 head=ab.current;
	     }
	      
	      
	     else
	      
	      if(i==num_elements)
	      
	      {
	    	  tail.previous.next=null;
	    	 e=tail.element;
	    	 
	    	tail=tail.previous;
	      }
	     else
	     { 
	    	 
	   	      while(a<i)
	   	      {
	   	    	ab.next();
	   	    	e=ab.current.element;
	   	    	a++;
	   	      }
	   	      
	   	      ab.previous.next=ab.current.next;
	   	     ab.current.next.previous=ab.previous;
	   	     ab.current.next=null;
	   	     ab.current.previous=null;
		     
	   	   
	              }
	      num_elements--;
	      return e;
	     }
	   
   

   /**
    * Determines if e is in the collection.
    * Hint: Remember lecture on comparison.
    * Returns true if e is in the collection, false otherwise. */
   public boolean contains(E e)
   {
	   CS401DbLinkedListIterator ab= new CS401DbLinkedListIterator("front");
	     boolean a=false;
	     int i=1;
	     while(i<num_elements)
	    	 
	     {
	    	 
	    	 {
	    		 if(ab.next()==e)
	    		 a=true;
	    		
	    		 
	    		 
	    	 }
	    	
	    	 i++;
	     }
	      return a;
   }

   /**
    * Add e to either front of the linked list or the end of the linked
    * list, depending on the value of the parameter where.
    * If where == MIDDLE, return false.
    * Returns true if element added to back or front, or false if asked
    * to add in the middle. */
   public boolean add(Where where, E e)  {

	   if (where == Where.MIDDLE) 
	          return false;

	      LinkEntry<E> ne = new LinkEntry<E>();
	      ne.element = e;

	      if (head == null && tail == null)
	      {
	          head = tail = ne;
	          num_elements++;
	          return true;
	      }
	 
	      if (where == Where.BACK)
	      {
	    	  ne.previous=tail;
	         tail.next = ne;
	         tail = ne;
	      }
	      
	      
	      else if
	      (where == Where.FRONT)  
	      {head.previous=ne;
	    	  ne.next=head;
	          head=ne;
	      }
	      
	      
	      num_elements++;
	      return true;
      /**
       * Add code here.
       * Hint: follow the same logic as 
       * CS401LinkedListImpl::add(Where where, E e) except account for 
       * the previous and next references in the doubly linked list. */

   } 

   /**
    * Add e to the middle of a linked list.  More specifically, add e
    * after index in the linked list.  
    * First element of the linked list is 1, second is 2, and so on.
    *
    * Returns true if element added, false if where != MIDDLE. */
   public boolean add(Where where, int index, E e)  {
CS401DbLinkedListIterator ab=new CS401DbLinkedListIterator("front");

	  
	   int count=1;
	   while(count<index)
	   {
		 ab.next();  
		count++;   
	   }
	   
	  LinkEntry<E> a=new LinkEntry<E>();
	  
	  a.element=e;
	  
	  a.previous=ab.current;
	  
	  a.next=ab.current.next;
	  
      ab.current.next.previous=a;
	 ab.current.next=a;
	 
	 
	 num_elements++;
	     return true;
      
   }

   /**
    * Print the doubly linked list starting at the beginning.
    */
   public void print_from_beginning()
   {
      CS401DbLinkedListIterator ab=new CS401DbLinkedListIterator("front");
      while(ab.hasNext())
      
      {System.out.print(ab.current.element);
    	  
    	  ab.next();
    	 
      }
   }

   /**
    * Print the doubly linked list starting the end.
    */
   public void print_from_end()
   {
	   CS401DbLinkedListIterator ab=new CS401DbLinkedListIterator("back");
	while(ab.hasPrevious())
		{
		
		System.out.print(ab.previous());
		}return;
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
      protected LinkEntry<E> previous;

      protected LinkEntry() { element = null; next = previous = null; }
   }
   public Iterator<E> iterator() 
   /* From Interface Iterable */
   {
	 
   return new CS401LinkedListIterator();
   
   
   }
   protected class CS401DbLinkedListIterator implements Iterator<E>
   {
	protected LinkEntry<E> current;  
	protected LinkEntry<E> previous;
	protected CS401DbLinkedListIterator(String S)
	{
		if(S=="front")
		{
			current=head;
		}
		else
		{
			current=tail;
		}
		
		}
	
	public E next()
	{
		
		E e=current.element;
		previous=current;
		current=current.next;
		return e;
		
		
	}
	
	public boolean hasNext()
	{
		return current!=null;
	}
	public boolean hasPrevious()
	{
		return current!=null;
	}
	public E previous()
	{
		E e=current.element;
		current=current.previous;
		return e;
	}
   }
   
   
} /* CS401LinkedListImpl<E> */