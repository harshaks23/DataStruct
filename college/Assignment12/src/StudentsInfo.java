
public class StudentsInfo implements Comparable<StudentsInfo> {

		  String fname;
		  String lname;
		  String mname;
		  long studentId;
		  
		  public StudentsInfo (String lname,String fname,String mname,long studentId)
		  {
		    this.fname = fname;
		    this.lname = lname;
		    this.mname = mname;
		    this.studentId = studentId;
		  } // constructor
		  
		  public int compareTo (StudentsInfo student)
		  {
		    //final double DELTA = 0.0000001;
			  String fullName = lname+  fname+mname;
			  String OtherFullName = student.lname+student.fname+student.mname;
		    
			if (fullName.compareTo(OtherFullName) < 0 )
				return -1;
			else if (fullName.compareTo(OtherFullName) > 0 )
				return 1;
			else if (fullName.compareTo(OtherFullName) == 0 )
			{
				if (studentId < student.studentId )
				      return -1;
				    else if (studentId > student.studentId )
				      return 1;
				    else 
						return 0;
			}
			else 
				return 0;
				
			  
			
		    } // method compareTo

}
