

import java.util.*;
import java.io.*;
import java.util.PriorityQueue;
import java.util.Iterator;

public class Breadth
{

 int inf=Integer.MAX_VALUE;
 int adj[][] = {
		/* A   B   C   D   E   F   G   H   I */
		 /* A */{ inf,  8, inf, 10, inf, inf, 12, inf, inf }, 
		 /* B */	{  8, inf, inf, inf, 12, 18, inf, inf, inf },
		 /* C*/{ inf, inf, inf, inf, inf,  2, inf, 10, inf }, 
		 /* D */{ 10, inf, inf, inf, inf,  8, inf, inf, inf },
		 /* E */{ inf, 12, inf, inf, inf, inf, 24, inf, inf },
		 /* F */{ inf, 18,  2, 10, inf, inf, inf, inf, inf },
		 /* G */{ 12, inf, inf, inf, 24, inf, inf, inf, inf }, 
		 /* H */	{ inf, inf, 10, inf, inf, inf, inf, inf, inf }, 
		 /* I */	{ inf, inf, inf, inf, inf, inf, inf,  3, inf }  
	};
	static String vertexLabel[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
     
  	final static int maxi_vertex = 9;
        final static int YES = 1;
        final static int NO = 0;

	final static String message1 = "\n Enter starting vertex (q to Quit): ";
	final static String message2 = "\n\t Bye !!!!!!!\n ";
	final static String message3 = "\n\t Wrong vertex !!!!!!!\n ";


	CS401adj g;


	     

	public static void main(String[] args)
	{
		new Breadth().run();
	}

	void printf(String LINES)
	{
		System.out.println(LINES);
	}
   	void run()
   	{
		while(true) {
			g = new CS401adj();
      			System.out.print(message1);
			Scanner scan1 = new Scanner (System.in);
			String start_vertex1 = scan1.nextLine();
			if( start_vertex1.compareToIgnoreCase("q") == 0 ) {
      				System.out.println(message2);
				return;
			}

			if(validatever(start_vertex1) == false) {
				System.out.println(message3);
			} else {
				System.out.print("For starting of the vertex "+ start_vertex1+" ,breadth-first traversal produces: " );
				String result1 = BreadthFirstTraversal(start_vertex1);
		

				System.out.println(result1);
			       
			}
		}
   	}

	boolean validatever(String verfy)
	{
		for(int i =0; i< maxi_vertex; i++) {
			if(verfy.compareToIgnoreCase(vertexLabel[i]) == 0)
				return true;
		}
		return false;

	}

	String BreadthFirstTraversal(String start_vertex1)
	{
		String result = new String();
		int traversed_ver_flags[] = { NO, NO, NO, NO, NO, NO, NO, NO, NO};

		Queue<String> queue1 = new LinkedList<String>();

		queue1.add(start_vertex1);
		result += start_vertex1 + ", ";
		setTraversedFlag(traversed_ver_flags, start_vertex1);
	
		String verfy = start_vertex1;

		while(queue1.isEmpty() == false){
			g.siciv(verfy);
			while(true) {
				String next_ver = g.gvnbn(verfy);
				if(next_ver != null) {
					if(checkTrav(traversed_ver_flags, next_ver) == false) {
						queue1.add(next_ver);
						result += next_ver + ", ";
						setTraversedFlag(traversed_ver_flags, next_ver);
					} else {

					}
				}else{
					break;
				}	
			}

			queue1.remove();
			verfy = queue1.peek();
		}
		return result;
		
	}
	
	void setTraversedFlag(int flags[], String verfy)
	{
		for(int i=0; i<maxi_vertex; i++){

			if(vertexLabel[i].compareToIgnoreCase(verfy) == 0) {
				flags[i] = YES;
				return;
			}
		}
	}

	boolean checkTrav(int flags[], String verfy)
	{
		for(int i=0; i<maxi_vertex; i++) {
			if(verfy.compareToIgnoreCase(vertexLabel[i]) == 0) {
			       if(flags[i] == YES)
					return true;
			       else
				       return false;
			}
			
		}
		return false;
	}

	class CS401adj
	{

		private Vertex v[] = new Vertex[maxi_vertex];
		int current_vertex_index = inf;
		String current_vertex_label = "";
   		
		public CS401adj()
   		{
	       
	       		for(int i=0; i< maxi_vertex; i++) {
			
				v[i] = new Vertex(vertexLabel[i], i);
		
				for(int j=0; j < maxi_vertex; j++) {
				
					if(adj[i][j] != inf) {
						Edge n = new Edge(vertexLabel[i], vertexLabel[j], adj[i][j]);
						v[i].add_Edge(n);
					}
				}
	   		}
   		}

		public String gvnbn(String verfy)
		{
			if((verfy.compareToIgnoreCase(current_vertex_label) != 0) && (current_vertex_index != inf) ) {
				siciv(verfy);
			}
			return v[current_vertex_index].getNextBestEdge();
		}

		public void siciv(String verfy)
		{
			for(int i=0; i<maxi_vertex; i++) {
				if(verfy.compareToIgnoreCase(v[i].get_label()) == 0) {
					current_vertex_index = i;
					current_vertex_label = v[i].get_label();
					break;
				}
			}
		}
		public int g_v_n_c(String verfy)
		{
			if((verfy.compareToIgnoreCase(current_vertex_label) != 0) && (current_vertex_index != inf) ) {
				siciv(verfy);
			}
			return v[current_vertex_index].getEdgeCount();
		}
	}

}



class Vertex  
{
   private String label;
   private int indexlabel;
   private int Total_Edges;
   private PriorityQueue<Edge> Edges;
   private boolean visted;

   public Vertex(String l, int i) 
   { 
      label = l;
      indexlabel = i;
      Edges = null;
      visted = false;
      Total_Edges = 0;
   }

   public void add_Edge(Edge n) 
   {
      if (Edges == null)
          Edges = new PriorityQueue<Edge>();
      Edges.add(n);
      Total_Edges++;
   }

   public Edge remove_Edge() 
   {
      Edge n = null;

      if (Edges.size() > 0)  {
          n = Edges.peek();
          Edges.remove(n);
      	  Total_Edges--;
      }
      if ( n== null)
	      Total_Edges = 0;
    
      return n;
   }

   public int getEdgeCount()
   {
	   return Total_Edges;
   }

   public String getNextBestEdge()
  
   {
	
	   Edge neigh = remove_Edge();
	   
	   if(neigh != null)
		
		   return neigh.label();
	   else
		   
		   return null;
   }

   public String get_label() { return label; }

   public String toString()
   {
      String prin = "Vertex: " + label + "\n";
      
     prin+= " Edges: \n";

      Iterator<Edge> itr = Edges.iterator();
      while (itr.hasNext())  {
         Edge n = itr.next();
         prin+= n;
      }

      return prin;
   }
}

class Edge implements Comparable<Edge>
{
   private String source;
   private String destination;
   private int cost;

   public Edge(String s, String d, int w)
   {
      source = s; destination = d; cost = w;
   }

   public int compareTo(Edge o)
   {
      if (this.cost < o.cost)
    	  return -1;
      else
    	  if (this.cost > o.cost) 
    		  return 1;
      else return 0;
   }

   public String label()
   {
	   return destination;
   }
   public String toString()
   {
      return "  " + destination + ", cost: " + cost + "\n";
   }
}
