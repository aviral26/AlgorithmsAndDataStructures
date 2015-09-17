package DirectedWeightedEdgeGraphs;

public class DirectedEdge {
	
	private int v, w;
	private double weight;
	
	public DirectedEdge(int v, int w, double wt){
		this.v = v;
		this.w = w;
		this.weight = wt;
	}
	
	public int from(){
		return v;
	}
	
	public int to(){
		return w;
	}
	
	public double weight(){
		return weight;
	}
	
}
