public class Minimum {

	public static int minimum(int[] A,int size)
	{
	if(size==1)
		return A[0];
	
	int temp;
	for(int i=0;i<size-1;i++)
	{
		if(A[i+1]<A[i])
		{
			temp=A[i];
			A[i]= A[i+1];
			A[i+1]=temp;
			
		}
	}System.out.println(size);
	return minimum(A,size-1);
		
	}
	
	public static void main(String[] args) {
		int[] A = {10,-20,1,2,0,5,100};

		
		int S= minimum(A,A.length);
		System.out.println("minimum value is "+S);
	    
	    

	}

}