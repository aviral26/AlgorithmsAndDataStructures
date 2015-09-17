package HelperDataStructures;

public class MinPQ<T extends Comparable<T>>{
	private int number;
	private static final int MAX = 100;
	T[] PQ;
	//PQ[0] unused
	
	public MinPQ(){
		number = 0;
		PQ = (T[])new Comparable[MAX];
	}
	
	public void insert(T s) {
		PQ[++number] = s;
		swim(number);
	}

	private void swim(int x) {
		while(x > 1 && less(x,x/2)){
			exch(x,x/2);
			x = x/2;
		}
	}

	private boolean less(int x, int i) {
		return PQ[x].compareTo(PQ[i]) == -1;
	}

	public T delMin() {
		T min = PQ[1];
		exch(1,number--);
		PQ[number+1] = null;
		sink(1);
		return min;
	}

	private void sink(int i) {
		while(2*i <= number){
			int j = 2 * i;
			if (j < number && less(j+1, j)) j++;
			if (less(i, j)) break;
			exch(i, j);
			i = j;
		}
		
	}

	private void exch(int i, int j) {
		T temp = PQ[i];
		PQ[i] = PQ[j];
		PQ[j] = temp;
	}

	public boolean isEmpty() {
		return number == 0;
	}
	
	public int size(){
		return number;
	}

}
