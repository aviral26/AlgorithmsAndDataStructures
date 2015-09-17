package DirectedGraphs;

import java.util.Stack;

//KOSARAJU SHARIR ALGORITHM

public class SCC {
	
	Stack<Integer> postorder;
	int[] rpo;
	boolean[] marked;
	public int[] scc;
	int scc_id;
	
	public SCC(Digraph G){
		marked = new boolean[G.V()];
		postorder = new Stack<Integer>();
		scc = new int[G.V()];
		scc_id = 0;
		
		for(int i = 0; i < G.V(); i++){
			marked[i] = false;
			scc[i] = -1;
		}
		
		Digraph RG = G.reverse();
		System.out.println("SCC CHECK: The ReverseDigraph is as follows");
		for(int i = 0; i < RG.V(); i++){
			for(int w : RG.adj[i]){
				System.out.println(i + " ---> " + w);
			}
		}
		for(int i = 0; i < RG.V(); i++){
			if(marked[i] == false){
				dfs_rpo(RG, i);
				postorder.push(i);
			}
		}
		
		for(int i = 0; i < G.V(); i++){
			marked[i] = false;
			//scc[i] = -1;
		}
		
		/*rpo = new int[postorder.size()];
		int k = postorder.size();
		for(int i : postorder){
			rpo[--k] = i;
		}
		
		for(int w : rpo){
			if(marked[w] == false){
				dfs_scc(G, w);
				scc_id++;	
			}
		}*/
		
		
		int temp = postorder.size();
		for(int w = 0; w < temp; w++){
			int v = postorder.pop();
			if(marked[v] == false){
				dfs_scc(G, v);
				scc_id++;	
			}
		}
	}
	
	private void dfs_rpo(Digraph RG, int v){
		marked[v] = true;
		for(int w : RG.adj[v]){
			if(marked[w] == false){
				dfs_rpo(RG, w);
				postorder.push(w);
			}
		}
	}
	
	private void dfs_scc(Digraph G, int v){
		marked[v] = true;
		scc[v] = scc_id;
		for(int w : G.adj[v]){
			if(marked[w] == false){
				dfs_scc(G, w);
			}
		}
	}

	public boolean connected(int i, int j) {
		return scc[i] == scc[j];
	}
	
	public int count(){
		return scc_id;
	}
	
	public Iterable getPostOrderList(){
		return postorder;
	}
	
}
