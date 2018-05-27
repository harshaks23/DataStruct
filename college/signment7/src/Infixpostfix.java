import java.util.Scanner;

public class Infixpostfix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		Scanner a = new Scanner(System.in);
		Postfixreq  b = new Postfixreq ();
		System.out.println("enter te infix string ");
		s = a.nextLine();
		System.out.println("enter the corespondiing infix string" + s);
		System.out.println("corresponding Output String is:");
		b.postfix(s);
		
		
	
		
	}

	}


