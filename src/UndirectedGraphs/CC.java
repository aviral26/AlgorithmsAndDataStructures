package UndirectedGraphs;

public class CC {
	
	private static final int not_defined = -1;
	boolean[] marked;
	int[] id;
	int counter;
	
	public CC(Graph G){
		marked = new boolean[G.V()];
		id = new int[G.V()];
		counter = 0;
		
		for(int i = 0; i < G.V(); i++){
			marked[i] = false;
			id[i] = not_defined;
		}
		
		for(int v = 0; v < G.V(); v++){
			if(marked[v] == false){
				dfs(G,v);
				counter++;
			}
		}
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		id[v] = counter;
		
		for(int w : G.adj[v]){
			if(marked[w] == false){
				dfs(G,w);
			}
		}
	}
	
	public boolean connected(int v, int w){
		return id[v] == id[w];
	}
	
	public int count(){
		return counter;
	}
	
	public int id(int v){
		return id[v];
	}
}
