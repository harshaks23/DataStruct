import java.util.Iterator;

public class CS401StackLinkedListImpl<E> implements CS401StackInterface<E> 
{
   private LinkEntry<E> head;
   private int num_elements;

   public CS401StackLinkedListImpl()
   {
      head = null;
      num_elements = 0;
   }

   public void push(E e)
   {
      /** Add code here **/
	   LinkEntry<E> a= new LinkEntry<E>();
	   a.element=e;
	   if(head==null)
	   {
		   head=a;
	   }
	   
	   else{
		   a.next=head;
	   head=a;
	   }
	   num_elements++;
      return;
   }

   public E pop()
   {
	  E e =head.element;
	  head=head.next;
	  num_elements--;
	  return e;
      /** Add code here **/
   }

   public E peek()
   {
	 return  head.element;
      /** Add code here **/
   }

   public int size()
   {
      return num_elements;
   }

   /* ------------------------------------------------------------------- */
   /* Inner classes                                                      */
   protected class LinkEntry<E>
   {
      protected E element;
      protected LinkEntry<E> next;

      protected LinkEntry() { element = null; next = null; }
   }
} /* CS401StackLinkedListImpl<E> */