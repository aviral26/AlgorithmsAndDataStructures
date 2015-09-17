package UndirectedGraphs;
import java.util.Stack;


public class DepthFirstPaths {
	
	private static final int not_defined = -1;
	private boolean[] marked;
	private int[] edgeTo;
	
	public DepthFirstPaths(Graph G, int s){
		
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		
		for(int i = 0; i < G.V(); i++){
			marked[i] = false;
			edgeTo[i] = not_defined;
		}
		
		dfs(G,s);
		
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		
		for(int w : G.adj(v)){
			if(marked[w] == false){
				dfs(G,w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int v){
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		
		if(hasPathTo(v)){
			Stack<Integer> path = new Stack<Integer>();
			int i = v;
			path.add(i);
			while(edgeTo[i] != not_defined){
				path.add(edgeTo[i]);
				i = edgeTo[i];
			}
			return path;
		}
		
		return null;
	}
	
}
