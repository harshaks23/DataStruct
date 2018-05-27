package Lab14;





import java.util.ArrayList;
import java.util.PriorityQueue;

public class Vertex {
	private String name;
	private int state; 								/* 0: undiscovered; 1: discovered; 2: visited */
	
	private boolean connected;
	
	private ArrayList<Edge> edges;
	
	public Vertex (String name) {
		this.name = name;
	}
	
	public void addEdge(Edge e) {
		if (edges == null) {
			edges = new ArrayList<Edge>();
		}
		e.setSource(this);
		edges.add(e);
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
	public PriorityQueue<Edge> getPriorityEdges() {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		for (Edge edge : edges) {
			pq.add(edge);
		}
		return pq;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}
}

