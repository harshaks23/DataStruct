
import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class Compare {
	
	
public static void main (String[] args) throws IOException{
		
	CS401LinkedListImpl<Student1> LinkedList = new CS401LinkedListImpl<Student1>();
		CS401BST<Student1> StudentBST = new CS401BST<Student1>(); 
		
		File file = new File("src/students-64000.dat");
		
		String readLine;
		String[] splittedline;
		Scanner scan1 = new Scanner(file);
		
			long startTime = System.nanoTime();
		while(scan1.hasNextLine()){	
			readLine = scan1.nextLine();
			splittedline= readLine.split(" ");
			Student1 student1 = new Student1(splittedline[0] , splittedline[1], splittedline[2], Long.parseLong(splittedline[3])); 
			LinkedList.add(student1);
		}
		long elepsedTime = System.nanoTime() - startTime; 
		double seconds = (double)elepsedTime / 1000000.0;
		System.out.println("Time taken to load the records in a linked list: "+ (seconds) +" miliseconds");
			scan1.close();
		
	
		
		//reading for binary search tree
		Scanner scan = new Scanner(file);
		long startTime3 = System.nanoTime();
		while(scan.hasNextLine()){	
			readLine = scan.nextLine();
			splittedline= readLine.split(" ");
			Student1 student = new Student1(splittedline[0] , splittedline[1], splittedline[2], Long.parseLong(splittedline[3])); 
			StudentBST.add(student);
		}
		long elepsedTime3 = System.nanoTime() - startTime3; 
		seconds = (double)elepsedTime3 / 1000000.0;
		System.out.println("Time taken to load the records in a binary search tree : "+ (seconds) +" miliseconds");
		
		scan.close();	
		
		calculation(483293267,LinkedList);

		calculation(1902997270,LinkedList);

		calculation(856408684,LinkedList);

		calculation(143507366,LinkedList);

		calculation(307954472,LinkedList);

		calculation(876561221,LinkedList);
}


		
		public static  void calculation(long id,CS401LinkedListImpl<Student1> LinkedList)
		{
			
CS401BST<Student1> StudentBST= new CS401BST<Student1>();
			System.out.println("\n\n");
			System.out.println("Searching for student ID "+id);
			Student1 s1 = new Student1(null, null, null, id);
			Student1 temp = null;
			long startTime = System.nanoTime();
			for(Student1 k : LinkedList){
				if(k.studentId == s1.studentId)
					temp =k;
			}
			if(temp==null){
				System.out.println("No record with this key found, Student not found");
			}else
				System.out.println("Success (record found): "+temp.lastn+ "  " + temp.firstn + temp.middlen + "  " + temp.studentId);
			double  elepsedTime = System.nanoTime() - startTime;
			double seconds = (double)elepsedTime / 1000000.0;
			System.out.println("Searching time in a random linked list : "+ (seconds) +" miliseconds");
			
				startTime = System.nanoTime();
			CS401BST.TreeNode<Student1> sResult = StudentBST.getTreeNode(s1);
			elepsedTime = System.nanoTime() - startTime;
		//	System.out.println(elepsedTime);
			 seconds = (double)elepsedTime / 1000000.0;
			System.out.println("Searching time in a binary search tree : "+ (seconds) +" miliseconds");
			
			
			
			
		}





}
