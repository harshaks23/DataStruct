
public class CS401QueueLinkedListImpl<E> implements CS401QueueInterface<E>  {
   private LinkEntry<E> head;
   private LinkEntry<E> tail;
   private int num_elements;

   public void add(E element) {

     LinkEntry<E> a= new LinkEntry<E>();
    a.element=element;
    if(head==null && tail==null)
    {
    	head=tail=a;
    }
    else{ tail.next=a;
    tail=a;
    }
    num_elements++;
   }

   public E remove()  {
     E a=head.element;
     head=head.next;
     num_elements--;
     return a;

   }
   public E peek()  {

      if(is_empty())
      {
    	  
    	  return null;
    		
      }
      else return head.element;
   }

   public boolean is_empty()  {

	   return head==null;

   }

   public boolean is_full()  {

     return false;

   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
   }
}