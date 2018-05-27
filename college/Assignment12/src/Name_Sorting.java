

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Name_Sorting {
	
	public static void main(String[] args) throws FileNotFoundException{
		long startTime,elapsedTime;double seconds
		;
		File f = new File("src/students-64000.dat");
		String[] readLineSplited;
		StudentsInfo Quicksort[]= new StudentsInfo[64000];
		int i=0;
	String readLine;
	

	StudentsInfo Heapsort[]= new StudentsInfo[64000];
	Scanner scanHS = new Scanner(f);
	i=0;
	while(scanHS.hasNextLine()){	
		readLine = scanHS.nextLine();
		readLineSplited= readLine.split(" ");
		StudentsInfo student1 = new StudentsInfo(readLineSplited[0] , readLineSplited[1], readLineSplited[2], Long.parseLong(readLineSplited[3])); 
		Heapsort[i]= student1;
		i=i+1;
	}	
	startTime = System.nanoTime();
	HeapSort.heapSort(Heapsort);
	elapsedTime = System.nanoTime() - startTime;
	seconds = (double)elapsedTime / 1000000.0;
	System.out.println("Heap Sort of data file  based on hte name takes "+seconds+" miliseconds");
	scanHS.close();
	
	
	
		
		
		StudentsInfo Mergesort[]= new StudentsInfo[64000];
		Scanner scanMS = new Scanner(f);
		i=0;
		while(scanMS.hasNextLine()){	
			readLine = scanMS.nextLine();
			readLineSplited= readLine.split(" ");
			StudentsInfo student1 = new StudentsInfo(readLineSplited[0] , readLineSplited[1], readLineSplited[2], Long.parseLong(readLineSplited[3])); 
			Mergesort[i]= student1;
			i=i+1;
		}	
		startTime = System.nanoTime();
		MergeSort.mergeSort(Mergesort);
		elapsedTime = System.nanoTime() - startTime;
		seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Merge Sort of data file based onn the name takes "+seconds+" miliseconds");
		scanMS.close();
		
		
		
		
	 i=0;
		Scanner scanQS = new Scanner(f);
		while(scanQS.hasNextLine()){	
			readLine = scanQS.nextLine();
			readLineSplited= readLine.split(" ");
			StudentsInfo student1 = new StudentsInfo(readLineSplited[0] , readLineSplited[1], readLineSplited[2], Long.parseLong(readLineSplited[3])); 
			Quicksort[i]= student1;
			i=i+1;
		}
		 startTime = System.nanoTime();
		QuickSort.quickSort(Quicksort);
		 elapsedTime = System.nanoTime() - startTime;
		 seconds = (double)elapsedTime / 1000000.0;
		System.out.println("Quick Sort of data file based onthe name  takes " + seconds + " miliseconds");
		scanQS.close();
		}
	

}