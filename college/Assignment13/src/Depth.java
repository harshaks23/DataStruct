
import java.util.*;
import java.io.*;
import java.util.PriorityQueue;
import java.util.Iterator;

public class Depth {

	int inf = Integer.MAX_VALUE;
	int adj[][] = {
			/* A B C D E F G H I */
			/* A */{ inf, 8, inf, 10, inf, inf, 12, inf, inf }, /* B */ { 8, inf, inf, inf, 12, 18, inf, inf, inf },
			/* C */{ inf, inf, inf, inf, inf, 2, inf, 10, inf }, /* D */{ 10, inf, inf, inf, inf, 8, inf, inf, inf },
			/* E */{ inf, 12, inf, inf, inf, inf, 24, inf, inf }, /* F */{ inf, 18, 2, 10, inf, inf, inf, inf, inf },
			/* G */{ 12, inf, inf, inf, 24, inf, inf, inf, inf },
			/* H */ { inf, inf, 10, inf, inf, inf, inf, inf, inf },
			/* I */ { inf, inf, inf, inf, inf, inf, inf, 3, inf } };
	static String verLabel[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
	final static String message1 = "\nEnter the  starting vertex (q to Quit): ";
	final static String message2 = "\n\t Bye Bye !!!!!!\n ";
	final static String message3 = "\n\t Wrong vertex !!!!!\n ";
	final static int YES = 1;
	final static int NO = 0;
	final static int MAX_ver = 9;
	

	
	CS401Graph g;
	public static void main(String[] args) {
		new Depth().run();
	}

	void printf(String line) {
		
		
		System.out.println(line);
	
	}

	void run() {
		while (true) {

			g = new CS401Graph();
			System.out.print(message1);
			Scanner scan1 = new Scanner(System.in);
			String starting_vertex = scan1.nextLine();

			if (starting_vertex.compareToIgnoreCase("q") == 0) {

				System.out.println(message2);
				
				return;
			
			}

			if (validation(starting_vertex) == false) {
				System.out.println(message3);
			} else {
				System.out.print("For starting vertex " + starting_vertex + " , the depth-first traversal produces: ");
				String result = DepthFirstTraversal(starting_vertex);
				System.out.println(result);

			}
		}
	}

	boolean validation(String verify) {
		for (int i = 0; i < MAX_ver; i++) {
			if (verify.compareToIgnoreCase(verLabel[i]) == 0)
				return true;
		}
		
		
		return false;

		
	}

	
	
	String DepthFirstTraversal(String starting_vertex) {
		String result = new String();
			int ttraversedflags[] = { NO, NO, NO, NO, NO, NO, NO, NO, NO };

		Stack<String> stack = new Stack<String>();
		stack.push(starting_vertex);
		
		result += starting_vertex + ", ";
		setTraversedFlag(ttraversedflags, starting_vertex);

		String verify = starting_vertex;
		while (stack.isEmpty() == false) {
			g.svc(verify);
			String next_ver = g.gvnb(verify);
			if (next_ver != null) {
				if (checkTrav(ttraversedflags, next_ver) == false) {
					stack.push(next_ver);
					result += next_ver + ", ";
					setTraversedFlag(ttraversedflags, next_ver);
					verify = next_ver;
				} else {

				}
			} else {
				verify = stack.pop();
				if (verify != null) {
					g.svc(verify);
					if (g.gvnc(verify) > 0)
						stack.push(verify);
				}

			}

		}
		return result;

	}

	void setTraversedFlag(int flags[], String verify) {
		for (int i = 0; i < MAX_ver; i++) {

			if (verLabel[i].compareToIgnoreCase(verify) == 0) {
				flags[i] = YES;
				return;
			}
		}
	}

	boolean checkTrav(int flags[], String verify) {
		for (int i = 0; i < MAX_ver; i++) {
			if (verify.compareToIgnoreCase(verLabel[i]) == 0) {
				if (flags[i] == YES)
					return true;
				else
					return false;
			}

		}
		return false;
	}

	class CS401Graph {

		private Vertex v[] = new Vertex[MAX_ver];
		int current_vertex_index = inf;
		String current_vertex_label = "";

		public CS401Graph() {

			for (int i = 0; i < MAX_ver; i++) {

				v[i] = new Vertex(verLabel[i], i);

				for (int j = 0; j < MAX_ver; j++) {

					if (adj[i][j] != inf) {
						Edge n = new Edge(verLabel[i], verLabel[j], adj[i][j]);
						v[i].add_Edge(n);
					}
				}
			}
		}

		public String gvnb(String verify) {
			if ((verify.compareToIgnoreCase(current_vertex_label) != 0) && (current_vertex_index != inf)) {
				svc(verify);
			}
			return v[current_vertex_index].getNextBestEdge();
		}

		public void svc(String verify) {
			for (int i = 0; i < MAX_ver; i++) {
				if (verify.compareToIgnoreCase(v[i].get_label()) == 0) {
					current_vertex_index = i;
					current_vertex_label = v[i].get_label();
					break;
				}
			}
		}

		public int gvnc(String verify) {
			if ((verify.compareToIgnoreCase(current_vertex_label) != 0) && (current_vertex_index != inf)) {
				svc(verify);
			}
			return v[current_vertex_index].getEdgeCount();
		}
	}

}

class Vertex1 {
	private String labels;
	private int ilabel;
	private int totaledges;
	private PriorityQueue<Edge1> Edges;
	private boolean visited;

	public Vertex1(String l, int i) {
		labels = l;
		ilabel = i;
		Edges = null;
		visited = false;
		totaledges = 0;
	}

	public void add_Edge(Edge1 n) {
		if (Edges == null)
			Edges = new PriorityQueue<Edge1>();
		Edges.add(n);
		totaledges++;
	}

	public Edge1 remove_Edge() {
		Edge1 n = null;

		if (Edges.size() > 0) {
			n = Edges.peek();
			Edges.remove(n);
			totaledges--;
		}
		if (n == null)
			totaledges = 0;
		return n;
	}

	public int getEdgeCount() {
		return totaledges;
	}

	public String getNextBestEdge() {
		Edge1 neigh = remove_Edge();
		if (neigh != null)
			return neigh.labels();
		else
			return null;
	}

	public String get_label() {
		return labels;
	}

	public String toString() {
		String ab = "  Vertex :  " + labels + "\n";

		ab += " Edges: \n";

		Iterator<Edge1> itr = Edges.iterator();
		while (itr.hasNext()) {
			Edge1 n = itr.next();
			ab += n;
		}

		return ab;
	}
}



class Edge1 implements Comparable<Edge1> {
	private String source;
	private String dest;
	private Integer cost;

	public Edge1(String s, String d, int w) {
		source = s;
		dest = d;
		cost = w;
	}

	public int compareTo(Edge1 o) {
		if (this.cost < o.cost)
			return -1;
		else if (this.cost > o.cost)
			return 1;
		else
			return 0;
	}

	public String labels() {
		return dest;
	}

	public String toString() {
		return "  " + dest + " , cost: " + cost + "\n";
	}
}
