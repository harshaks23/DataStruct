
import java.util.*;



import java.io.*;

public class Evaluate {
	
	
public static void main (String[] args) throws IOException{
		
	
		Sort<Student1> s=new Sort<Student1>();
		File fis = new File("src/students-64000.dat");
		Scanner input = new Scanner(fis);
                String[] readSep;
		String read;
        int i=0; 
        //Comparator comp = null;
		Student1[] lines = new Student1[64000];
		while(input.hasNextLine()){		
			read = input.nextLine();
			readSep= read.split(" ");
			Student1 info1 = new Student1(readSep[0] , readSep[1], readSep[2], Long.parseLong(readSep[3])); 
			lines[i++] = info1;
		}
		
		input.close();
        long startTime=System.nanoTime();
        s.bubbleSort(lines);
        //System.out.println(lines);
        long elapsedTime = System.nanoTime() - startTime; 
		double sec = (double)elapsedTime / 1000000.0;
		System.out.println("Time taken for bubble sort of the records: "+ (sec) +" miliseconds");
                
        long startTime2=System.nanoTime();
        s.insertionSort(lines);
        long elapsedTime2 = System.nanoTime() - startTime2; 
		double sec1 = (double)elapsedTime2 / 1000000.0;
		System.out.println("Time taken for insertion sort of the records: "+ (sec1) +" miliseconds");
                
        long startTime3=System.nanoTime();
        s.selectionSort(lines);
        long elapsedTime3 = System.nanoTime() - startTime3; 
		double sec2 = (double)elapsedTime3 / 1000000.0;
		System.out.println("Time taken for selection sort of the records: "+ (sec2) +" miliseconds");
                
                
}
}
	
        
		