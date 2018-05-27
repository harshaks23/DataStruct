import java.util.Iterator;

public class CS401LinkedListImpl<E> implements CS401CollectionInterface<E>,Iterable<E>
{
   protected LinkEntry<E> head;
   protected LinkEntry<E> tail;
   protected int num_elements = 0;
   public Iterator<E> iterator()
   {
	   return new CS401LinkedListIterator();
   }

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
   public E remove(int i)
   {
      /**
       * Add code here. */
	   CS401LinkedListIterator itr=new CS401LinkedListIterator();
	   E e=null;
	      int count=1;
	      if(i==1)
	      {
	    	  LinkEntry<E> temp=head;
	    	  e=temp.element;
	    	  head=head.next;
	    	  temp.next=null;
	    }
	      else
	      {
	      while(count<i)
	      {
	    	itr.next();
	    	e=itr.current.element;
	    	count++;
	      }
	      LinkEntry<E> temp=itr.current;
	      itr.previous.next=temp.next;
	      temp.next=null;
	      }
	      num_elements--;
	    boolean status= contains(e);
	    if (status==true)
	    	return null;
	    else
           return e;
      
      
   }

   /**
    * Determines if e is in the collection. 
    * Hint: Remember lecture on comparison.
    * Returns true if e is in the collection, false otherwise. */
   public boolean contains(E e)
   {
      /**
       * Add code here. */ 
	   boolean flag=false;
	   CS401LinkedListIterator itr=new CS401LinkedListIterator();
	   while(itr.hasNext())
	   {
		   if( itr.next()==e)
		  {
			  flag=true;
		  }
		  itr.next();
	   }
	   
      return flag;
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

      if (where == Where.BACK) {
         tail.next = ne;
         tail = ne;
      }
      else if (where == Where.FRONT)  {
          /**
           * Add code here. */
    	  
    	  ne.next=head;
    	  head=ne;
      }
      num_elements++;
      return true;
   }

   /**
    * Add e to the middle of a linked list.  More specifically, add e
    * after index in the linked list.  First element of the linked list
    * is 0, second is 1, and so on.
    *
    * Returns true if element added, false if where != MIDDLE. */
   public boolean add(Where where, int index, E e)  {

      /**
       * Add code here. */
	   
	   LinkEntry<E> ne = new LinkEntry<E>();
	      ne.element = e;

	      if (head == null && tail == null)
	      {
	          head = tail = ne;
	          num_elements++;
	          return true;
	      }
	      CS401LinkedListIterator itr=new CS401LinkedListIterator();
	      int count=0;
	      while(count<index)
	      {
	    	itr.next();
	    	count++;
	      }
	      LinkEntry<E> temp=itr.current;
	      ne.next=temp;
	      itr.previous.next=ne;
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
 
      /**
       * Add code here. 
       * Traverse the linked list and serialize each object.  Add the
       * serialized form to result. */
      CS401LinkedListIterator itr=new CS401LinkedListIterator();
      while(itr.hasNext())
      {
    	  result.append(itr.next()+",");
      }
      return result.toString();
   }
   

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;
   }
   /* ------------------------------------------------------------------- */
   protected class CS401LinkedListIterator implements Iterator<E>
   {
	  protected LinkEntry<E> current;
	  protected LinkEntry<E> previous;
	  protected CS401LinkedListIterator() { current=head;}
	  
	  public E next()
	  {
		  if(current!=null)
		  {
			  E e = current.element;
			  previous=current;
			  current=current.next;
			  return e;
		  }
		  else
			  return null;
	  }
	  
	  public boolean hasNext()
	  {
		return current!=null;  
	  }
	   
   }

} /* CS401LinkedListImpl<E> */

