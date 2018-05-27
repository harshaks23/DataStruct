package default123;
import java.util.Arrays;

public class CS401ArrayImpl2<E> {

	private E[] elements;
	   private int num_elements;
	   private int capacity;

	   
	   
	   @SuppressWarnings("unchecked")
	   
	   public CS401ArrayImpl2(int size)
	   
	   {
	      elements = (E[]) new Object[size];
	      num_elements = 0;
	      capacity = size;
	   }

	   @SuppressWarnings("unchecked")
	   public CS401ArrayImpl2()
	   {
		   
	      /**
	       * Call the c'tor that takes the 'size' parameter.  **/
	      this(10);
	   }

	   /**
	    * Methods inherited from CS401CollectionInterface
	    */
	   public boolean is_full()
	   {
	      if (num_elements == capacity)
	          return true;
	      return false;
	   }

	   public boolean is_empty()
	   {
	      if (num_elements == 0) 
	          return true;
	      return false;
	      
	   }

	   public int size() { return num_elements; }

	   public boolean add(E e)  {
	      add(Where.BACK, e);  // Add at the end
	      return true;
	   
	   }

	   /*
	    * Remove element at index i.  If the element exists in the collection, 
	    * return that element back to the user.  If the index is out of bounds,
	    * return null.
	    */
	   public E remove(int index) {
		   E e;
		      if (index < 0 || index > num_elements-1)
		    	  return null;
		     

		      e = elements[index];
		   

		      

	  
	      E[] temp= (E[])new Object [num_elements-1];
	      for(int i=0;i<=num_elements-1;i++){ 
	       if(i<index)
	     	  temp[i]=elements[i];
	       else
	     	  if(i==index)
	     		  temp[i]=elements[i+1];
	       
	       
	     	  else
	     		  
	     		  
	     		  temp[i-1]=elements[i];}
	      
	      
	      elements=temp;
	      num_elements--;

	      return e;
	      
	   }

	   /*
	    * Return true if e is in the collection class, false otherwise.
	    */
	   public boolean contains(E e) {
		   boolean x=false;
	       for(int i=0;i<num_elements;i++)
	       {   
	    	   if(elements[i]==e)
	    	   {  x=true;
	    	   }}
	    	   return x;
	   }

	   /**
	    * ---- Methods defined by this class 
	    * ----------------------------------------------------------
	    * Methods that are added by this class and not in the 
	    * CS401CollectionInterface
	    */

	   /**
	    * Add element in middle.
	    * Preconditions: where == MIDDLE
	    *                index <= num_elements - 1
	    */
	   public boolean add(Where where, int index, E e) { 
	  
	      /* 
	       * If there is no space to add the new element, grow the array. */
	      if (is_full())  {
	          grow();
	      }
	      System.out.println("inserting  element at iddle");
	      E[] temp= (E[])new Object [elements.length+1];
	      for(int i=0;i<=num_elements;i++){ 
	       if(i<index)
	     	  temp[i]=elements[i];
	       else
	     	  if(i==index)
	     		  temp[i]=e;
	     	  else
	     		  temp[i]=elements[i-1];}
	      elements=temp;
	      System.out.println("elements="+elements.length);
	      num_elements++;
	      System.out.println("elements="+elements.length);

	      
	      return true; 
	   }

	   /**
	    * Add element in front or at the end, as dictated by where.
	    * Preconditions: where != MIDDLE
	    */
	   public boolean add(Where where, E e) { 
	   
	      /* 
	       * If there is no space to add the new element, grow the array. */
	      if (is_full())  {
	          grow();
	      }

	      if (where == Where.BACK)  {
	          
	          elements[num_elements] = e;
	          num_elements++;
	      } 
	      else if (where == Where.FRONT)  {
	          System.out.println("Inserting element at index 0");
	          System.out.println("Compacting storage");
	          /*
	           * Add code here.
	           * You will add the new element at index 0, and shift all the
	           * elements down by one. */
	          E[]  temp=(E[])new  Object[elements.length+1];
	          for(int i=0;i<=num_elements;i++)
	          {
	        	  if(i==0)
	        		  temp[i] = e;
	        	  else
	        		  temp[i]=elements[i-1];
	        	  
	          }
	          elements=temp;
	          
	          num_elements++;
	          
	      }

	      return true; 
	   }

	   /*
	    * Gets the element at index i (0 <= i <= num_elements-1)
	    */
	   public E get(int i)  {

	      if (i < 0 && i > num_elements)
	          return null;

	      return(elements[i]);
	   }

	   /**
	    * ----------- Private methods
	    */
	   /*
	    * Grows elements array to hold more elements.  Copies old (existing)
	    * elements in the new array.
	    * 
	    * Postcondition: (a) elements must contain the contents of the old array
	    *                (b) elements must now have twice as much capacity as
	    *                    before
	    */
	  
	   private boolean grow() 
	   
	   {

	      /* 
	       * Add code here 
	       * Expand capacity (double it) and copy old array contents to the
	       * new one. 
	       */
	capacity=capacity*2;
	      System.out.println("Capacity reached.  Increasing storage...");
	     elements= Arrays.copyOf(elements,capacity);
	     System.out.println(elements.length);
	      System.out.println("New capacity is " + capacity + " elements");

	      return true;
	   }
	   
	   public CS401ArrayImpl2 <E> subList(int from,int to){
		   CS401ArrayImpl2<E> temp= new CS401ArrayImpl2<E>(elements.length);
		   temp.elements =Arrays.copyOfRange(elements, from, to);
		  temp.num_elements=temp.elements.length;
		   return temp;
	   }
}
