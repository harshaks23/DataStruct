
import java.util.Scanner;

public class PascalTriangle {
	
	
   public static void print(int n) {
	   
	   
	   int a=0,b=0;
       int[] previousRow;
       int[] currentRow = {1};
       printArray(currentRow);
       previousRow = currentRow;
       for (int i = 2; i <= n; i++) {
    	   
    	   a++;
           currentRow = new int[i];
           currentRow[0] = 1;
           currentRow[i - 1] = 1;
           
           
           for (int j = 0; j <= i - 3; j++) 
           
           {b++;
               currentRow[j + 1] = previousRow[j] + previousRow[j + 1];
               
               
           }
           
           
           printArray(currentRow);
           previousRow = currentRow;
           
           
       }
       
       System.out.println(a+"  "+b);
       
   }

   
   public static void printArray(int[] array) {
	   
	   
       for (int i = 0; i < array.length; i++) {
 
           System.out.print(array[i] + " ");
  
       }
       
       
       System.out.println();
       
       
   }

   public static void main(String[] args) {
	   
	   
	   final double NANO_FACTOR = 1000000000.0; // nanoseconds per second
   
		final String MESSAGE_2 = " seconds.";
	
		long startTime, finishTime, elapsedTime;
		
	
		while(true){
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter the row number upto which Pascal's triangle has to be printed: ");
       int row = scanner.nextInt();
       startTime = System.nanoTime();
       
       print(row);
       
       finishTime = System.nanoTime();
		elapsedTime = finishTime - startTime;
		System.out.println("\n\nThe total time" + (elapsedTime / NANO_FACTOR) + MESSAGE_2);
   }}
}