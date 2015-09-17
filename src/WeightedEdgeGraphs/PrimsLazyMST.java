package WeightedEdgeGraphs;

import HelperDataStructures.Bag;
import HelperDataStructures.MinPQ;

public class PrimsLazyMST {

	Bag<Edge> edges;
	MinPQ<Edge> pq;
	boolean[] marked;
	
	public PrimsLazyMST(WeightEdgeGraph G){
		edges = new Bag<Edge>();
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		for(int i = 0; i < G.V(); i++){
			marked[i] = false;
		}
		
		visit(G, 0);
		
		while(!pq.isEmpty()){
			Edge temp = pq.delMin();
			int v = temp.either();
			int w = temp.other(v);
			if(marked[v] && marked[w]) continue;
			edges.add(temp);
			if(marked[v] && !marked[w]) visit(G, w);
			if(!marked[v] && marked[w]) visit(G, v);
		}
	}
	
	private void visit(WeightEdgeGraph G, int v){
		marked[v] = true;
		for(Edge w : G.adj(v)){
			if(!marked[w.other(v)]){
				pq.insert(w);
			}
		}
	}
	
	public Iterable<Edge> edges(){
		return edges;
	}
	
}
