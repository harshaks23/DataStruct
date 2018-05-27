


public class CS401BSTArrayTest {

	public static void main (String[] args)
	{
		new CS401BSTArrayTest().run();
	}

	public void run ()
	{
		CS401BSTArray<String> tree23 = new CS401BSTArray<String> ();
		CS401BSTArray<Integer> tree23b = new CS401BSTArray<Integer> ();

		tree23.add("dog");
		tree23.add("turtel");
		tree23.add("cat");
		tree23.add("ferret");
		tree23.add("flash");
		tree23.add("naruto");
		tree23.add("dragon ballz");

		
		System.out.println(" The First Binary Tree with strings: ");		
		tree23.details();		
		tree23.remove("flash");
		
		
		System.out.println("1st Binary Search Tree after Removing:  ");
		tree23.details();		

		tree23b.add(1);
		tree23b.add(10);
		tree23b.add(9);
		tree23b.add(23);
		tree23b.add(5);
		tree23b.add(25);
		tree23b.add(18);
		tree23b.add(8);
		tree23b.add(101);


		System.out.println("---\n"+"2nd Binary Tree with Integers: ");		
		tree23b.details();	
		tree23b.remove(9);	
		System.out.println("------\n"+"2nd Binary Search Tree after Removing: ");
		tree23b.details();
		 int i=tree23b.getEntry(18);
		System.out.println("Entry of 18 id is " +(i)+"\n------\n");
        System.out.println("Inorder traveersal of the tree "+tree23b.inorder());
        System.out.println("\n  Trying to remove 101 from position(Index) {{ie detetetreenode}} is "+tree23b.deleteTreeNode(7));
        System.out.println("\nInorder Traversal after removal:"+tree23b.inorder()+"\n");
        tree23b.details();

	}

	
	
}
