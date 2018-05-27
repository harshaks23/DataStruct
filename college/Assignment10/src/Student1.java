
	public class Student1 implements Comparable<Student1> {

		  String firstn;
		  String lastn;
		  String middlen;
		  int x,a;
		  long studentId;
		  
		  public Student1 (String lastn,String firstn,String middlen,long studentId)
		  {
		    this.firstn = firstn;
		    this.lastn = lastn;
		    this.middlen = middlen;
		    this.studentId = studentId;
		  } // constructor
		  
		  public int compareTo (Student1 Student2)
		  {
		    //final double DELTA = 0.0000001;
		    
		    if (studentId < Student2.studentId )
		      return -1;
		    else if (studentId > Student2.studentId )
		      return 1;
		    else if (studentId == Student2.studentId )
		    
		    
		     return 0;
		    
		   
		    
		    else
		    	
		    	return (Integer) null;
		    } // method compareTo

	}



