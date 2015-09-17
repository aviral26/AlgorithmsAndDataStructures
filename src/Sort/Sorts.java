package Sort;

public class Sorts <T extends Comparable<T>>{
	
	public void bubbleSort(T[] A){
		int flag = 1;
		for(int i = A.length -1; i >= 0 && flag == 1; i--){
			flag = 0;
			for(int j = 0; j < i - 1; j++){
				if(less(A, j+1,j)){
					exch(A, j+1, j);
					flag = 1;
				}
			}
		}
	}
	
	public void selectionSort(T[] A){
		
		int pos;
		for(int i = 0; i < A.length; i++){
			pos = i;
			for(int j = i+1; j < A.length; j++){
				if(less(A, j, pos)) pos = j;
			}
			exch(A, i, pos);
		}
		
	}
	
	public void insertionSort(T[] A){
		for(int i = 0; i < A.length - 1; i++){
			int j = i+1;
			while(j > 0 && less(A, j, j-1)) exch(A, j, --j);
		}
	}
	
	public void radixSort(String[] A, int radix, int length){
		for(int i = length; i > 0; i--)
			keyIndexSort(A, radix, i-1);
	}
	
	private void keyIndexSort(String[] A, int radix, int pos){
		int[] count = new int[radix + 1];
		String[] aux = new String[A.length];
		
		for(int i = 0; i < A.length; i++)
			count[A[i].charAt(pos) + 1]++;
		
		for(int i = 1; i <= radix; i++)
			count[i] += count[i-1];
		
		for(int i = 0; i < A.length; i++)
			aux[count[A[i].charAt(pos)]++] = A[i]; //important
		
		for(int i = 0; i < A.length; i++)
			A[i] = aux[i];
	}
	
	public void quickSort(T[] A, int first, int last){
		if(first < last){
			int partition = getPartition(A, first, last);
			quickSort(A, first, partition-1);
			quickSort(A, partition + 1, last);
		}
	}
	
	private int getPartition(T[] A, int first, int last){
		int pivot = first;
		int i = first;
		int j = last;
		
		while(i < j){
			while(i <= last && less(A, i, pivot)) i++;
			while(j >= first && less(A, pivot, j)) j--;
			if(i < j) exch(A, i, j);
		}
		exch(A, pivot, i);
		return i;
	}
	
	public void heapSort(T[] A){
		for(int i = (A.length/2) - 1; i >= 0; i--) sink(A, i, A.length - 1);
	
		for(int i = A.length - 1; i >= 0; i--){
			exch(A, 0, i);
			sink(A, 0, i - 1);
		}
	}
	
	private void sink(T[] A, int i, int last){
		
		while(2*i < last){
			int j = (2*i) + 1;
			if((j+1) <= last && less(A, j, j + 1)) j++;
			if(less(A, i, j)){
				exch(A, i, j);
				i = j;
			}
			else break;
		}
	}
	
	public void mergeSort(T[] A, T[] temp, int first, int last){
		if(first == last || last < first) return;
		
		int middle = (last + first) / 2;
		mergeSort(A, temp, first, middle);
		mergeSort(A, temp, middle + 1, last);
		merge(A, temp, first, middle + 1, last);
		
	}
	
	private void merge(T[] A, T[] temp, int left, int right, int last){
		
		int i = left;
		int j = right;
		int k = left;
		
		while(k <= last && i < right && j <= last){
			if(less(A, i, j)) temp[k++] = A[i++];
			else temp[k++] = A[j++];
		}
		
		while(k <= last){
			if(i < right) temp[k++] = A[i++];
			else if(j <= last) temp[k++] = A[j++];
		}
		
		for(int x = left; x <= last; x++)
			A[x] = temp[x];
		
	}
	
	
	private boolean less(T[] A, int x, int y){
		if(A[x].compareTo(A[y]) < 0) return true;
		return false;
	}
	
	private void exch(T[] A, int x, int y){
		T temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}
	
}
