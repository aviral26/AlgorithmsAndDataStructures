package DirectedWeightedEdgeGraphs;

import java.util.Stack;

import HelperDataStructures.IndexedMinPQ;

public class DjikstraSP {

	private static final int INF = 999;
	double[] distTo;
	DirectedEdge[] edgeTo;
	int source;
	IndexedMinPQ pq;
	
	public DjikstraSP(WeightedEdgeDigraph G, int s){
		distTo = new double[G.V()];
		edgeTo = new DirectedEdge[G.V()];
		source = s;
		pq = new IndexedMinPQ(G.V());
		
		for(int i = 0; i < G.V(); i++){
			distTo[i] = INF;
		}
		distTo[s] = 0.0;
		pq.insert(s, 0.0);

		while(pq.isEmpty() == false){
			int k = pq.delMin();
			for(DirectedEdge e : G.adj[k]){
				relax(e);
			}
		}	
		
	}
	
	private void relax(DirectedEdge e){
		int v = e.from();
		int w = e.to();
		if(distTo[w] > distTo[v] + e.weight()){
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			if(pq.contains(w)){
				pq.decreaseKey(w,distTo[w]);
			}
			else{
				pq.insert(w, distTo[w]);
			}
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
	
}
