public class CS401StackArrayImpl<E> implements CS401StackInterface<E> 
{
   private int num_elements;
   private int max_elements;
   private E[] elements;

   public CS401StackArrayImpl(int n)
   {
      max_elements = n; 
      num_elements = 0;
      elements = (E[]) new Object[max_elements];
   }
   /**
    * Push an element on the stack.  If the stack is full, then allocate
    * more memory to hold a new stack, copy existing elements to the new
    * stack and add the new element to the newly enlarged stack.
    * Do not use System.arraycopy().  You are essentially implementing
    * what System.arraycopy() will do when you expand an existing array. **/
   public void push(E e)
   {
      /** Add code here **/
	   if(max_elements==num_elements)
	   { max_elements=max_elements*2;   
		   System.out.println("Increasing the stack size to 2 times ie total="+max_elements);
		   E[] a= (E[]) new Object[max_elements];
		   for(int i=0;i<num_elements;i++)
		   {
			   a[i]=elements[i];
		   }
		   elements=a;
		   elements[num_elements]=e;
		   num_elements++;
		
		   
	   }
	   else
	   { elements[num_elements]=e;
	   num_elements++;
	   }
      return;
   }

   public E pop()
   {
	   if(num_elements<0)
		   return null;
	   else
		   return elements[num_elements--];
     
   }

   public E peek()
   {
      /** Add code here **/
	   return elements[num_elements-1];
   }

   public int size()
   {
     return num_elements;
   }

} /* CS401StackArrayImpl<E> */