package UndirectedGraphs;

import HelperDataStructures.Bag;
import IO.In;

public class Graph{
	
	private int V;
	private int E;
	public Bag<Integer>[] adj;
	
	Graph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++){
			adj[v] = new Bag<Integer>();
		}
	}
	
	public Graph(In in){
		this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }     
	}
	
	public int V(){
		return this.V;
	}
	
	public int E(){
		return this.E;
	}
	
	Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public static int degree(Graph G, int v){
		int deg = 0;
		for(int w : G.adj(v)){
			deg = deg + 1;
		}
		return deg;
	}
	
	public static int maxDegree(Graph G){
		int max = 0; 
		for(int v = 0; v < G.V(); v++){
			if(degree(G,v) > max){
				max = degree(G,v);
			}
		}
		return max;
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	
	public static double averageDegree(Graph G){
		return 2 * G.E() / G.V();
	}
	
	public static int numberOfSelfLoops(Graph G){
		int num = 0;
		for(int v = 0; v < G.V(); v++){
			for(int w : G.adj(v)){
				if(v == w)num++;
			}
		}
		return num; //cross check
	}

}
