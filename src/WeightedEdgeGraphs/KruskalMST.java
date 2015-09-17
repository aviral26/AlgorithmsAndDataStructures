package WeightedEdgeGraphs;

import HelperDataStructures.Bag;
import HelperDataStructures.MinPQ;
import HelperDataStructures.UF;

public class KruskalMST {
	
	Bag<Edge> MSTEdges;
	
	public KruskalMST(WeightEdgeGraph G){
		
		MSTEdges = new Bag<Edge>();
		MinPQ<Edge> minPQ = new MinPQ<Edge>();
		for(Edge w : G.edges){
			minPQ.insert(w);
		}
		
		UF set = new UF(G.V());
		
		while(!minPQ.isEmpty()){
			Edge temp = minPQ.delMin();
			int v = temp.either();
			int w = temp.other(v);
			if(!set.connected(v,w)){
				MSTEdges.add(temp);
				set.union(v,w);
			}
		}
		
	}
	public Iterable<Edge> edges(){
		return MSTEdges;
	}
}
