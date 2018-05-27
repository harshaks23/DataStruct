import java.util.Iterator;

public class CS401LinkedListImpl<E> implements CS401CollectionInterface<E>,Iterable<E>

{
   protected LinkEntry<E> head;
   protected LinkEntry<E> tail;
   protected int num_elements = 0;

   public CS401LinkedListImpl()
   {
      head = tail = null;
   }

   /**
    * Methods inherited from CS401CollectionInterface
    */
   public boolean is_empty()
   {
      if (head == null) 
          return true;

      return false;
   }

   public boolean is_full() { return false; }

   public int size() { return num_elements; }

   /* 
    * Adds element e at the end of the linked list. */
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
   public E remove(int i){
   CS401LinkedListIterator  ab= new CS401LinkedListIterator();
   E e = null;
   int a=1;
   
      if(i<0 | i>num_elements)
    	  
      
      return null;
      else
    	  
    		  
    	  if(i==1)
	      {
	    	  
	    	  e=head.element;
	    	  head=head.next;
	    	  
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
	     
	      }
      
	      num_elements--;
	   if(i==num_elements)
	   {
		   tail=ab.current;
	   }
           return e;
      
   }

   /**
    * Determines if e is in the collection. 
    * Hint: Remember lecture on comparison.
    * Returns true if e is in the collection, false otherwise. */
   public boolean contains(E e)
   {
     CS401LinkedListIterator ab= new CS401LinkedListIterator();
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
   public boolean add(Where where, E e)
   
   
   {

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
         tail.next = ne;
         tail = ne;
      }
      
      
      else if
      (where == Where.FRONT)  
      {
    	  ne.next=head;
          head=ne;
      }
      
      
      num_elements++;
      return true;
   }

   /**
    * Add e to the middle of a linked list.  More specifically, add e
    * after index in the linked list.  
    * First element of the linked list is 1, second is 2, and so on.
    *
    * Returns true if element added, false if where != MIDDLE. */
   public boolean add(Where where, int index, E e)
   
   
   {
	   CS401LinkedListIterator  ab= new CS401LinkedListIterator();
	   int count=1;
	   while(count<index)
	   {
		 ab.next();  
		count++;   
	   }
	   
      LinkEntry<E> a=new LinkEntry<E>();
      
      a.element=e;
      a.next=ab.current.next;
    
     ab.current.next=a;
     
     
     num_elements++;
         return true;
   }

   /**
    * Print the collection class (linked list) by iterating over all of
    * the elements in the collection class and serializing them. 
    * Returns a Java String object that represents the serialization of
    * the collection class. */
   public String toString()  {

      StringBuilder result = new StringBuilder();
 
      CS401LinkedListIterator ab=new CS401LinkedListIterator();
      while(ab.hasNext())
      {
    	  result=result.append(ab.next());
      }

      return result.toString();
   }
   

   protected class LinkEntry<E>
 
   {
      protected E element;
      protected LinkEntry<E> next;
 
   }
   
   public Iterator<E>  iterator() /* From Interface Iterable */
   {  
   return new CS401LinkedListIterator(); 
   
   }
   
   
   protected class CS401LinkedListIterator implements Iterator<E>
   {
  
	   
   protected LinkEntry<E> current;
   protected LinkEntry<E> previous;
   protected CS401LinkedListIterator() 
   { 
	   
	   current = head; 
	   
   }
  
   
   public E next()
   {if(current!=null)
   {
	   
	     E a = current.element;
	    previous=current;
   current=current.next;
   return a;}
   else
	   return null;
   }
   
   
   
   public boolean hasNext() 
   { return current != null; }
   
   } /* class CS401LinkedListIterator() */


  }
   
   
   
   
   
   
   /* ------------------------------------------------------------------- */

 /* CS401LinkedListImpl<E> */
