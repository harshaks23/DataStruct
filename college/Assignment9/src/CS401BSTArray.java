

import java.util.*;

public class CS401BSTArray<E> {
	
	final static int NULL=-1;
	protected ArrayList<TreeNode<E>> tree;
	protected int root=NULL;
	protected int size=0;
	
	public CS401BSTArray(){
		size=0;
		root=NULL;
		tree = new ArrayList<TreeNode<E>>();
	}
	
	public static class TreeNode<E>
	{
		protected E element;
		protected int right=NULL;
		protected int left=NULL;
		protected int parent;
		
		public TreeNode(){};
		
		public TreeNode(E element,int parent)
		{
			this.element=element;
			this.parent=parent;
			this.left=NULL;
			this.right=NULL;
			
		}
	}
	
	public boolean add (E element)
	{
		if(root==NULL)
		{
			if(element==null)
			{
				System.out.println("Exception");
				throw new NullPointerException();
			}
			root=0;
			TreeNode<E> A =	new TreeNode<E> (element,NULL);
			tree.add(root,A);
			size++;
			}
		else
		{
			addElement(element,root);
		}
		return true;
	}
	
	private boolean addElement(E element, int pos)
	{
		TreeNode root=tree.get(pos);
		int comp=((Comparable) element).compareTo(root.element);
		if(comp==0)
		{
			return false;
		}
		if(comp<0)
		{
			if(root.left!=NULL)
			{
				return addElement(element,root.left);
			}
			else
			{
				root.left=size;
				tree.set(pos,root);
				TreeNode<E> A = new TreeNode<E> (element,pos);
				tree.add(root.left,A);
				size++;
				return true;
			}
		}
		
		else if (comp>0)
		{
			if(root.right!=NULL)
				return addElement(element,root.right);
			
			else
			{
				root.right=size;
				tree.set(pos,root);
				TreeNode<E> A = new TreeNode<E> (element,pos);
				tree.add(root.right,A);
				size++;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean contains(E element)
	{
		int count=0;
		TreeNode A = tree.get(0);
		while(count++ < size)
		{
			int comp = ((Comparable)element).compareTo(A.element);
			if(comp==0)
				return true;
			else if (comp < 0)
				A=tree.get(A.left);
			else if(comp>0)
				A=tree.get(A.right);
         }
		return false;
	}
	
	public int size()
	{
		return size;
	}

	
	public boolean remove(E element)
	{
		if (element == null)
			throw new NullPointerException();
		int count = 0;
		int elementIndex = NULL;
		TreeNode A = tree.get(root);
		elementIndex = root;
		while(count++ < size)
		{
			int compare = ((Comparable)element).compareTo(A.element);
		        if(compare == 0){
				break;
			}
			else if(compare < 0) {
				elementIndex = A.left;
				A = tree.get(A.left);
			}
			else if(compare > 0) {
				elementIndex = A.right;
				A = tree.get(A.right);
			}

		}
		if (elementIndex == NULL)
			return false;
		else
		{
			if(A.left != NULL && A.right != NULL) {
				TreeNode removeNode = A;
				int removeNodeIdx = elementIndex;
				elementIndex = A.right;
				A= tree.get(A.right);
				while(A.left != NULL)
				{
					elementIndex = A.left;
					A = tree.get(A.left);
				}
				removeNode.element = A.element;
				tree.set(removeNodeIdx, removeNode);
			}
			
		
			if((A.left == NULL) && (A.right == NULL))
			{
				System.out.println("remove: Leaf Node");
				TreeNode parent = tree.get(A.parent);
				if(parent.left == elementIndex) {
				
					parent.left = NULL;
					tree.set(A.parent, parent);
					return true;
				}else if(parent.right == elementIndex) {
					parent.right = NULL;
					tree.set(A.parent, parent);
					return true;
				}else {
					return false;
				}
			}else
			{	
				int replaceNodeIdx = NULL;
				if(A.left != NULL)
					replaceNodeIdx = A.left;
				else 
					replaceNodeIdx = A.right;
				TreeNode replaceNode = tree.get(replaceNodeIdx);

				replaceNode.parent = A.parent;
				if(replaceNode.parent == NULL)
				{
					replaceNodeIdx = root;
				}else if(elementIndex == replaceNode.left)
				{
					replaceNode.left = replaceNodeIdx;

				}else if(elementIndex == replaceNode.right)
				{
					replaceNode.right = replaceNodeIdx;
				}
				tree.set(elementIndex, replaceNode);
				
				for(int j = (elementIndex+1); j < size; j++)
				{
					TreeNode node = tree.get(j);
					TreeNode nodeParent = tree.get(node.parent);
					if(nodeParent.left == j)
						nodeParent.left = j - 1;
					else if(nodeParent.right == count)
						nodeParent.right = j - 1;
					tree.set(node.parent, nodeParent);
					tree.set(j - 1, node);
				}
				
			}

		}
		size--;
		System.out.println("Remove: " +  element);
			return false;
	}
	
	
	public void details()
	{
		System.out.println("\tSize of Tree :" + size);
		System.out.println("\tIndex |Element  | parent | left | right |" );

		for(int i =0 ;i< size; i++)
		{
			TreeNode ele = tree.get(i);
			System.out.print("\t"+i+". ");
			System.out.print("\t"+ele.element);
			System.out.print("\t\t"+ele.parent);
			System.out.print("\t"+ele.left);
			System.out.println("\t"+ele.right);
		}
		System.out.println();
		System.out.println();
	}
	
	
	
	 protected int getEntry (Object obj) 
	    {
	        int compare;
int a=-1;
	        if (obj == null)
	           throw new NullPointerException();
	       for(int i=0;i<tree.size();i++)
	       {
	    	   compare =  ((Comparable)obj).compareTo(tree.get(i).element);
	       
	       if(compare==0){
	    	  a=i;
	    	  }
	       }
	       return a;
	    } 
	 
	 protected int deleteTreeNode (int p) 
	    {
	        size--;

	             if (tree.get(p).left != -1 && tree.get(p).right != -1) 
	        {
	            int s = successor (p);
	            tree.get(p).element = tree.get(s).element;
	            p = s;
	        } 
	        int replacement;
	         
	        if (tree.get(p).left != -1)
	            replacement = tree.get(p).left;
	        else
	            replacement =tree.get(p).right;

	          if (replacement != -1) 
	        {
	            tree.get(replacement).parent = tree.get(p).parent;
	            if (tree.get(p).parent == -1)
	                root = replacement;
	            else if (p == tree.get((tree.get(p).parent)).left)
	            	tree.get((tree.get(p).parent)).left  = replacement;
	            else
	            	tree.get((tree.get(p).parent)).right = replacement;
	        }  
	        else if ((tree.get(p).parent) == -1)
	            root = 0;
	        else 
	        {
	            if (p == tree.get((tree.get(p).parent)).left)
	            	tree.get((tree.get(p).parent)).left = -1;
	            else
	            	tree.get((tree.get(p).parent)).right = -1;        
	        } // p has a parent but no children
	        return p;
	    } // method deleteEntry

	 
	 protected int successor (int e) 
	    {
	        if (e == -1)
	            return -1;
	        else if (tree.get(e).right != -1) 
	        {
	                 int p = tree.get(e).right;
	            while (tree.get(p).left != -1)
	                p = tree.get(p).left;
	            return p;

	        }   else 
	        {

	                   int p = tree.get(e).parent;
	            int ch = e;
	            while (p != -1 && ch == tree.get(p).right) 
	            {
	                ch = p;
	                p = tree.get(p).parent;
	            } // while
	            return p;
	        } }
	 
	 
	 public String inorder(){
		 String S="";
		 TreeNode<E> var;
		 for(int i=0;i<size;i++)
			 for(int j=i+1; j<size;j++)
			 {
				 int comp=((Comparable)tree.get(i).element).compareTo(tree.get(j).element);
				 if(comp>0)
				 {
					 var=tree.get(i);
					 tree.set(i, tree.get(j));
					 tree.set(j,var);
				 }
						 
			 }
		 
		 for(int m=0;m<size;m++)
			 S+=" "+tree.get(m).element;
		 return S;
	 }

   
	

	
	
	
	
	
	
	
	
	
	
	
	

}
