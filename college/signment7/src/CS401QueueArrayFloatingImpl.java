/* 
 * Floating front and back implementation of a queue using an array */

public class CS401QueueArrayFloatingImpl<E> implements CS401QueueInterface<E>  {
   private E[] data;
   private int front, back;
   private int capacity;

   public CS401QueueArrayFloatingImpl(int num_elems)   {
      capacity = num_elems;
      data = (E[]) new Object[capacity];
      front = back = 0;    
   }

   public void add(E element) {
	   if(is_full())
	   {
		    capacity=capacity*2;
		    
		   E[] temp = (E[]) new Object[capacity];
		   
		   int i=0;
		   
		   
		   for( i=front;i<back;i++)
		   
		   {
			   temp[i]=data[i];
		   }
		   data=temp;
		   front=0;
		   back++;
		 
		   }
	   else
	   data[back]=element;
	   back=(back+1)%capacity;
   }
   

   public E remove()  {
      
      E a=null;
      if(!is_empty())
   {a=data[front];
   front=(front+1);
		   front=front%capacity;
		 
    	  
   }  return a;
   }
   public E peek()  {
	   if(!is_empty())
		   return data[front];
	   else 
		   return null;


   }

   public boolean is_empty()  {

	   return front==back;

   }

   public boolean is_full()  {

	   return (back+1)%capacity==front;

   }

}