/* 
 * Fixed front implementation of a Queue using arrays */

public class CS401QueueArrayFixedImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFixedImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) {

      if(is_full())
      {
    	  E[] a = (E[]) new Object[capacity*2];
		   for(int i=front;i<back;i++)
		   {
			   a[i]=data[i];
		   }
		   data=a;
	   }
	   data[back++]=element;  
      }
   

   public E remove()  {
	   E a =null;
	   if(!is_empty())
	   {
		   a=data[front];
	   for(int i=front;i<back-1;i++)
	   {
		   data[i]=data[i+1];
	   }
	   back--;
	   }
	   return a;
   }

   public E peek()  {
if(!is_empty())
	   return data[front];
else
	   return null;
   }

   public boolean is_empty()  {
return front ==back;
   }

   public boolean is_full() 
   {
	   if(back==data.length)
		   return true;
	   else 
		   return false;

   }
}