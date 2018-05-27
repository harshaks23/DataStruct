package Lab14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MinSpTr
{
	private ArrayList<Vertex> vertex;
	
	public MinSpTr() {
		vertex = new ArrayList<Vertex>();
	}
	
	public void add(Vertex v) {
		vertex.add(v);
	}
	
	public Vertex getVertex(String name) {
		for (Vertex vertex : vertex) {
			if (vertex.getName().equals(name)) {
				return vertex;
			}
		}
		throw new RuntimeException("No Vertex : " + name);
	}
	
	public ArrayList<Vertex> getVertexs() {
		return vertex;
	}
	
	public void befes(String vertex) {
		Queue<Vertex> queue23 = new LinkedList<Vertex>();
		queue23.add(getVertex(vertex));
		Vertex v = null, destinat = null;
		PriorityQueue<Edge> pqEdges = null;
		Edge edge23 = null;
		while (!queue23.isEmpty()) {
			v = queue23.remove();
			if (v.getState() != 2) {
				this.visitVertex(v);
			}
			pqEdges = v.getPriorityEdges();
			while (!pqEdges.isEmpty()) {
				edge23 = pqEdges.remove();
				destinat = edge23.getDestination();
				if (destinat.getState() == 0) {
					destinat.setState(1);
					queue23.add(destinat);
				}
			}
		}
	}
	
	public void diFeSe(String vertex) {
		Stack<Vertex> stack23 = new Stack<Vertex>();
		Stack<Edge> stackEdges = new Stack<Edge>();
		
		stack23.add(getVertex(vertex));
		Vertex v = null, destinat = null;
		PriorityQueue<Edge> pqEdges = null;
		
		Edge edge23 = null;
		
		while (!stack23.isEmpty()) {
			v = stack23.pop();
			
			if (v.getState() != 2) {
				this.visitVertex(v);
			}
			pqEdges = v.getPriorityEdges();
			while (!pqEdges.isEmpty()) {
				stackEdges.push(pqEdges.remove());
			}
			while (!stackEdges.isEmpty()) {
				edge23 = stackEdges.pop();
				destinat = edge23.getDestination();
				if (destinat.getState() != 2) {
					destinat.setState(1);
					stack23.add(destinat);
				}
			}
		}
	}
	
	protected void visitVertex(Vertex vert) {
		vert.setState(2);
		System.out.print(vert.getName() + " ");
	}
	
	protected void discoverVertex(Vertex vert2) {
		vert2.setState(1);
	}
	
	public void CreaMinSpannTree(Vertex Startver)

	
	
	    {
		
		for (Vertex vertex : this.vertex)

		{
			vertex.setConnected(false);
		}
		
		System.out.println("Start vertex : " + Startver.getName());
		
		PriorityQueue<Edge> PriorQ = new PriorityQueue<Edge>();
		ArrayList<Vertex> ConnectVert = new ArrayList<Vertex>();
		Startver.setConnected(true);
		ConnectVert.add(Startver);
		
		ArrayList<Edge> NeighEdge = Startver.getEdges();
		for (Edge edge23 : NeighEdge)
		
		{
			PriorQ.add(edge23);
		}
	
		int totalCost = 0;
		while (ConnectVert.size() < this.vertex.size()) {
			if (PriorQ.isEmpty()) {
				break;
			}
			Edge edge23 = PriorQ.remove();
			if (edge23.getSource().isConnected() && !edge23.getDestination().isConnected()) {
				
				System.out.println("  Add edge <" + edge23.getSource().getName() +
						", " + edge23.getDestination().getName() + ", " + (double)edge23.getCost() + ">");
				totalCost += edge23.getCost();
				edge23.getDestination().setConnected(true);
				ConnectVert.add(edge23.getDestination());
				NeighEdge = edge23.getDestination().getEdges();
				for (Edge nerghborEdge : NeighEdge) {
					if (edge23.getDestination() != edge23.getSource()) {
						PriorQ.add(nerghborEdge);
					}
				}
			}
		}
		
		System.out.println("Total Cost is : " + totalCost);
		
	}
	
}

