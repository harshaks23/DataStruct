



public class Sort<E> {
    
public static void swap (Object[ ] x, int a, int b) { 
    Object temp = x [a]; 
    x [a] = x [b];
    x [b] = temp; 
}
  
public  <E extends Comparable<E>> void selectionSort(E[] list)
{
    for(int i=0; i<list.length -1; i++)
    {
        int iSmallest = i;

        for(int j=i+1; j<list.length; j++)
        {
            if(list[iSmallest].compareTo((list[j])) > 0  )
            {
                iSmallest = j;
            }
        }
        E iSwap = list[iSmallest];
        list[iSmallest] = list[i];
        list[i] = iSwap;

    }
}

public <T extends Comparable<T>> void insertionSort(T[] elems) {
	          int size = elems.length;
	  
	          for (int outerLoopIdx = 1; outerLoopIdx < size; ++outerLoopIdx) {
	             for (int innerLoopIdx = outerLoopIdx; innerLoopIdx > 0; --innerLoopIdx) {
	                 if (elems[innerLoopIdx - 1].compareTo(elems[innerLoopIdx]) > 0) {
	                     T temp = elems[innerLoopIdx - 1];
	                     elems[innerLoopIdx - 1] = elems[innerLoopIdx];
	                     elems[innerLoopIdx] = temp;
	                 }
	             }
	         }
}

/*public void insertionSort (E[ ] x, Comparator comp)
{
for (int i = 1; i < x.length; i++) {
E v = x[i];
    int j;
    for (j = i - 1; j >= 0; j
    --) {
        if (comp.compare(x[j], v) <= 0) break;
        x[j + 1] = x[j];
    }
    x[j + 1] = v; }
}
*/

public <E> void bubbleSort(E[] unsorted) {
    for(int iter =1; iter< unsorted.length; iter++){
        for(int inner = 0; inner < (unsorted.length - iter); inner ++){
            if((((Comparable) (unsorted[inner])).compareTo(unsorted[inner+1])) > 0){
                E tmp = unsorted[inner];
                unsorted[inner] = unsorted[inner + 1];
                unsorted[inner + 1] = tmp;
            }                
        }
    }
}
/*
public  void bubbleSort (E[ ] x ,Comparator comp) { 
    int finalSwapPos = x.length - 1, swapPos;
 while (finalSwapPos > 0) { 
     swapPos = 0;
  for (int i = 0; i < finalSwapPos; i++) 
      if( comp.compare(x[i],x[i+1]) > 0 ) { 
      swap (x, i, i + 1);
   swapPos = i; } // if finalSwapPos = swapPos; } // while }
} 
}*/
}