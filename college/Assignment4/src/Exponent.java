import java.util.Scanner;

public class Exponent {

	public static void main(String args[]) {
		double i, j, ans = 1;
while(true){
		Scanner a = new Scanner(System.in);
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
}
	}

	public static long power(long i, int n) {

		long ans = 1;

		{
			if (i == 0 && n == 0  || n>Long.MAX_VALUE)
				throw new IllegalArgumentException("Error Message");

			if (n == 0)
				
				ans = 1;
			
			else

				for (int x = 1; x <= n; x++)

				{

					ans = ans * i;

				}
			
			
			return ans;
		}
	}
}