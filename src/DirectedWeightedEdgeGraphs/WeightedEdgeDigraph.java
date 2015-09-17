package DirectedWeightedEdgeGraphs;

import WeightedEdgeGraphs.Edge;
import HelperDataStructures.Bag;
import IO.In;

public class WeightedEdgeDigraph {
	
	int V, E;
	Bag<DirectedEdge>[] adj;
	public Bag<DirectedEdge> edges;
	
	WeightedEdgeDigraph(int v){
		this.V = v;
		this.E = 0;
		adj = (Bag<DirectedEdge>[])new Bag[V];
		edges = new Bag<DirectedEdge>();
		for(int i = 0; i < V; i++){
			adj[i] = new Bag<DirectedEdge>();
		}
	}
	
	public WeightedEdgeDigraph(In in){
		this(in.readInt());
		E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double wt = in.readDouble();
            addDiEdge(new DirectedEdge(v, w, wt));
        }
	}
	
	public void addDiEdge(DirectedEdge e){
		this.adj[e.from()].add(e);
		edges.add(e);
	}
	
	public int V(){
		return V;
	}
	
	int E(){
		return E;
	}
	
}
