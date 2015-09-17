package DirectedGraphs;

import HelperDataStructures.Bag;
import IO.In;

public class Digraph {
	
	int V;
	int E;
	public Bag<Integer>[] adj;
	
	public Digraph(In in){
		this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
	}
	
	public Digraph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++){
			adj[v] = new Bag<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		E++;
	}
	
	public int V(){
		return this.V;
	}
	
	public int E(){
		return this.E;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public Digraph reverse(){
		
		Digraph RG = new Digraph(this.V());
		for(int v = 0; v < this.V(); v++){
			for(int w : this.adj[v]){
				RG.adj[w].add(v);
			}
		}
		
		return RG;
		
	}
	
	public String toString(){
		return null;
	}
	
}
