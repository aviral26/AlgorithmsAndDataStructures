package HelperDataStructures;

public class UF {
	
	int[] id;
	int count;
	
	public UF(int N){
		id = new int[N];
		for(int i = 0; i < N; i++){
			id[i] = i;
		}
		count = N;
	}
	
	public void union(int p, int q){
		int pID = find(p);
		int qID = find(q);
		for(int i = 0; i < id.length; i++){
			if(id[i] == qID) id[i] = pID;
		}
		count--;
	}
	
	public int find(int p){
		return id[p];
	}
	
	public boolean connected(int p, int q){
		return id[p] == id[q];
	}
}
