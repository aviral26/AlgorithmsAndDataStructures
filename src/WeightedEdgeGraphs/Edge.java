package WeightedEdgeGraphs;

public class Edge implements Comparable<Edge> {

	int v, w;
	double weight;
	
	public Edge(int v, int w, double weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either(){
		return v;
	}
	public int other(int x){
		if(this.v == x) return w;
		return this.v;
	}
	public double weight(){
		return weight;
	}
	public int compareTo(Edge that) {
		if(this.weight > that.weight) return 1;
		if(this.weight < that.weight) return -1;
		return 0;
	}
}
