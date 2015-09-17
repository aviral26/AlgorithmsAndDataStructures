package UndirectedGraphs;

import HelperDataStructures.Queue;


public class BreadthFirstPaths {
	
	boolean[] marked;
	int[] edgeTo;
	private static final int not_defined = -1;
	
	BreadthFirstPaths(Graph G, int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		
		for(int i = 0; i < G.V(); i++){
			marked[i] = false;
			edgeTo[i] = not_defined;
		}
		
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s){
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.add(s);
		marked[s] = true;
		
		while(queue.isEmpty() == false){
			int v = queue.remove();
			for(int w : G.adj[v]){
				if(marked[w] == false){
					marked[w] = true;
					edgeTo[w] = v;
					queue.add(w);
				}
			}
		}
		
	}
	
}
