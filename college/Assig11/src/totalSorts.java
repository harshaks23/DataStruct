


import java.util.*;

public class totalSorts
{  
  
   
   public static void insertionSort (Object[] x) 
   {
      for (int i = 1; i < x.length; i++)
         for (int j = i; j > 0 && ((Comparable)x [j -1]).compareTo (x [j]) > 0; j--)
         swap (x, j, j -1);
   } // method insertionSort
  
  
   
   @SuppressWarnings("unchecked")
public static void selectionSort (Object [] x) 
   {
      
      for (int i = 0; i < (x.length - 1); i++) 
      {
         int pos = i;
         for (int k = i + 1; k < x.length; k++)
           if (((Comparable)x [k]).compareTo (x [pos]) < 0) 
            pos = k;
        swap (x, i, pos);
      } // for i
   } // method selectionSort
  
  
   
   public static void bubbleSort (Object[] x) 
   {
      int finalSwapPos = x.length - 1,
            swapPos;              
    
      while (finalSwapPos > 0)
      {
         swapPos = 0;
         for (int i = 0; i < finalSwapPos; i++)
           if (((Comparable)x [i]).compareTo (x [i + 1]) > 0)
          {
           
        	   swap (x, i, i + 1);
            swapPos = i;
          
          } // if
         finalSwapPos = swapPos;             
      } // while      
   } // method bubbleSort   
  
   
   public static void swap (Object [] x, int a, int b) 
   {
      Object t = x[a];
      x[a] = x[b];
      x[b] = t;
   } // method swap
  
}//class ComparableSorts

