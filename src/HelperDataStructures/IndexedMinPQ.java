package HelperDataStructures;

public class IndexedMinPQ {
	private static final double INF = 999.9;
	int count;
	double[] pq;
	int[] index;
	
	public IndexedMinPQ(int c){
		count = 0;
		index = new int[c];
		pq = new double[c];
	}

	public void insert(int s, double item) {
		
		pq[++count] = item;
		index[count] = s;
		swim(count);
		
	}
	
	private void swim(int i){
		int k = i/2;
		while(i > 1 && less(i,k)){
			exch(i,k);
			i = i/2;
		}
	}
	
	private boolean less(int i, int k){
		if(pq[i] < pq[k]) return true;
		return false;
	}
	
	private void exch(int i, int k){
		double t = pq[i];
		pq[i] = pq[k];
		pq[k] = t;
		int x = index[i];
		index[i] = index[k];
		index[k] = x;
	}
	
	public void decreaseKey(int s, double item){
		for(int x = 0; x < count; x++){
			if(index[x] == s){
				pq[x] = item;
				swim(x);
			}
		}
	}
	
	public boolean isEmpty() {
		return count == 0;
	}

	public int delMin() {
		int i = index[1];
		exch(1,count--);
		pq[count+1] = INF;
		sink(1);
		return i;
	}
	
	private void sink(int i) {
		while(2*i <= count){
			int j = 2 * i;
			if (j < count && less(j+1, j)) j++;
			if (less(i, j)) break;
			exch(i, j);
			i = j;
		}
	}


	public boolean contains(int w) {
		for(int i = 0; i < count; i++)
			if(index[i] == w) return true;
		return false;
	}
	
	public int count(){
		return count;
	}
}
