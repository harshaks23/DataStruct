



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainSort {
	public static void main(String[] args) throws FileNotFoundException{
		
		int i=0;
		String lineper;
		String[] SplittedLine;
	int arrayLength = 64000;
		
		
		
		File f = new File("src/students-64000.dat");
			Student1 Insert_data[]= new Student1[arrayLength];
		Scanner scanner = new Scanner(f);
		
		
		while(scanner.hasNextLine()){	
			lineper = scanner.nextLine();
			SplittedLine= lineper.split(" ");
			Student1 studentsdata1 = new Student1(SplittedLine[0] , SplittedLine[1], SplittedLine[2], Long.parseLong(SplittedLine[3])); 
			Insert_data[i]= studentsdata1;
			i+=1;
		}
		
		
		long startTime = System.nanoTime();
		totalSorts.insertionSort(Insert_data);
		long elepsedTime = System.nanoTime() - startTime;
		double seconds = (double)elepsedTime / 1000000000.0;
		System.out.println("Insertion sort  takes "+seconds+" seconds");
		scanner.close();
		
		Student1 Selection_data[]= new Student1[arrayLength];
		Scanner scanSelection = new Scanner(f);
			i=0;
		while(scanSelection.hasNextLine())
		{	
			lineper = scanSelection.nextLine();
			SplittedLine= lineper.split(" ");
			Student1 studentsdata1 = new Student1(SplittedLine[0] , SplittedLine[1], SplittedLine[2], Long.parseLong(SplittedLine[3])); 
			Selection_data[i]= studentsdata1;
			i+=1;
		}	
		
		
		startTime = System.nanoTime();
		totalSorts.selectionSort(Selection_data);
		elepsedTime = System.nanoTime() - startTime;
		seconds = (double)elepsedTime / 1000000000.0;
		System.out.println("Selection sort  takes "+seconds+" seconds");
		scanSelection.close();
		
		
		
		
		
		
		//foro the bubble sort
		Student1 BubbleSort_data[]= new Student1[arrayLength];
		Scanner scannerbubble = new Scanner(f);
			i=0;
		while(scannerbubble.hasNextLine()){	
			lineper = scannerbubble.nextLine();
			SplittedLine= lineper.split(" ");
			Student1 studentsdata1 = new Student1(SplittedLine[0] , SplittedLine[1], SplittedLine[2], Long.parseLong(SplittedLine[3])); 
			BubbleSort_data[i]= studentsdata1;
			i+=1;
		}	
		
		startTime = System.nanoTime();
		totalSorts.bubbleSort(BubbleSort_data);
		elepsedTime = System.nanoTime() - startTime;
		seconds = (double)elepsedTime / 1000000000.0;
		System.out.println("Bubble sort takes "+seconds+" seconds");
		scannerbubble.close();
		
				
		
	}
}

