
package Lab14;

import java.util.ArrayList;

public class MinSpTRAdd {
	
	public static void main(String[] args) 
	{
		new MinSpTRAdd().run();
	}

	public void run() {
	MinSpTr graph = new MinSpTr();
		
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		
		graph.add(a);
		graph.add(b);
		graph.add(c);
		graph.add(d);
		graph.add(e);
		graph.add(f);
		
		a.addEdge(new Edge(b, 6));
		a.addEdge(new Edge(c, 5));
		a.addEdge(new Edge(d, 1));
		
		b.addEdge(new Edge(a, 6));
		b.addEdge(new Edge(d, 5));
		b.addEdge(new Edge(e, 3));
		
		c.addEdge(new Edge(a, 5));
		c.addEdge(new Edge(d, 5));
		c.addEdge(new Edge(f, 2));
		
		d.addEdge(new Edge(a, 1));
		d.addEdge(new Edge(b, 5));
		d.addEdge(new Edge(c, 5));
		d.addEdge(new Edge(e, 6));
		d.addEdge(new Edge(f, 4));
		
		e.addEdge(new Edge(b, 3));
		e.addEdge(new Edge(d, 6));
		e.addEdge(new Edge(f, 5));
		
		f.addEdge(new Edge(c, 2));
		f.addEdge(new Edge(d, 4));
		f.addEdge(new Edge(e, 5));
		
		ArrayList<Vertex> vertex23 = graph.getVertexs();
		System.out.println("Begining of  Spanning Tree Prims \n");
		for (Vertex vertex : vertex23) 
		{
			graph.CreaMinSpannTree(vertex);
			System.out.print("\n");
		}
		System.out.println("End  of the Spanning Tree Prim");
	}
}

