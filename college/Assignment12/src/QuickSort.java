
import java.util.*;

public class QuickSort
{
 
	
	public static void quickSort(Object[] a)
	   {
	       quicksort1(a, 0, a.length-1);
	   }
	   
	
   public static void quickSort(Integer a[])
   {
       quicksort1(a, 0, a.length-1);
   }
   
   public static void quicksort1(Object[] a, int left, int right)
   {
      if (left < right)
      {
          int pi = (left+right)/2;
          int newPivotIndex = partition(a, left, right, pi);
          quicksort1(a, left, newPivotIndex-1);
          quicksort1(a, newPivotIndex+1, right);
      }
   }
   
   public static void quicksort1(Integer a[], int left, int right)
   {
      if (left < right)
      {
          int pi = (left+right)/2;
          int newPivotIndex = partition(a, left, right, pi);
          quicksort1(a, left, newPivotIndex-1);
          quicksort1(a, newPivotIndex+1, right);
      }
   }

   public static int partition(Object[] a, int left, int right, int pivotIndex)
   {
      Object pivot;
      Object tmp;
	int i, storeIndex;

      pivot = a[pivotIndex];

      tmp = a[pivotIndex];      
      a[pivotIndex] = a[right];
      a[right] = tmp;

     storeIndex = left;
     for (i = left; i < right; i++)
     {
        if (((Comparable)a[i]).compareTo(pivot) < 0)
        {
           tmp = a[storeIndex];      
           a[storeIndex] = a[i];
           a[i] = tmp;
    
           storeIndex++;
        }
     }

     tmp = a[right];               
     a[right] = a[storeIndex];          a[storeIndex] = tmp;

     return storeIndex;
   }
   
   public static int partition(Integer a[], int left, int right, int pivotIndex)
   {
      int pivot;
      int tmp, i, storeIndex;

      pivot = a[pivotIndex];

      tmp = a[pivotIndex];       
      a[pivotIndex] = a[right];
      a[right] = tmp;

     storeIndex = left;
     for (i = left; i < right; i++)
     {
        if (a[i] < pivot)
        {
           tmp = a[storeIndex];      
           a[storeIndex] = a[i];
           a[i] = tmp;
    
           storeIndex++;
        }
     }

     tmp = a[right];                
     a[right] = a[storeIndex];      
     a[storeIndex] = tmp;

     return storeIndex;
   }
}

