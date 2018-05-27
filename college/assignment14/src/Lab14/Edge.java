package Lab14;


public class Edge implements Comparable<Edge> 
{
	
	private Vertex source;
	private Vertex destination;
	private int cost;
	
	public Edge(Vertex vert, int cost) {
		this.destination = vert;
		this.cost = cost;
	}
	
	public int compareTo(Edge e) {
		if (this.cost < e.cost) {
			return -1;
		} else if (this.cost > e.cost) {
			return 1;
		} else {
			return 0;
		}
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}

