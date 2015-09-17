package DirectedGraphs;

import java.util.Stack;

public class TopologicalSort {
	
	boolean[] marked;
	Stack<Integer> reversepostorder;
	
	public TopologicalSort(Digraph G){
		marked = new boolean[G.V()];
		reversepostorder = new Stack<Integer>();
		for(int i = 0; i < G.V(); i++){
			marked[i] = false;
		}
		for(int i = 0; i < G.V(); i++){
			if(marked[i] == false){
				dfs(G, i);
				reversepostorder.add(i);
			}
		}
	}
	
	private void dfs(Digraph G, int v){
		marked[v] = true;
		for(int w : G.adj[v]){
			if(marked[w] == false){
				dfs(G, w);
				reversepostorder.add(w);
			}
		}
	}
	
	public Iterable<Integer> getSortedList(){
		return reversepostorder;
	}
	
}
