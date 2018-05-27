
import java.util.Scanner;
import java.lang.Integer;

public class PascalTriangleRecursion {
	
	
	
	  public static int recursive( int x,  int y) {    
		  
		  
	        if ( x==0 || x == y || y==0    )
	        	
	        	return 1;
	        
	        
	        return recursive(x-1,y) + recursive (x-1,y-1);
	        }

    public static void main(String args[])
    {
        String cba;
        
        
    while(true)
    
    
    { 
    	
    	
    	
       System.out.println("Enter the rows and elementin (x,y ie 2,1) format");
        Scanner abc = new Scanner(System.in);
        cba=abc.nextLine();
        String[] xyz = cba.split(",");
       
        int r = Integer.parseInt(xyz[0]);
        int e = Integer.parseInt(xyz[1]);
        
        
        if (r == 0 || e == 0||r<e  )
        
        {
        	
        System.out.println("Enter as per the valid given discription");}
        
        else
        
        System.out.println("Pascal" + "(" + r +"," + e + ") = " + recursive(r-1,e-1));
    
        
   }        
        
    
    }  
}
