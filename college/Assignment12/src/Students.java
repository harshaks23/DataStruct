

public class Students implements Comparable<Students> {
	long studentId;

	public Students(long studentId) {
		this.studentId = studentId;
	}
	
	public int compareTo (Students student)
	  {
	    //final double DELTA = 0.0000001;
		  
			if (studentId < student.studentId )
			      return -1;
			    else if (studentId > student.studentId )
			      return 1;
			    else if (studentId == student.studentId )
				      return 0;
			    else 
					return (Integer) null;
		}  
			    } // method compareTo
	
	

