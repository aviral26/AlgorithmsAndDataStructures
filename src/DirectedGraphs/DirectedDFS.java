package DirectedGraphs;

public class DirectedDFS {
	
	public boolean[] marked;
	int[] edgeTo;
	
	public DirectedDFS(Digraph G, Iterable<Integer> s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for(int i = 0; i < G.V(); i++){
			marked[i] = false;
			edgeTo[i] = -1;
		}
		for(int v : s)
			dfs(G, v);
	}
	
	public DirectedDFS(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		for(int i = 0; i < G.V(); i++){
			marked[i] = false;
			edgeTo[i] = -1;
		}
		dfs(G,s);
	}

	private void dfs(Digraph G, int v){
		marked[v] = true;
		
		for(int w : G.adj[v]){
			if(marked[w] == false){
				dfs(G,w);
				edgeTo[w] = v;
			}			
		}
	}
	
}
