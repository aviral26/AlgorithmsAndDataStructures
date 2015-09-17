package DirectedWeightedEdgeGraphs;

import java.util.Stack;

public class BellmanFordSP {
	private static final int INF = 999;
	double[] distTo;
	DirectedEdge[] edgeTo;
	int source;
	boolean neg_cycle;
	int neg_cyc_v;
	
	public BellmanFordSP(WeightedEdgeDigraph G, int s){
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		source = s;
		neg_cycle = false;
		neg_cyc_v = -1;
		
		for(int i = 0; i < G.V(); i++){
			distTo[i] = INF;
		}
		distTo[s] = 0.0;

		for(int i = 0; i <G.V(); i++){
			for(int v = 0; v < G.V(); v++){
				for(DirectedEdge e : G.adj[v]){
					relax(e);
				}
			}
		}
		for(int v = 0; v < G.V(); v++){
			for(DirectedEdge e : G.adj[v]){
				relax_check(e);
			}
		}
		
		
	}
	
	private void relax_check(DirectedEdge e) {
		
		int v = e.from();
		int w = e.to();
		if(distTo[w] > distTo[v] + e.weight()){
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			neg_cycle = true;
			neg_cyc_v = w;
		}
		
	}

	private void relax(DirectedEdge e){
		int v = e.from();
		int w = e.to();
		if(distTo[w] > distTo[v] + e.weight()){
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
		}
	}
	
	public double distTo(int v){
		return distTo[v];
	}
	
	public Iterable<DirectedEdge> pathTo(int v){
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		int k = v;
		for(DirectedEdge e = edgeTo[k]; e != null; e = edgeTo[e.from()]){
			path.push(e);
		}
		return path;
	}
	
	public boolean hasNegativeCycle(){
		return neg_cycle;
	}
	
	public Iterable<DirectedEdge> negativeCycle(){
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		int k = neg_cyc_v;
		path.push(edgeTo[k]);
		DirectedEdge e = edgeTo[edgeTo[k].from()];
		for(; e.from() != k; e = edgeTo[e.from()]){
			path.push(e);
			//System.out.println("CHECK: pushing edge of vertex " + e.from());
		}
		path.push(e);
		return path;
	}
}
