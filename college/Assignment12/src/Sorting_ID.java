
 import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.*;

	public class Sorting_ID {
		
		public static void main(String[] args) throws FileNotFoundException{
			long startTime;long elepsedTime;double seconds;
			File file = new File("src/students-64000.dat");
			String readLine;
			String[]readLineSplitted;
			Students Quicksort[]= new Students[64000];
				int i=0;
			
			
			Students Mergesort[]= new Students[64000];
			Scanner scanMS = new Scanner(file);
			i=0;
			while(scanMS.hasNextLine()){	
				readLine = scanMS.nextLine();
				readLineSplitted= readLine.split(" ");
				Students student23 = new Students(Long.parseLong(readLineSplitted[3])); 
				Mergesort[i]= student23;
				i=i+1;
			}	
			startTime = System.nanoTime();
			MergeSort.mergeSort(Mergesort);
			elepsedTime = System.nanoTime() - startTime;
			seconds = (double)elepsedTime / 1000000.0;
			System.out.println("Merge Sort of data file based on the ID comparision takes "+seconds+" miliseconds");
			scanMS.close();
			
			
			Students Heapsort[]= new Students[64000];
			Scanner scanHS = new Scanner(file);
			//Reading data into array----------
			i=0;
			while(scanHS.hasNextLine()){	
				readLine = scanHS.nextLine();
				readLineSplitted= readLine.split(" ");
				Students student23 = new Students(Long.parseLong(readLineSplitted[3])); 
				Heapsort[i]= student23;
				i=i+1;
			}	
			startTime = System.nanoTime();
			HeapSort.heapSort(Heapsort);
			elepsedTime = System.nanoTime() - startTime;
			seconds = (double)elepsedTime / 1000000.0;
			System.out.println("Heap Sort of data file based on the ID comparision takes "+seconds+" miliseconds");
			scanHS.close();
			 i=0;
			
			Scanner scanQS = new Scanner(file);
			while(scanQS.hasNextLine()){	
				readLine = scanQS.nextLine();
				readLineSplitted= readLine.split(" ");
				Students student23 = new Students(Long.parseLong(readLineSplitted[3])); 
				Quicksort[i]= student23;
				i=i+1;
			}
			startTime = System.nanoTime();
			QuickSort.quickSort(Quicksort);
			 elepsedTime = System.nanoTime() - startTime;
	 seconds = (double)elepsedTime / 1000000.0;
			System.out.println("Quick Sort of data file based on the ID comparision takes "+seconds+" miliseconds");
			scanQS.close();
			}
	}

