package WeightedEdgeGraphs;

import HelperDataStructures.Bag;
import IO.In;

public class WeightEdgeGraph {
	
	int V, E;
	Bag<Edge>[] adj;
	public Bag<Edge> edges;
	
	private WeightEdgeGraph(int v){
		this.V = v;
		this.E = 0;
		adj = (Bag<Edge>[])new Bag[v];
		edges = new Bag<Edge>();
		for(int i = 0; i < V; i++){
			adj[i] = new Bag<Edge>();
		}
	}
	
	public WeightEdgeGraph(In in){
		this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double wt = in.readDouble();
            addEdge(new Edge(v, w, wt));
        }
	}
	
	void addEdge(Edge e){
		int v = e.either();
		adj[v].add(e);
		adj[e.other(v)].add(e);
		edges.add(e);
		this.E++;	
	}
	
	int V(){
		return V;
	}
	
	int E(){
		return E;
	}
	
	public Iterable<Edge> adj(int v){
		return adj[v];
	}
}
