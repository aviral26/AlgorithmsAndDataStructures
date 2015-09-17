package StringProcessing;

public class KeyIndexedSort {
	
	int[] count;
	int[] aux;
	
	public KeyIndexedSort(int[] key, int R){
		
		aux = new int[key.length];
		count = new int[R + 1];
		
		for(int i = 0; i < key.length; i++){
			count[key[i] + 1]++;
		}
		
		for(int i = 0; i < R; i++){
			count[i+1] = count[i] + count[i+1];
		}
		
		for(int i = 0; i < key.length; i++){
			aux[count[key[i]]++] = key[i];
		}
		
		for(int i = 0; i < key.length; i++){
			key[i] = aux[i];
		}

	}
	
}
