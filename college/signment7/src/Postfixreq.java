
public class Postfixreq {
	
	public int precedence(char ba)
	{
		if(ba=='+' || ba=='-')
			return 1;
		if(ba=='/'||ba=='*')
			return 2;
		
		return 0;
	}
	
	public boolean isOperator(char operations)
	{
		if(operations=='-'||operations=='*'||operations=='/'||operations=='+')
			return true;
		else
			return false;
	}
	
	public boolean Operand(char character)
	{
		if(character>='0' && character<='9')
			return true;
		else
			return false;
	}
	
	public void postfix (String ab)
	{
		char[] fix = new char[ab.length()];
		
		
		
		CS401StackLinkedListImpl<Character> operations = new CS401StackLinkedListImpl<Character>();
	
		char abc;
		int count=0;
		
		for(int i=0;i<ab.length();i++)
		{
			abc=ab.charAt(i);
			
			
			 if (Operand(abc))
				 
				 
			{
				fix[count++]=abc;
			}
			else
				
				
				
				if(isOperator(abc))
			{
					
					
					
				if( operations.size()==0)
					
					
					
				{
					operations.push(abc);
				}
				
				else
					
					if(precedence(abc)<=precedence(operations.peek()))
						
						
						
				{
						
						
					while(precedence(abc)<=precedence(operations.peek()))
						
						
						
					{
						
						
					fix[count++]=operations.pop();
					
					
					if(operations.size()==0)
						
						
						break;
					}
					
					
					operations.push(abc);
				}
				
				
				else
					operations.push(abc);
			}
			 
			 
		}
		
		
		while(operations.size()!=0)
		 {
			 fix[count++]=operations.pop(); 
		 }
		 
		 for(int j=0;j<fix.length;j++)
			 
			 
		 {
			 System.out.print(fix[j]);
		 }
		
		 CS401StackLinkedListImpl<Integer> list1 = new CS401StackLinkedListImpl<Integer>();
		 
		 for(int i=0;i<fix.length;i++)
		 {
			 
			 if(Operand(fix[i]))
			 
			 {
				 
			 int b=(fix[i]-'0');
				 
			 
			 list1.push(b);
			
			 
			
			 
			 }
			 
			 
			 else
			
				 
			 {
			
				 int x=list1.pop();
				 
				 int y=list1.pop();
				 
				 char c=fix[i];
				 
				 if(c=='+'){
				
					 list1.push(x+y);
				 }
				 
				 else
					 
					 
					 if(c=='-')
					 
					 {
						 
						 
					 list1.push(x-y);
				 }
					 
					 else
					 
					 
					 if(c=='*')
					 {
					 list1.push(x*y);
				 }
					 else
				 
				 {
					 list1.push(x/y);
				 }
			 }
		 }
		System.out.println("\nEvaluation of the postfix string is  "+ list1.pop()); 
		
	}

}
