import java.util.Scanner;

public class power3 {

	public static void main(String args[]) {
		double  ans = 1;
while(true)
	{Scanner a = new Scanner(System.in);
		System.out.println("enter the no");
		long b = a.nextInt();
		System.out.println("Enter the exponent");
		int c = a.nextInt();
		final double NANO_FACTOR = 1000000000.0; // nanoseconds per second
		final String MESSAGE_2 = " seconds.";
		long startTime, finishTime, elapsedTime;
		startTime = System.nanoTime();
		ans = power(b, c);
		
	       
	       finishTime = System.nanoTime();
			elapsedTime = finishTime - startTime;
			System.out.println("\n\nThe total time" + (elapsedTime / NANO_FACTOR) + MESSAGE_2);

		System.out.println("the answer is " + ans);

	}}
	
	
	
	public static long power(long i, int n) {

	

		{
			if (i == 0 && n == 0  || n>Long.MAX_VALUE)
				throw new IllegalArgumentException("Error Message");
			else
				
			if (n == 0)
				
				return 1;
			if (n==1)
				return i;
			if(n%2==0)
				return power(i*i,n/2);
			else
          {
        	   
        	   return i*power(i*i,n/2);
           }
}}}
